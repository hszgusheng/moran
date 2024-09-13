package com.situ.chronicmange.common;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 *公共返回对象
 * @author admin
 */
@Data
public class ResponseBean<T> {
    // 返回请求代码
    private Integer code;
    // 返回数据
    private T res;
    // 返回提示信息
    private String msg;

    private ResponseBean(HttpStatus status) {
        this.code = status.value();
    }

    private ResponseBean(Integer status) {
        this.code = status;
    }

    private ResponseBean(HttpStatus status, String msg) {
        this.code = status.value();
        this.msg = msg;
    }

    private ResponseBean(Integer status, String msg) {
        this.code = status;
        this.msg = msg;
    }

    private ResponseBean(HttpStatus status, String msg, T res) {
        this.code = status.value();
        this.msg = msg;
        this.res = res;
    }

    private ResponseBean(Integer status, String msg, T res) {
        this.code = status;
        this.msg = msg;
        this.res = res;
    }

    public ResponseBean() {

    }

    public static <T> ResponseBean<T> ok() {
        return new ResponseBean<>(HttpStatus.OK);
    }

    public static <T> ResponseBean<T> ok(T body) {
        return ok(HttpStatus.OK, body);
    }

    public static <T> ResponseBean<T> ok(String msg, T body) {
        return ok(HttpStatus.OK, msg, body);
    }

    public static <T> ResponseBean<T> ok(HttpStatus status, T body) {
        return ok(status, (String) null, body);
    }

    public static <T> ResponseBean<T> ok(HttpStatus status, String msg, T body) {
        return new ResponseBean<>(status, msg, body);
    }

    public static <T> ResponseBean<T> ok(Integer status, T body) {
        return new ResponseBean<>(status, (String) null, body);
    }

    public static <T> ResponseBean<T> failed(HttpStatus status) {
        return new ResponseBean<>(status);
    }

    public static <T> ResponseBean<T> failed(String msg) {
        return new ResponseBean<>(500, msg);
    }

    public static <T> ResponseBean<T> failed(HttpStatus status, String msg) {
        return new ResponseBean<>(status, msg);
    }

    public static <T> ResponseBean<T> failed(HttpStatus status, String msg, T body) {
        return new ResponseBean<>(status, msg, body);
    }

    public static <T> ResponseBean<T> failed(Integer status) {
        return new ResponseBean<>(status);
    }

    public static <T> ResponseBean<T> failed(Integer status, String msg) {
        return new ResponseBean<>(status, msg);
    }

    public static <T> ResponseBean<T> failed(Integer status, String msg, T body) {
        return new ResponseBean<>(status, msg, body);
    }


    @Override
    public String toString() {
        return "ResponseBean{code=" + this.code + ", res=" + this.res + ", msg='" + this.msg + "'}";
    }

}
