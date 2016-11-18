/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package hello.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * ClassName: ScheduleTask
 *
 * @Author: ljiang
 * @Date: Nov 15, 2016 2:39:24 PM
 */
@Component
@EnableScheduling
public class ScheduleTask {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");

	/**
	 * reportCurrentTime:
	 * 
	 * @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
	 * @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
	 * @Scheduled(initialDelay=1000, fixedRate=5000)
	 *                               ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
	 * @Scheduled(cron="") ：通过cron表达式定义规则
	 */
	@Scheduled(fixedRate = 10000)
	public void reportCurrentTime() {
		System.out.println("Now is: " + sdf.format(new Date()));
	}

}
