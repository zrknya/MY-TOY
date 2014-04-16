package com.example.tools;

import java.io.File;
import java.util.ArrayList;

public class VoiceFileList {//该方法用于寻找指定目录下的音效文件

	static public ArrayList<File> getList(String filePath) {
		
		ArrayList<File> list = new ArrayList<File>(); 
		try{
			File file = new File(filePath);
			File[] files = file.listFiles();
			if(files != null)
			{
				for(File f:files){
					String absolutepath = f.getAbsolutePath();
					String path = f.getPath();
					if(absolutepath.endsWith("mp3") || absolutepath.endsWith("wav")){
						list.add(f);
					}
					else{
						if(f.isDirectory()){
							list.addAll(getList(path));
						}
					}
				}
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return list;
	}
	
}
