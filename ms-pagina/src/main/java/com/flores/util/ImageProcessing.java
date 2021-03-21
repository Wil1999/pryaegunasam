package com.flores.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class ImageProcessing extends IOException{
	private final String urlAlmacenamiento = "";
	private String ruta;
	
	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public void saveFile(MultipartFile file) throws IOException{
		if(!file.isEmpty()) {
			byte[] bytes = file.getBytes();
			
			setRuta(this.urlAlmacenamiento + File.separator + file.getOriginalFilename());
			
			FileOutputStream fos = new FileOutputStream(getRuta());
			fos.write(bytes);
			fos.close();
		}
	}
	
	private static final long serialVersionUID = 1L;
}
