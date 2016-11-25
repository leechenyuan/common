package me.leechenyuan.template;

import com.roundwith.utils.LoggerUtil;
import me.leechenyuan.exception.unchecked.base.BaseEnrichableException;
import me.leechenyuan.template.io.FileInputStreamProcessingTemplate;
import me.leechenyuan.template.io.InputStreamProcessor;
import me.leechenyuan.util.exception.BasicRichableExceptionHandler;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by L on 2015/7/21.
 */
public class TestTemplate {
    @Test
    public void catchExce(){
        try {
            readFile("e://tmp/url.txt");
        }catch (RuntimeException e){
            LoggerUtil.getLogger().debug("toString : "+e.toString());
        }
    }
    @Test
    public void sniffException(){

        //测试一下异常
        try {
            readFile("f：shuaige");
        }catch (RuntimeException e){
            Throwable cause = e.getCause();
            int depth = 0 ;
            while(cause.getCause() != null){
                cause = cause.getCause() ;
                depth ++ ;
            }
            LoggerUtil.getLogger().error("cause depth: "+depth);

            LoggerUtil.getLogger().error("cause : " + cause.toString());
            StackTraceElement [] arr = e.getStackTrace();
            for(int i=0;i<arr.length;i++){
                StackTraceElement element = arr[i];
               LoggerUtil.getLogger().error(element.getFileName()+"-"+element.getClassName() +":"+element.getMethodName()+":"+element.getLineNumber());
            }
        }

    }
    @Test
    public void throwUncheckedException(){
        readFile("f：、、");
    }

    /**
     * 读取文件内容，不判断编码格式
     * @param fileName
     */
    private void readFile(String fileName){
        final StringBuffer content = new StringBuffer(); //实际上，final和非final对于我们有影响吗？
        FileInputStreamProcessingTemplate.process(fileName, new InputStreamProcessor() {
            @Override
            public void process(InputStream inputStream) throws IOException {
                int ch = inputStream.read();
                while (ch != -1) {
                    LoggerUtil.getLogger().debug("char : "+ch);
                    content.append((char)ch);
                    ch = inputStream.read();
                }
            }
        });
        LoggerUtil.getLogger().debug(content.toString());
    }


    @Test
    public void testExceptionProgate(){
        methodC();
    }
    public void  methodA() throws  IOException{
        //throw new IOException("hi");
        String fileName = "e:\\tmp\\tmpw.txt";
        InputStream inputStream = new FileInputStream(fileName);
    }

    public void  methodB() throws BaseEnrichableException{
        try{
            methodA();
        }catch (Exception e){
            BasicRichableExceptionHandler.INSTANCE.handle(null,e);
        }
    }
    public void  methodC() throws BaseEnrichableException{
        try{
            methodB();
        }catch (Exception e){
            BasicRichableExceptionHandler.INSTANCE.handle(null,e);
        }
    }
}
