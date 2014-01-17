package com.bhy.test.scan;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.BeforeClass;
import org.junit.Test;

public class ClassLoadTest {
	
	
	private static ClassLoader classLoader;
	
	@BeforeClass
	public static void init(){
		classLoader=Thread.currentThread().getContextClassLoader();
	}
	
	
	/**
	 * 类加载器信息
	 */
	@Test
	public void classLoadInfo(){
//		System.out.println(classLoader.getClass());
//		System.out.println(classLoader.getParent());
//		System.out.println(classLoader.getParent().getParent());
	}
	
	/**
	 * 资源查找
	 * @throws IOException 
	 * @throws URISyntaxException 
	 */
	@Test
	public void getResourceTest() throws IOException, URISyntaxException{
		/**
		 * 从jar文件中获取资源。
		 */
//		String resourceName="org/junit";
//		URL url=classLoader.getResource(resourceName);
		
		/**
		 * 网络中获取资源
		 */
//		String resourceName="http://f.hiphotos.baidu.com/image/w%3D230/sign=3289b8e6d300baa1ba2c40b87711b9b1/ac4bd11373f08202f71be43549fbfbedab641b2a.jpg";
//		URL url=new URL(resourceName);
		
		
		/**
		 * 本地文件资源
		 */
		String resourceName="com/bhy";
		URL url=classLoader.getResource(resourceName);
		
		System.out.println("toString():  "+url.toString());
		System.out.println("toExternalForm():  "+url.toExternalForm());
		System.out.println("toURI():  "+url.toURI());
		System.out.println("Protocol:  "+url.getProtocol());
		System.out.println("DefaultPort:  "+url.getDefaultPort());
		System.out.println("Host:  "+url.getHost());
		System.out.println("Port:  "+url.getPort());
		System.out.println("getQuery:  "+url.getQuery());
		System.out.println("getRef():  "+url.getRef());
		System.out.println("getFile():  "+url.getFile());
		System.out.println("getPath():  "+url.getPath());
	}
	
	
	
}
