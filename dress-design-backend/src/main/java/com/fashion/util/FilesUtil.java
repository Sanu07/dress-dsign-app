package com.fashion.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

import com.fashion.constants.AppConstants;

public class FilesUtil {

	private FilesUtil() {
	}

	public static String uploadFile(MultipartFile file, String referenceName) {
		String imageFilePath = "";
		if (!file.isEmpty()) {
			byte[] bytes;
			try {
				bytes = file.getBytes();
				Path path = Paths.get(AppConstants.UPLOADED_FOLDER + referenceName + "_" + file.getOriginalFilename());
				Files.write(path, bytes);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return AppConstants.UPLOADED_FOLDER + referenceName + "_" + file.getOriginalFilename();
	}
}
