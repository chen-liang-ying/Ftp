package com.mobile263.test;

import java.io.File;

public class Test {

	public static void main(String[] args) {
		
        File file = new File("D:\\΢�ſ���");  
        //��ȡ��Ŀ¼�µ������ļ�  
        String[] files = file.list();  
          
        for (String f : files){  
            System.out.println(f);  
        }  
          
        //listFiles�ǻ�ȡ��Ŀ¼�������ļ���Ŀ¼�ľ���·��  
        File[] fs = file.listFiles();  
        for (File f : fs){  
            System.out.println(f);  
        }  
	}
}
