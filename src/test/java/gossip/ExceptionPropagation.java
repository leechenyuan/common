package gossip;

import org.junit.Test;

import java.util.IllegalFormatCodePointException;

/**
 * Created by L on 2015/7/19.
 */
public class ExceptionPropagation {
    @Test
    public void t(){
        methodA();
    }

    @Test
    public void tryUnChecked(){
        try {
            throwUnCkeckedExcep();
        }catch (RuntimeException runExcep){
            System.out.println("catch a runtime exception");
        }
    }
    private void methodA(){
        methodB();
    }


    private void methodB() throws IllegalArgumentException{
        throw new IllegalArgumentException();
    }

    private void throwUnCkeckedExcep(){
        throw  new UnCheckedException();
    }
    class UnCheckedException extends RuntimeException{
    }
}
