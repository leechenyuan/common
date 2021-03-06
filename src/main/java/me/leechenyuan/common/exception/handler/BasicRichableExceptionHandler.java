package me.leechenyuan.common.exception.handler;

import me.leechenyuan.common.exception.unchecked.base.BaseEnrichableException;

/**
 * * Created by lee chenyuan on 2015/8/3.
 */
public enum BasicRichableExceptionHandler implements RichableExceptionHandler {
    INSTANCE;
    @Override
    public void handle(String msg, Throwable cause) {
        if(!(cause instanceof BaseEnrichableException)){
            throw new BaseEnrichableException(cause) ;
        }else{
            BaseEnrichableException e = (BaseEnrichableException)cause;
            throw  e;
        }
    }
}
