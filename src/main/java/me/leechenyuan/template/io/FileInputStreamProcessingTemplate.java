package me.leechenyuan.template.io;

import me.leechenyuan.exception.unchecked.io.MyIOException;
import me.leechenyuan.util.exception.BasicRichableExceptionHandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by L on 2015/7/21.
 */
public class FileInputStreamProcessingTemplate {
    public static void process(String fileName,InputStreamProcessor inputStreamProcessor){
        InputStream inputStream  = null ;
        try{
            inputStream = new FileInputStream(fileName);
            inputStreamProcessor.process(inputStream);
        } catch (IOException e) {
            BasicRichableExceptionHandler.INSTANCE.handle("error openning or handling the file : "+fileName,e);
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    BasicRichableExceptionHandler.INSTANCE.handle("error closing the file : "+fileName,e);
                }
            }
        }
    }
}
