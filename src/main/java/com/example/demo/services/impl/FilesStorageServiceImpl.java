package com.example.demo.services.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.services.FilesStorageService;

public class FilesStorageServiceImpl implements FilesStorageService {
	@Override
	public String getImage(MultipartFile file) {
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "dqnedoddm", "api_key",
				"121759278124181", "api_secret", "EQRbJA6t_V8c91vTGbiUp1xWPqI"));
		try {
			File newFile = convert(file);
//	            System.out.println("Sukses");
			cloudinary.uploader().upload(newFile, ObjectUtils.emptyMap());
			String uploadResult = cloudinary.url()
					.transformation(new Transformation().width(100).height(150).crop("fill")).generate();
			newFile.delete();
			return uploadResult;
		} catch (Exception e) {
			System.out.println(e.getMessage());
//	            System.out.println("Gagal Convert Image");
		}
		return null;
	}

	public static File convert(MultipartFile file) throws IOException {

		Path root = Paths.get("src\\main\\resources\\uploads\\");
		String name = storeFile(file, root);
		File convFile = new File(root + "/" + name);
		return convFile;
	}

	public static String storeFile(MultipartFile file, Path path) {
		// Normalize file name

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new ResourceNotFoundException("Name invalid " + fileName);
			}

			// Copy file to the target location (Replacing existing file with the same name)
			Path targetLocation = path.resolve(fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

			return fileName;
		} catch (IOException ex) {
			throw new ResourceNotFoundException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}
}
