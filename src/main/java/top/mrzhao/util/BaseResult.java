package top.mrzhao.util;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by ZY on 2018/3/13.
 */
public class BaseResult {
    /**
     * 400 错误，将返回消息提示给用户
     */
    private int code;
    private String message;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String token;
    private Object data;

    public BaseResult() {
    }

    public BaseResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResult(int code, String message, String token, Object data) {
        this.code = code;
        this.message = message;
        this.token = token;
        this.data = data;
    }

    public static BaseResult createOk(Object data) {
        return createOk(data, "");
    }

    public static BaseResult createOk(Object data, String msg) {
        BaseResult result = new BaseResult();
        result.data = data;
        result.code = 200;
        result.message = msg;
        return result;
    }

    public static BaseResult create(int code, Object data, String msg) {
        BaseResult result = new BaseResult();
        result.data = data;
        result.code = code;
        result.message = msg;
        return result;
    }

    public static BaseResult createFail(int code, Object messageOrData) {
        BaseResult result = new BaseResult();
        result.code = code;
        if (messageOrData instanceof CharSequence) {
            result.message = messageOrData.toString();
        } else {
            result.data = messageOrData;
        }
        return result;
    }

    public static BaseResult createNetworkFail() {
        BaseResult result = new BaseResult();
        result.code = 400;
        result.message = "NETWORK ERROR";
        return result;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static BaseResult createDataNotFound() {
        BaseResult result = new BaseResult();
        result.code = 404;
        result.message = "Data not found.";
        return result;
    }

    @JsonIgnore
    public boolean isOk() {
        return code == 200;
    }

    public static BaseResult createBadRequest() {
        BaseResult result = new BaseResult();
        result.code = 500;
        result.message = "BAD REQUEST";
        return result;
    }
}
