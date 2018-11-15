package com.mobile263.service;

import com.mobile263.comm.FileUtil;
import com.mobile263.comm.Ftp;

public class FtpThread63 implements Runnable {
	
	public static String localDir = "E:\\eclipse_workspace\\FtpFile\\fileLoad63\\";
	public static String remoteDir = "/opt/mobile263/ntr-slroam/ctTest";
	public static int fileNumTag1 = 1;
	
	@Override
	public void run() {
		
		createFiles();
		upFiles();

	}
	
	public void createFiles() {
		//创建10个这样的文件
		FileUtil fileUtil =new FileUtil();
		int i= fileNumTag1;
		for(; i< fileNumTag1+9; i++) {
			fileUtil.createFile(localDir,i);
		}
		
		fileNumTag1 = i;
	}
	
	public void upFiles() {
		Ftp ftp = null;
		try {
			ftp = Ftp.getSftpUtil("192.168.40.63", 22, "root", "263net123");
			ftp.upload(remoteDir,localDir);
			System.out.println("ftp:" + ftp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(null != ftp) {
			Ftp.release();
		}
	}

}
