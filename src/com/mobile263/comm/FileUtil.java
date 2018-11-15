package com.mobile263.comm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {

	//这个地方应该定义为私有变量，不应该定义为static变量，否则多线程会有问题。
	private String fileNameTemp="";
	private final String datePattern1 = "yyyyMMdd";
	private final String datePattern2 = "yyyyMMddHHmmss"; 
	
	
	public void createFile(String path,int createCount) {
		
		String fileName = "SLROAM_";
		String fileSufx = String.format(DateToString(datePattern1)+ ".%03d",createCount);
		fileNameTemp = path + fileName +fileSufx;
		System.out.println("创建的文件为：" + fileNameTemp);
		File file = new File(fileNameTemp);
		
		//写入内容
		writeFileContent(file,createCount);
					
	}
	
	
	public void writeFileContent(File f,int writeCount) {
		String line1 = "10" + "|" + DateToString(datePattern2) + "|" + String.format("%03d",writeCount);
		String visitCoutry = "NP" + String.valueOf(writeCount);
		String visitCarrier = "NPL" + String.valueOf(writeCount);
		String visitCoutry1 = "XT" + String.valueOf(writeCount);
		String visitCarrier1 = "XTL" + String.valueOf(writeCount);
		String startTime = DateToString(datePattern1) + "000000";
		String endTime = DateToString(datePattern1) + "235959";
		String line2 = visitCoutry + "|" + visitCarrier + "|"  
				+ startTime + "|"+ endTime + "|1000|1000|500|500|102400|102400";
				String line3 = visitCoutry1 + "|" + visitCarrier1 + "|"  
						+ startTime + "|"+ endTime + "|1000|1000|500|500|102400|102400";		
		String line4 = "90";
		
		String []lineWrites = {line1,line2,line3,line4};
		StringBuffer sb = new StringBuffer();
		try {
			FileWriter fr = new FileWriter(f);
			for (String lineWrite : lineWrites) {
				fr.write(lineWrite);
				fr.write("\r\n");
				sb.append(lineWrite);
				sb.append("\r\n");
			}
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("写入的数据为"+ sb.toString());
	}
	
	private String DateToString( String datePattern) {
		 SimpleDateFormat df = new SimpleDateFormat(datePattern);
		 String fileDate = df.format(new Date());
		 
		 return fileDate;
	}
	
	
	
	
}
