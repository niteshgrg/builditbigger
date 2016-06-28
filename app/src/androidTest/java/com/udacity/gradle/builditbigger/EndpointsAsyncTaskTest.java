package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.CountDownLatch;

/**
 * Created by niteshgarg on 28/06/16.
 */
public class EndpointsAsyncTaskTest extends AndroidTestCase {

    String mJoke = null;
    CountDownLatch signal = null;

    @Override
    protected void setUp() throws Exception {
        signal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        signal.countDown();
    }

    public void testAsyncTask() throws InterruptedException {
        EndpointsAsyncTask task = new EndpointsAsyncTask(new EndpointsAsyncTask.AsyncResponse() {
            @Override
            public void processFinish(String joke) {

                mJoke = joke;
                signal.countDown();
            }
        });
        signal.await();
        task.execute();

        assertTrue("Valid joke recieved", mJoke!=null);
    }
}
