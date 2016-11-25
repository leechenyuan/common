package me.leechenyuan.template.io;

import me.leechenyuan.exception.unchecked.io.MyIOException;

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
                throw new MyIOException("error closing ");
            }
        }
    }
}
