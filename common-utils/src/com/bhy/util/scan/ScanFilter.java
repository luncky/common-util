package com.bhy.util.scan;

import java.io.File;

/**
 * 扫描过滤器
 * @author DELL
 *
 */
public interface ScanFilter {
	
	/**
	 * 扫描文件过滤
	 * @param file
	 * @return
	 */
	public boolean acceptFile(File file);
	
	
	/**
	 * 扫描过滤类
	 * @param cla
	 * @return
	 */
	public boolean acceptClass(Class<?> cla);
}

