package spring.examples.async.bean;

import java.util.concurrent.Future;

@FunctionalInterface
public interface AsyncTask {

    public Future<Integer> doTask();

}
