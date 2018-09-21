package com.dylan.common.fileupload.controller;

import com.dylan.common.fileupload.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.multipart.*;
import org.springframework.web.servlet.support.*;
import com.dylan.common.fileupload.entity.*;
import com.dylan.common.fileupload.payload.*;
import java.util.*;
import java.util.stream.*;
import javax.servlet.http.*;
import org.springframework.core.io.*;
import org.springframework.http.*;
import java.io.*;
import org.springframework.web.bind.annotation.*;
import com.dylan.common.fileupload.util.*;
import org.slf4j.*;

@RestController
public class FileController {
	private static final Logger logger;

	static {
		logger = LoggerFactory.getLogger(FileController.class);
	}

	@Autowired
	private FileStorageService fileStorageService;

	@PostMapping({ "/uploadFile" })
	public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
		FileInfo fileInfo = this.fileStorageService.storeFile(file);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path("" + fileInfo.getId()).toUriString();
		return new UploadFileResponse(fileInfo.getRealFileName(), fileDownloadUri, file.getContentType(),
				file.getSize());
	}

	@PostMapping({ "/removeFile" })
	public CommonResponse removeFile(@RequestParam("id") Long id) {
		this.fileStorageService.removeFile(id);
		return new CommonResponse(true, "文件删除成功！", "");
	}

	@PostMapping({ "/uploadMultipleFiles" })
	public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") final MultipartFile[] files) {
		return Arrays.asList(files).stream().map(file -> this.uploadFile(file)).collect(Collectors.toList());
	}

	@GetMapping({ "/downloadFile/{id}" })
	public ResponseEntity<Resource> downloadFile(@PathVariable final Long id, final HttpServletRequest request) {
		FileInfo fileInfo = this.fileStorageService.getFileInfoById(id);
		Resource resource = this.fileStorageService.loadFileAsResource(id);
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException ex) {
			FileController.logger.info("Could not determine file type.");
		}
		if (contentType == null) {
			contentType = "application/octet-stream";
		}
		try {
			return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
					.header("Content-Disposition",
							"attachment; filename=\""
									+ new String(fileInfo.getRealFileName().getBytes("GB2312"), "ISO8859-1") + "\"")
					.body(resource);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping({ "/listAll" })
	public List<FileInfo> listAll() {
		return this.fileStorageService.loadAll();
	}

	@PostMapping({ "/listByFileName" })
	public PageResult<FileInfo> listByFileName(@RequestParam("fileName") final String fileName,
			@RequestParam(defaultValue = "0") final String pageNo,
			@RequestParam(defaultValue = "10") final String pageSize) {
		return this.fileStorageService.getListByFileName(fileName, Integer.parseInt(pageNo) - 1,
				Integer.parseInt(pageSize));
	}

}
