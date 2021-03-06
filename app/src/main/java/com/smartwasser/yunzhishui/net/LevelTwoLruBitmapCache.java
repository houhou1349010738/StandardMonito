package com.smartwasser.yunzhishui.net;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

import org.seny.android.utils.MD5Utils;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 二级图片缓存帮助类
 * 内存缓存LruCache + 磁盘缓存DiskLruCache
 *
 * Created by xiongmc on 2015/12/23.
 */
public class LevelTwoLruBitmapCache implements ImageLoader.ImageCache {

    private Context mContext;
    //磁盘缓存最大值
    private static final int DISK_MAX_SIZE = 10 * 1024 * 1024;  //10M
    //内存缓存类
    private static LruCache<String, Bitmap> mLruCache;
    //磁盘缓存类(外置存储/sdcard)
    private static DiskLruCache mDiskLruCache;

    public LevelTwoLruBitmapCache(Context context) {
        mContext = context;
        //获取应用可占内存的1/8作为缓存
        int maxSize = (int)Runtime.getRuntime().maxMemory() / 8;
        //实例化LruCache对象
        mLruCache = new LruCache<String, Bitmap>(maxSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                //测量每一个bitmap的大小
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        };

        //实例化DiskLruCache对象
        try {
            mDiskLruCache = DiskLruCache.open(getDiskCacheDir(mContext, "bitmaps"), getAppVersion(context), 1, DISK_MAX_SIZE);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 从缓存(内存缓存,磁盘缓存)中获取Bitmap
     * @param url 缓存图片是以键值对形式保存的，根据键url找值bitmap
     * @return 缓存图片
     */
    @Override
    public Bitmap getBitmap(String url) {
        if (mLruCache.get(url) != null) {
            return mLruCache.get(url);
        } else {
            String key = MD5Utils.encode(url);
            try {
                if (mDiskLruCache.get(key) != null) {
                    //从磁盘缓存DiskLruCache取
                    DiskLruCache.Snapshot snapshot = mDiskLruCache.get(key);
                    Bitmap bitmap = null;
                    if (snapshot != null) {
                        bitmap = BitmapFactory.decodeStream(snapshot.getInputStream(0));
                        //从磁盘缓存取出来之后，证明你用了，也要往内存缓存存一次
                        mLruCache.put(url, bitmap);
                    }
                    return bitmap;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 存入缓存(内存缓存 + 磁盘缓存)
     * @param url 图片的url地址，做键
     * @param bitmap 图片对象，做值
     */
    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        //首先直接存储LruCache缓存
        mLruCache.put(url, bitmap);

        String key = MD5Utils.encode(url);  //存储在外存上，最好不用明文
        try {
            //判断是否存在DiskLruCache缓存，若没有则存入
            if (mDiskLruCache.get(key) == null) {
                DiskLruCache.Editor editor = mDiskLruCache.edit(key);
                if (editor != null) {
                    OutputStream outputStream = editor.newOutputStream(0);
                    if (bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)) {
                        editor.commit();
                    } else {
                        editor.abort();
                    }
                }
                mDiskLruCache.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取磁盘缓存地址（sdcard/Android/data/"packageName"/cache/"dirName"）
     * @param context
     * @param dirName 磁盘缓存地址的目录名
     * @return
     */
    private File getDiskCacheDir(Context context, String dirName) {
        String cachePath;
        if ((Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && context.getExternalCacheDir() != null)
        {
            //ALog.i(context + "---" + context.getExternalCacheDir());
            cachePath = context.getExternalCacheDir().getPath();
        } else {
            cachePath = context.getCacheDir().getPath();
        }
        return new File(cachePath + File.separator + dirName);
    }

    /**
     * 获取应用的版本号
     * @param context
     * @return
     */
    private int getAppVersion(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
