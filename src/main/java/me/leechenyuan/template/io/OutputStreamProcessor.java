package me.leechenyuan.template.io;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by L on 2015/7/21.
 */
public interface OutputStreamProcessor {
    public void process(OutputStream inputStream) throws IOException;
}
