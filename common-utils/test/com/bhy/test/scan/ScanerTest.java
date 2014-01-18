package com.bhy.test.scan;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.bhy.util.scan.PackageClassScaner;
import com.bhy.util.scan.ScanAdapter;
import com.bhy.util.scan.ScanFilter;

public class ScanerTest {
	
	private static PackageClassScaner scaner;
	
	@BeforeClass
	public static void init(){
		String basePackage="com/bhy";
		scaner=new PackageClassScaner(basePackage);
	}
	
	@Test
	public void test() throws IOException, ClassNotFoundException{
		ScanFilter scanFilter=new ScanAdapter() {
			@Override
			public boolean acceptClass(Class<?> cla) {
				if(cla.getName().indexOf("$")>-1){
					return false;
				}
				return true;
			}
		};
		for(Class<?> cla: scaner.getPackageClasses(scanFilter)){
			System.out.println(cla.getName());
		}
	}

}
