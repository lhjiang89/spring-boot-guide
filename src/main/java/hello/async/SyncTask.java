/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package hello.async;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

/**
 * ClassName: SyncTask
 *
 * @Author: ljiang
 * @Date: Nov 15, 2016 3:09:11 PM
 */
@Component
public class SyncTask {

	public static Random random = new Random();

	public void taskOne() throws InterruptedException {
		long start = System.currentTimeMillis();
		System.out.println("SyncTask 1 Started");
		TimeUnit.MILLISECONDS.sleep(random.nextInt(5000));
		System.out.println("SyncTask 1 finished " + (System.currentTimeMillis() - start));
	}

	public void taskTwo() throws InterruptedException {
		long start = System.currentTimeMillis();
		System.out.println("SyncTask 2 Started");
		TimeUnit.MILLISECONDS.sleep(random.nextInt(5000));
		System.out.println("SyncTask 2 finished " + (System.currentTimeMillis() - start));
	}

	public void taskThree() throws InterruptedException {
		long start = System.currentTimeMillis();
		System.out.println("SyncTask 3 Started");
		TimeUnit.MILLISECONDS.sleep(random.nextInt(5000));
		System.out.println("SyncTask 3 finished " + (System.currentTimeMillis() - start));
	}
}
