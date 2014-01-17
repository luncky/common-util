package com.bhy.util.scan;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PackageClassScaner extends AbstractScaner{
	
	private String basePackage;
	
	public PackageClassScaner(String basePackage) { 
		super(basePackage);
		this.basePackage=basePackage;
	}
	
	public List<Class<?>> getPackageClasses() throws IOException, ClassNotFoundException
	{
		return getPackageClasses(null);
	}
	
	
	public List<Class<?>> getPackageClasses(ScanFilter scanFilter) throws IOException, ClassNotFoundException{
		List<Class<?>> classes=new ArrayList<Class<?>>();
		super.scan();//扫描
		basePackage=getPath2Package(basePackage);//统一格式
		for(File file: super.getResourceFiles()){
			String filePath=file.getAbsolutePath();
			if(filePath.endsWith(".class")){
				String path2Package=getPath2Package(filePath);
				String className=path2Package.substring(path2Package.indexOf(basePackage), path2Package.lastIndexOf(".class"));
				Class<?> cla=Class.forName(className);
				if(scanFilter!=null && !scanFilter.acceptClass(cla))
					continue;
				classes.add(cla);
			}
			
		}
		return classes;
	}
	
}
