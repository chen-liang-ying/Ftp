package com.mobile263.test;

import java.io.File;

public class Test {

	public static void main(String[] args) {
		
        File file = new File("D:\\微信开发");  
        //获取该目录下的所有文件  
        String[] files = file.list();  
          
        for (String f : files){  
            System.out.println(f);  
        }  
          
        //listFiles是获取该目录下所有文件和目录的绝对路径  
        File[] fs = file.listFiles();  
        for (File f : fs){  
            System.out.println(f);  
        }  
	}
}
