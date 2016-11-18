/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package hello.async;

import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ClassName: AsyncTaskTest
 *
 * @Author: ljiang
 * @Date: Nov 15, 2016 3:13:22 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AsyncTaskTest {

	@Autowired
	private SyncTask syncTask;
	@Autowired
	private AsyncTask asyncTask;

	@Test
	public void syncTask() throws InterruptedException {
		long start = System.currentTimeMillis();
		syncTask.taskOne();
		syncTask.taskTwo();
		syncTask.taskThree();
		System.out.println("All synctasks finished " + (System.currentTimeMillis() - start));
	}

	@Test
	public void asyncTask() throws InterruptedException {
		long start = System.currentTimeMillis();
		Future<String> f1 = asyncTask.taskOne();
		Future<String> f2 = asyncTask.taskTwo();
		Future<String> f3 = asyncTask.taskThree();
		while (!f1.isDone() || !f2.isDone() || !f3.isDone()) {

		}
		System.out.println("All async tasks finished " + (System.currentTimeMillis() - start));
	}
}
