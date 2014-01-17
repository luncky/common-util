package com.bhy.util.scan;

import java.io.File;
/**
 * 扫描过滤适配器,默认不顾虑
 * @author DELL
 *
 */
public abstract class ScanAdapter implements ScanFilter{
	@Override
	public boolean acceptClass(Class<?> cla) {
		return true;
	}
	
	@Override
	public boolean acceptFile(File file) {
		return true;
	}
}
