package com.bhy.util.scan;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

public class ScanerTest {
	
	private static AbstractScaner scaner;
	
	@BeforeClass
	public static void init(){
		String basePackage="com/bhy";
		scaner=new AbstractScaner(basePackage);
	}
	
	@Test
	public void test() throws IOException{
		scaner.scan();
	}
}
