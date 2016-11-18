/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package hello.async;

import java.util.Random;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * ClassName: SyncTask
 *
 * @Author: ljiang
 * @Date: Nov 15, 2016 3:09:11 PM
 */
@Component
@EnableAsync
public class AsyncTask {

	public static Random random = new Random();

	@Async
	public Future<String> taskOne() throws InterruptedException {
		long start = System.currentTimeMillis();
		System.out.println("AsyncTask 1 Started");
		TimeUnit.MILLISECONDS.sleep(random.nextInt(5000));
		System.out.println("AsyncTask 1 finished " + (System.currentTimeMillis() - start));
		return new AsyncResult<String>("AsyncTask 1");
	}

	@Async
	public Future<String> taskTwo() throws InterruptedException {
		long start = System.currentTimeMillis();
		System.out.println("AsyncTask 2 Started");
		TimeUnit.MILLISECONDS.sleep(random.nextInt(5000));
		System.out.println("AsyncTask 2 finished " + (System.currentTimeMillis() - start));
		return new AsyncResult<String>("AsyncTask 2");
	}

	@Async
	public Future<String> taskThree() throws InterruptedException {
		long start = System.currentTimeMillis();
		System.out.println("AsyncTask 3 Started");
		TimeUnit.MILLISECONDS.sleep(random.nextInt(5000));
		System.out.println("AsyncTask 3 finished " + (System.currentTimeMillis() - start));
		return new AsyncResult<String>("AsyncTask 3");
	}
}
