package com.mobile263;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.mobile263.service.FtpThread122;
import com.mobile263.service.FtpThread63;

public class App {
	
	public static void main(String[] args) throws Exception {

		
		//文件分别发送到不同的服务器 
		
		FtpThread63 th63 = new FtpThread63();
		FtpThread122 th122 = new FtpThread122();
		
		ScheduledThreadPoolExecutor scheduledExecutorPool = new ScheduledThreadPoolExecutor(2);
		scheduledExecutorPool.scheduleAtFixedRate(th63, 0, 60, TimeUnit.SECONDS);
		scheduledExecutorPool.scheduleAtFixedRate(th122, 0, 60, TimeUnit.SECONDS);

		//System.out.println("over");


		
		
		
	}
}
