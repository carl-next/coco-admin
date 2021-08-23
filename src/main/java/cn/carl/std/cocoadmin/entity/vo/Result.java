package cn.carl.std.cocoadmin.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhangtao
 * @Title: Result
 * @Package: cn.carl.std.cocoadmin.entity.vo
 * @Description: service统一返回结果定义
 * @date 3/14/21 8:28 PM
 */
@Data
public class Result<T> implements Serializable {

    /**
     * 通信数据
     */
    private T data;
    /**
     * 通信状态
     */
    private boolean flag = true;
    /**
     * 通信描述
     */
    private String msg = "操作成功";

    private Result(T data) {
        this.data = data;
    }

    private Result(T data, boolean flag) {
        this.data = data;
        this.flag = flag;
    }

    private Result(T data, boolean flag, String msg) {
        this.data = data;
        this.flag = flag;
        this.msg = msg;
    }

    /**
     * 通过静态方法获取实例
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> of(T data) {
        return new Result<>(data);
    }

    /**
     * 通过静态方法获取实例
     *
     * @param data
     * @param flag
     * @param <T>
     * @return
     */
    public static <T> Result<T> of(T data, boolean flag) {
        return new Result<>(data, flag);
    }

    /**
     * 通过静态方法获取实例
     *
     * @param data :通信数据
     * @param flag :通信状态
     * @param msg  :通信描述
     * @param <T>
     * @return
     */
    public static <T> Result<T> of(T data, boolean flag, String msg) {
        return new Result<>(data, flag, msg);
    }
}
