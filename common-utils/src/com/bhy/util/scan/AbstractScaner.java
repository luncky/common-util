package com.bhy.util.scan;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

public class AbstractScaner {
	
	protected String resourceUrl;//资源定位
	protected boolean recursive=true;//是否进行递归搜索
	private List<File> resourceFiles=new LinkedList<File>();//扫描到的文件
	
	public AbstractScaner() {
		// TODO Auto-generated constructor stub
	}
	public AbstractScaner(String resourceUrl) {
		this.resourceUrl=getPackage2Path(resourceUrl);
	}
	
	
	public AbstractScaner(String resourceUrl, boolean recursive) {
		this.resourceUrl=getPackage2Path(resourceUrl);
		this.recursive=recursive;
	}
	
	/**
	 * 扫描操作
	 * @throws IOException 
	 */
	public void scan() throws IOException{
		ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
		Enumeration<URL> resourceUrls=classLoader.getResources(getPackage2Path(resourceUrl));
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
			this.resourceFiles.add(filrOrDir);
		}else if(filrOrDir.exists() && filrOrDir.isDirectory()){
			for(File file: filrOrDir.listFiles()){
				scanLocalFile(file.getAbsolutePath());
			}
		}
	}

	protected List<File> getResourceFiles(){
		return getResourceFiles(null);
	}
	
	
	protected List<File> getResourceFiles(ScanFilter scanFilter) {
		if(scanFilter!=null){
			for(File file: resourceFiles){
				if(!scanFilter.acceptFile(file)){
					resourceFiles.remove(file);
				}
			}
		}
		return resourceFiles;
	}
	/**
	 * 将包名转成文件路径
	 * @param basePackage
	 * @return
	 */
	protected String getPackage2Path(String packageName){
		if(packageName.endsWith(".")){
			packageName=packageName.substring(0, packageName.lastIndexOf("."));
		}
		if(packageName.endsWith("/")){
			packageName=packageName.substring(0, packageName.lastIndexOf("/"));
		}
		return packageName.replace(".", "/");
		
	}
	
	/**
	 * 将文件路径格式转成包名格式
	 * @param basePackage
	 * @return
	 */
	protected String getPath2Package(String filePath){
		if(filePath.endsWith(".")){
			filePath=filePath.substring(0, filePath.lastIndexOf("."));
		}
		if(filePath.endsWith(File.separator)){
			filePath=filePath.substring(0, filePath.lastIndexOf(File.separator));
		}
		
		return filePath.replace(File.separator, ".");
		
	}
}
