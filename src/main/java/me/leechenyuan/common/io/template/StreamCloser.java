package me.leechenyuan.common.io.template;

import me.leechenyuan.common.exception.handler.BasicRichableExceptionHandler;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by L on 2015/7/21.
 */
public class StreamCloser {
    public static void close(Closeable cl) {
        if(cl != null){
            try {
                cl.close();
            } catch (IOException e) {
                BasicRichableExceptionHandler.INSTANCE.handle(e.getMessage(),e);
            }
        }
    }
}
