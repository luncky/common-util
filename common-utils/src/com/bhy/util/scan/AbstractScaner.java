package com.bhy.util.scan;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class AbstractScaner {
	
	protected String resourceUrl;//资源定位
	protected boolean recursive=true;//是否进行递归搜索
	
	
	public AbstractScaner(String resourceUrl) {
		this.resourceUrl=resourceUrl;
	}
	
	
	public AbstractScaner(String resourceUrl, boolean recursive) {
		this.resourceUrl=resourceUrl;
		this.recursive=recursive;
	}
	
	/**
	 * 扫描操作
	 * @throws IOException 
	 */
	public void scan() throws IOException{
		ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
		Enumeration<URL> resourceUrls=classLoader.getResources(resourceUrl);
		while(resourceUrls.hasMoreElements()){
			URL url=resourceUrls.nextElement();
			if(url.getProtocol().equals("file")){//本地资源
				String path=url.getPath();
				scanLocalFile(path);
			}else if(url.getProtocol().equals("http")){//http协议读取的网络资源
				
			}else if(url.getProtocol().equals("jar")){//jar文件中的资源
				
			}
		}
	}
	
	/**
	 * 扫描本地目录
	 */
	private void scanLocalFile(String path){
		File filrOrDir=new File(path);
		if(filrOrDir.exists() && filrOrDir.isFile()){
			System.out.println(filrOrDir.getPath());
		}else if(filrOrDir.exists() && filrOrDir.isDirectory()){
			for(File file: filrOrDir.listFiles()){
				scanLocalFile(file.getAbsolutePath());
			}
		}
	}
	
}
