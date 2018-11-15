package com.mobile263.service;

import com.mobile263.comm.FileUtil;
import com.mobile263.comm.Ftp;

public class FtpThread122 implements Runnable {
	
	public static String localDir = "E:\\eclipse_workspace\\FtpFile\\fileLoad122\\";
	public static String remoteDir = "/opt/mobile263/ntr-slroam/ctTest";
	public static int fileNumTag = 100;
	
	@Override
	public void run() {
		
		createFiles();
		upFiles();

	}
	
	public void createFiles() {
		//创建10个这样的文件
		FileUtil fileUtil =new FileUtil();
		int i= fileNumTag;
		for(; i< fileNumTag+9; i++) {
			fileUtil.createFile(localDir,i);
		}
		
		fileNumTag = i;
	}
	
	public void upFiles() {
		Ftp ftp = null;
		try {
			ftp = Ftp.getSftpUtil("192.168.40.122", 22, "root", "263net123");
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
