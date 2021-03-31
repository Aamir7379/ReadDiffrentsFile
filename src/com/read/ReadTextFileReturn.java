package com.read;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ReadTextFileReturn {
public static void main(String[] args) {
	/*
	 * try{ FileInputStream fin=new
	 * FileInputStream("D:\\Byzan\\vodafone_IN_YESBANK_20201221-120555-394.txt");
	 * int i=0; while((i=fin.read())!=-1){ System.out.print((char)i); } fin.close();
	 * }catch(Exception e) { System.out.println(e);}
	 */

	File file = new File("D:\\Byzan\\vodafone_IN_YESBANK_20201221-120555-394.txt");
	String fileContent=null;
    try (FileInputStream fis = new FileInputStream(file)) {
        byte[] bytes = new byte[(int) file.length()];
        fis.read(bytes);
        fileContent = new String(bytes);
        System.out.println(fileContent);

    } catch (Exception e) {
        e.printStackTrace();
    }
    try{    
    	    FileOutputStream fos = new FileOutputStream("D:\\Byzan\\Amir_Bank.txt");
    	    DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
    	    outStream.writeUTF(fileContent);
    	    outStream.close();
  }
    catch (Exception e) {
        e.printStackTrace();
}
}
}
