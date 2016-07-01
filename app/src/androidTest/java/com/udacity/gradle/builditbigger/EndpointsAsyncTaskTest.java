package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by niteshgarg on 28/06/16.
 */
public class EndpointsAsyncTaskTest extends AndroidTestCase {

    public static final String LOG_TAG = EndpointsAsyncTask.class.getSimpleName();

    String mJoke = "";
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
                assertTrue("Valid joke recieved", (joke != null && !joke.isEmpty()));
                mJoke = joke;
                signal.countDown();
            }
        });

        task.execute();
        signal.await(30, TimeUnit.SECONDS);

        assertTrue("Valid joke recieved", (mJoke != null && !mJoke.isEmpty()));
    }
}
