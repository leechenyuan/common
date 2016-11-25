package me.leechenyuan.template.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by L on 2015/7/21.
 */
public interface InputStreamProcessor {
    public void process(InputStream inputStream) throws IOException;
}
