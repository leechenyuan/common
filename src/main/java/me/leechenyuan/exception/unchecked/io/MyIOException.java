package me.leechenyuan.exception.unchecked.io;

import me.leechenyuan.exception.unchecked.base.BaseEnrichableException;

/**
 * Created by L on 2015/7/21.
 */
public class MyIOException extends BaseEnrichableException{
        public  MyIOException(String msg){
               super(msg);
        }
    public  MyIOException(Throwable cause){
               super(cause);
        }
    public  MyIOException(String msg,Throwable cause){
        super(msg,cause);
    }
}
