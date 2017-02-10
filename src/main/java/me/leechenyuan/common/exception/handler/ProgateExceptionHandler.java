package me.leechenyuan.common.exception.handler;

import com.google.common.base.Throwables;

/**
 * Created by L on 17/2/6.
 */
public class ProgateExceptionHandler implements RichableExceptionHandler{
    @Override
    public void handle(String msg, Throwable cause) {
//        BasicRichableExceptionHandler.INSTANCE.handle(msg,cause);
        Throwables.propagate(cause);
    }
}
