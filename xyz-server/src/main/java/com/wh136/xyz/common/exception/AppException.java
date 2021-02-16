package com.wh136.xyz.common.exception;

import org.apache.commons.lang3.StringUtils;
import org.apache.naming.StringManager;


/**
 * 应用类异常的业务逻辑封装类，所有底层异常均封装为此异常
 * */
public class AppException extends RuntimeException{

    private static StringManager sm = StringManager.getManager(AppException.class);

    /*错误码*/
    private int errorCode = 0;

    /*错误完整信息*/
    private Object[] data = null;

    /*错误数据*/
    private Object errorData;

    public AppException(int errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public AppException(String message) {
        super(message);
    }

    /*cause:封装异常信息*/
    public AppException(int errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    public AppException(int errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public AppException(int errorCode, Object... data) {
        super();
        this.errorCode = errorCode;
        this.data = data;
    }

    public AppException(int errorCode, String message, Object... data) {
        super(message);
        this.errorCode = errorCode;
        this.data = data;
    }

    public AppException(int errorCode, Throwable cause, Object... data) {
        super(cause);
        this.errorCode = errorCode;
        this.data = data;
    }

    public AppException(int errorCode, String message, Throwable cause, Object... data) {
        super(message, cause);
        this.errorCode = errorCode;
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        String msg = super.getMessage();
        /*如果有主动设置错误信息，以主动设置的错误信息为准，不适用ErrorCode获取的信息*/
        if (StringUtils.isNotEmpty(msg)) {
            return msg;
        } else {
            return getErrorMessage(data);
        }
    }

    public String getErrorMessage(Object... data) {
        return getErrorMessage(errorCode, data);
    }

    public static String getErrorMessage(int errorCode, Object... data) {
        if (data != null) {
            return sm.getString("errorCode." + errorCode, data);
        } else {
            return sm.getString("errorCode." + errorCode);
        }
    }


    @Override
    public String getMessage() {
        String msg = super.getMessage();
        String errMsg = "[" + errorCode + "-" + getErrorMessage() + "]";
        return msg == null ? errMsg : msg;
    }

    public String getMessageWithoutCode() {
        return super.getMessage();
    }

    public void setData(Object... data) {
        this.data = data;
    }
}
