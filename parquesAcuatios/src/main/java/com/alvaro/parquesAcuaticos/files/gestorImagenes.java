package com.alvaro.parquesAcuaticos.files;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class gestorImagenes {

	public static String PATH_IMAGE = "/Games/";

	public static String getExtension(String name) {
		String res = "";
		res = name.substring(name.lastIndexOf(".")+1);
		return res;
	}

	public static String guardarImagen(String folder, File archivo, String nombreOriginal, String idNombreNuevo) {
		String result;

		try {
			String extension = getExtension(nombreOriginal);
			String carpeta = PATH_IMAGE + folder + "/";
			String nName = idNombreNuevo + "." + extension;
			File nFile = new File(carpeta + nName);
			FileUtils.copyFile(archivo, nFile);
			result = nFile.getAbsolutePath();
		} catch (Exception e) {
			System.out.println(e);
			result = null;
		}

		return result;
	}
}
