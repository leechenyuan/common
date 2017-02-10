package me.leechenyuan.common.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by L on 17/1/15.
 */
public class AsyncService {
    private static ExecutorService executorService = loadExecutorService();
    public static void addRunner(Runnable runnable){
        executorService.submit(runnable);
    }

    private static ExecutorService loadExecutorService(){
        ExecutorService iExecutor =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        return iExecutor;
    }
}
