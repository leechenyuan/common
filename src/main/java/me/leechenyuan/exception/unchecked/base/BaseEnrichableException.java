package me.leechenyuan.exception.unchecked.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by L on 2015/7/21.
 */
public class BaseEnrichableException extends RuntimeException{
    public BaseEnrichableException(){
        super();
    }
    public BaseEnrichableException(String msg){
        super(msg);
    }
    public BaseEnrichableException(Throwable cause){
        super(cause);
    }
    public BaseEnrichableException(String msg,Throwable cause){
        super(msg,cause);
    }
}
