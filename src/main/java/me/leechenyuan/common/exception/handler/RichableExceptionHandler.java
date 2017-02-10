package me.leechenyuan.common.exception.handler;

/**
 * * Created by lee chenyuan on 2015/8/3.
 */
public interface RichableExceptionHandler {
    /**
     * 处理异常
     * @param msg
     * @param cause
     */
    public void handle(String msg,Throwable cause);
}
