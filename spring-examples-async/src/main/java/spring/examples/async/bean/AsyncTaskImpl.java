package spring.examples.async.bean;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class AsyncTaskImpl implements AsyncTask {

    @Async
    @Override
    public Future<Integer> doTask() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException ignored) {
            // NOP
        }
        System.out.println("done");
        return new AsyncResult<>(Integer.MAX_VALUE);
    }

}
