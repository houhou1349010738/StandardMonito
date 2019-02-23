package com.smartwasser.yunzhishui.net;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.smartwasser.yunzhishui.App;
import com.smartwasser.yunzhishui.bean.ErrorResponse;

import org.seny.android.utils.ALog;
import org.seny.android.utils.MD5Utils;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * 自定义Request, 通过gson把json格式的response解析成bean对象，另外请求自带缓存功能
 * <p/>
 * Created by xiongmc on 2015/12/23.
 */
public class GsonRequest<T> extends Request<T> {
    private final Gson gson = new Gson();
    private final Class<? extends T> clazz;
    private final Map<String,Object> params;
    private final Response.Listener<T> listener;
    private boolean isCache;

    /**
     * 初始化
     *
     * @param method        请求方式
     * @param url           请求地址
     * @param params        请求参数，可以为null
     * @param clazz         Clazz类型，用于GSON解析json字符串封装数据
     * @param listener      处理响应的监听器
     * @param errorListener 处理错误信息的监听器
     */
    public GsonRequest(int method, String url, Map<String,Object> params, Class<? extends T> clazz,
                       Response.Listener<T> listener, Response.ErrorListener errorListener, boolean isCache) {
        super(method, url, errorListener);
        this.clazz = clazz;
        this.params = params;
        this.listener = listener;
        this.isCache = isCache;
    }

    public Gson getGson() {
        return gson;
    }

    public Class<? extends T> getClazz() {
        return clazz;
    }
    @Override
    public Map<String,Object> getParams() {
        return params;
    }
    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(
                    response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            ALog.d("" + json);

            T result = null;
            try {
                result = gson.fromJson(json, clazz);    //解析json
                if (isCache) {
                    //如果解析成功，并且需要缓存则将json字符串缓存到本地
                    ALog.i("Save response to local!");
                    FileCopyUtils.copy(response.data, new File(App.application.getCacheDir(), "" + MD5Utils.encode(getUrl())));
                }
            } catch (JsonSyntaxException e) {
                result = (T) gson.fromJson(json, ErrorResponse.class);//解析失败，按规范错误响应解析
            }  catch (IOException e) {
                e.printStackTrace();
            }
            return Response.success(
                    result,
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }
    }
}