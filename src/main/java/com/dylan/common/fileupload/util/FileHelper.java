package com.dylan.common.fileupload.util;

import com.dylan.common.fileupload.config.*;
import java.io.*;
import java.util.*;

/**
 * 文件工具类
 * 
 * @author ACER
 *
 */
public class FileHelper {
	public static String getExtFromFileName(String filename) {
		int t = filename.lastIndexOf("\\");
		if (t != -1) {
			filename = filename.substring(t + 1);
		}
		t = filename.lastIndexOf("/");
		if (t != -1) {
			filename = filename.substring(t + 1);
		}
		t = filename.lastIndexOf(".");
		if (t != -1) {
			return filename.substring(t + 1).toLowerCase();
		}
		return "";
	}

	public static String getUploadPath(FileStorageProperties fileStorageProperties) {
		String basePath = fileStorageProperties.getUploadDir();
		Calendar today = Calendar.getInstance();
		String year = String.valueOf(today.get(1));
		String month = String.valueOf(today.get(2) + 1);
		return basePath + File.separator + year + File.separator + month + File.separator;
	}

	public static String createRandomFileName(String fileExtensionName) {
		return new StringBuffer(UUID.randomUUID().toString().replace("-", "_")).append(".").append(fileExtensionName)
				.toString();
	}
}
