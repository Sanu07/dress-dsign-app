package com.fashion.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.multipart.MultipartFile;

import com.fashion.constants.AppConstants;

public class FilesUtil {

	@Autowired
	private static ResourceLoader resourceLoader;

	private FilesUtil() {
	}

	public static String uploadFile(MultipartFile file, String referenceName) {
		if (!file.isEmpty()) {
			byte[] bytes;
			try {
				bytes = file.getBytes();
				Path path = Paths
						.get(AppConstants.IMAGES_FOLDER_PATH + referenceName + "_" + file.getOriginalFilename());
				Files.write(path, bytes);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return referenceName + "_" + file.getOriginalFilename();
	}

	public static byte[] getImage(String filePath) {
		try {
			ClassPathResource classPathResource = new ClassPathResource(AppConstants.IMAGES_FOLDER_PATH + filePath);
			InputStream inputStream = classPathResource.getInputStream();
			return inputStream.readAllBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new byte[0];
	}
}
