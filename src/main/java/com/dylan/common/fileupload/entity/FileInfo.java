package com.dylan.common.fileupload.entity;

import javax.persistence.*;

@Entity
@Table(name = "T_FILEINFO")
public class FileInfo extends BaseEntity {
	private long fileSize;
	private String fileName;
	private String realFileName;
	private String fileExtension;
	private String filePath;

	public FileInfo() {
	}

	public FileInfo(long fileSize, String fileName, String realFileName, String fileExtension, String filePath) {
		this.fileSize = fileSize;
		this.fileName = fileName;
		this.realFileName = realFileName;
		this.fileExtension = fileExtension;
		this.filePath = filePath;
	}

	public long getFileSize() {
		return this.fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getRealFileName() {
		return this.realFileName;
	}

	public void setRealFileName(String realFileName) {
		this.realFileName = realFileName;
	}

	public String getFileExtension() {
		return this.fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
