package com.alvaro.parquesAcuaticos.action.compania;

import java.io.File;
import java.nio.file.Files;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.util.ServletContextAware;

import com.alvaro.parquesAcuaticos.action.GeneralAction;
import com.alvaro.parquesAcuaticos.bean.Compania;
import com.alvaro.parquesAcuaticos.business.dao.CompaniaDAO;
import com.alvaro.parquesAcuaticos.business.dao.impl.CompaniaDAOImpl;
import com.alvaro.parquesAcuaticos.files.gestorImagenes;
import com.alvaro.parquesAcuaticos.session.SessionesGlobales;

public class CompaniaGuardarAction extends CompaniaGeneral {


	private File uploadImagen;
	private String uploadImagenFileName;
	private String uploadImagenContentType;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if (isUserLoged()) {
			operationStatus = SessionesGlobales.OPERATION_STATUS_FAIL;

			if (compania.getIdCompania() == 0) {
				if (companiaDAO.guardarCompania(compania)) {
					operationStatus = SessionesGlobales.OPERATION_STATUS_CORRECT;
				}
			} else {
				if (companiaDAO.actualizarCompania(compania)) {
					operationStatus = SessionesGlobales.OPERATION_STATUS_CORRECT;
				}
			}

			if (uploadImagen != null) {
				compania.setImagen(gestorImagenes.guardarImagen("compania", uploadImagen, uploadImagenFileName,
						Integer.toString(compania.getIdCompania())));
				if (companiaDAO.actualizarCompania(compania)) {
					operationStatus = SessionesGlobales.OPERATION_STATUS_CORRECT;
				}
			}

			return SessionesGlobales.SUCCESS;
		}
		return SessionesGlobales.NO_LOGEADO;
	}

	
	/**
	 * @return the uploadImagen
	 */
	public File getUploadImagen() {
		return uploadImagen;
	}

	/**
	 * @param uploadImagen the uploadImagen to set
	 */
	public void setUploadImagen(File uploadImagen) {
		this.uploadImagen = uploadImagen;
	}

	/**
	 * @return the uploadImagenFileName
	 */
	public String getUploadImagenFileName() {
		return uploadImagenFileName;
	}

	/**
	 * @param uploadImagenFileName the uploadImagenFileName to set
	 */
	public void setUploadImagenFileName(String uploadImagenFileName) {
		this.uploadImagenFileName = uploadImagenFileName;
	}

	/**
	 * @return the uploadImagenContentType
	 */
	public String getUploadImagenContentType() {
		return uploadImagenContentType;
	}

	/**
	 * @param uploadImagenContentType the uploadImagenContentType to set
	 */
	public void setUploadImagenContentType(String uploadImagenContentType) {
		this.uploadImagenContentType = uploadImagenContentType;
	}

}
