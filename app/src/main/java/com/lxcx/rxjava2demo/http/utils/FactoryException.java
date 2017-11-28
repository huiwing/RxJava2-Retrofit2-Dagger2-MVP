package com.lxcx.rxjava2demo.http.utils;

import android.net.ParseException;
import android.util.Log;

import com.google.gson.JsonParseException;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import org.json.JSONException;

import java.net.ConnectException;

/**
 * FactoryException
 * Created by ArmyAntAndroid on 2017/11/27.
 */

//@SuppressWarnings("all")
public class FactoryException {
    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;

    /**
     * 解析异常
     *
     * @param e Throwable
     * @return RespThrowable
     */
    public static ApiException analysisException(Throwable e) {
        //RespThrowable ex;
        ApiException ex;
        Log.i("tag", "e.toString = " + e.toString());
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            ex = new ApiException(e, ERROR.HTTP_ERROR);
            switch (httpException.code()) {
                case UNAUTHORIZED:
                case FORBIDDEN:
                case NOT_FOUND:
                case REQUEST_TIMEOUT:
                case GATEWAY_TIMEOUT:
                case INTERNAL_SERVER_ERROR:
                case BAD_GATEWAY:
                case SERVICE_UNAVAILABLE:
                default:
                    ex.setCode(httpException.code());
                    ex.setMessage("网络错误");
                    break;
            }
            return ex;
        } else if (e instanceof ServerException) {
            ServerException resultException = (ServerException) e;
            ex = new ApiException(resultException, resultException.code);
            ex.setMessage(resultException.message);
            return ex;
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            ex = new ApiException(e, ERROR.PARSE_ERROR);
            ex.setMessage("解析错误");
            return ex;
        } else if (e instanceof ConnectException) {
            ex = new ApiException(e, ERROR.NETWORK_ERROR);
            ex.setMessage("网络连接失败");
            return ex;
        } else if (e instanceof javax.net.ssl.SSLHandshakeException) {
            ex = new ApiException(e, ERROR.SSL_ERROR);
            ex.setMessage("证书验证失败");
            return ex;
        } else {
            ex = new ApiException(e, ERROR.UNKNOWN);
            ex.setMessage("未知错误");
            return ex;
        }
    }


    /**
     * 约定异常
     */
    class ERROR {

        /**
         * 错误请求
         */
        public static final int REQUEST_ERROR = 400;
        /**
         * 未授权
         */
        public static final int PERMISSION_DENIED = 401;
        /**
         * 凭证错误
         */
        public static final int CRED_ERROR = 402;
        /**
         * 未找到方法
         */
        public static final int NOT_FOUND = 404;
        /**
         * 方法禁用
         */
        public static final int METHOD_BAN = 405;
        /**
         * 方法不成功
         */
        public static final int METHOD_ERROR = 406;
        /**
         * 数据库连接不成功
         */
        public static final int SQL_ERROR = 407;
        /**
         * 请求超时
         */
        public static final int REQUEST_TIMEOUT = 408;
        /**
         * 需要有效长度
         */
        public static final int LENGTH_ERROR = 411;
        /**
         * 请求实体过大
         */
        public static final int DATABIG_ERROR = 413;
        /**
         * 服务器内部错误
         */
        public static final int SERVER_ERROR = 500;

        /**
         * 未知错误
         */
        public static final int UNKNOWN = 1000;
        /**
         * 解析错误
         */
        public static final int PARSE_ERROR = 1001;
        /**
         * 网络错误
         */
        public static final int NETWORK_ERROR = 1002;
        /**
         * 协议出错
         */
        public static final int HTTP_ERROR = 1003;

        /**
         * 证书出错
         */
        public static final int SSL_ERROR = 1005;
    }

    /**
     * ServerException发生后，将自动转换为RespThrowable返回
     */
    private class ServerException extends RuntimeException {
        int code;
        String message;
    }
}
