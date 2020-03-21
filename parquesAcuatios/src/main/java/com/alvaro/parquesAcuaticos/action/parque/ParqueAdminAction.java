package com.alvaro.parquesAcuaticos.action.parque;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.alvaro.parquesAcuaticos.action.GeneralAction;
import com.alvaro.parquesAcuaticos.bean.Compania;
import com.alvaro.parquesAcuaticos.bean.Foto;
import com.alvaro.parquesAcuaticos.bean.Localidad;
import com.alvaro.parquesAcuaticos.bean.Pais;
import com.alvaro.parquesAcuaticos.bean.Parque;
import com.alvaro.parquesAcuaticos.bean.Provincia;
import com.alvaro.parquesAcuaticos.bean.TipoFoto;
import com.alvaro.parquesAcuaticos.business.dao.CompaniaDAO;
import com.alvaro.parquesAcuaticos.business.dao.FotoDAO;
import com.alvaro.parquesAcuaticos.business.dao.LocalidadDAO;
import com.alvaro.parquesAcuaticos.business.dao.PaisDAO;
import com.alvaro.parquesAcuaticos.business.dao.ParqueDAO;
import com.alvaro.parquesAcuaticos.business.dao.ProvinciaDAO;
import com.alvaro.parquesAcuaticos.business.dao.impl.CompaniaDAOImpl;
import com.alvaro.parquesAcuaticos.business.dao.impl.FotoDAOImpl;
import com.alvaro.parquesAcuaticos.business.dao.impl.LocalidadDAOImpl;
import com.alvaro.parquesAcuaticos.business.dao.impl.PaisDAOImpl;
import com.alvaro.parquesAcuaticos.business.dao.impl.ParqueDAOImpl;
import com.alvaro.parquesAcuaticos.business.dao.impl.ProvinciaDAOImpl;
import com.alvaro.parquesAcuaticos.files.gestorImagenes;
import com.alvaro.parquesAcuaticos.session.SessionesGlobales;

public class ParqueAdminAction extends GeneralAction {

	private Parque parque = new Parque();
	private Localidad localidad = new Localidad();
	private File uploadImagen;
	private String uploadImagenFileName;
	private String uploadImagenContentType;
	private List<Compania> listCompanias = new ArrayList<Compania>();
	private List<Pais> listaPaises = new ArrayList<Pais>();
	private List<Provincia> listaProvincias = new ArrayList<Provincia>();
	private List<Localidad> listaLocalidades = new ArrayList<Localidad>();
	private CompaniaDAO companiaDAO = new CompaniaDAOImpl();
	private PaisDAO paisDao = new PaisDAOImpl();
	private ParqueDAO parqueDAO = new ParqueDAOImpl();
	private ProvinciaDAO provinciaDAO = new ProvinciaDAOImpl();
	private LocalidadDAO localidadDAO = new LocalidadDAOImpl();
	private File[] multiplesImagenes;
	private String[] multiplesImagenesFileName;
	private String[] multiplesImagenesContentType;
	private FotoDAO fotoDAO = new FotoDAOImpl();

	public String ir() throws Exception {

		// if (isUserLoged()) {
		listCompanias = companiaDAO.getAllCompanias();
		listaPaises = paisDao.listarPaises();
		if (parque.getIdParque() > 0) {
			parque = parqueDAO.buscarParque(parque);
			localidad = parque.getLocalidad();
			listaProvincias = provinciaDAO.getProvinciasPorPais(localidad.getProvincia().getPais());
			listaLocalidades = localidadDAO.getLocalidadesPorProvincia(localidad.getProvincia());
		}

		return SessionesGlobales.SUCCESS;
		/*
		 * } return SessionesGlobales.NO_LOGEADO;
		 */
	}

	public String guardar() {
		if (isUserLoged()) {
			operationStatus = SessionesGlobales.OPERATION_STATUS_FAIL;
			parque.setLocalidad(localidad);
			if (parque.getIdParque() == 0) {
				if (parqueDAO.guardarParque(parque)) {
					operationStatus = SessionesGlobales.OPERATION_STATUS_CORRECT;
				}
			} else {
				if (parqueDAO.actualizarParque(parque)) {
					operationStatus = SessionesGlobales.OPERATION_STATUS_CORRECT;
				}
			}
			if (uploadImagen != null) {
				parque.setImagen(gestorImagenes.guardarImagen("parque", uploadImagen, uploadImagenFileName,
						Integer.toString(parque.getIdParque())));
				if (parqueDAO.actualizarParque(parque)) {
					operationStatus = SessionesGlobales.OPERATION_STATUS_CORRECT;
				}
			}
			return SessionesGlobales.SUCCESS;
		}
		return SessionesGlobales.NO_LOGEADO;
	}

	public String irParqueFotos() {

		if (parque.getIdParque() > 0) {
			parque = parqueDAO.buscarParque(parque);
			for (Foto f : parque.getListFoto()) {
				System.out.println(f.getUrl());
			}

			return SessionesGlobales.SUCCESS;
		}
		return SessionesGlobales.FAILED;
	}

	public String guardarParqueFotos() {

		operationStatus = SessionesGlobales.OPERATION_STATUS_FAIL;
		Foto foto = new Foto();
		TipoFoto tipoFoto = new TipoFoto();

		// Fotos a desactivar
		boolean desactivarFotos = false;
		for (Foto f : parque.getListFoto()) {
			if (f != null && !f.isActivo()) {
				desactivarFotos = true;
			}
		}
		if (desactivarFotos) {
			if (fotoDAO.desactivarFotoActivas(parque)) {
				operationStatus = SessionesGlobales.OPERATION_STATUS_CORRECT;
			}
		}

		// Subir Foto Principal
		if (uploadImagen != null) {
			tipoFoto.setIdTipoFoto(1);
			foto.setTipoFoto(tipoFoto);
			foto.setParque(parque);

			try {
				// Comprobar si existe alguna foto principal
				boolean principalActiva = false;

				for (Foto f : parque.getListFoto()) {
					if (f.getTipoFoto().getIdTipoFoto() == 1 && f.isActivo()) {
						principalActiva = true;
					}
				}
				if (principalActiva) {
					fotoDAO.desactivarFotoPrincipal(parque);
				}
				fotoDAO.guardarFoto(foto);
				foto.setUrl(gestorImagenes.guardarImagen("foto", uploadImagen, uploadImagenFileName,
						Integer.toString(foto.getIdFoto())));

				if (fotoDAO.actualizarFoto(foto)) {
					operationStatus = SessionesGlobales.OPERATION_STATUS_CORRECT;
				} else {
					operationStatus = SessionesGlobales.OPERATION_STATUS_FAIL;
					return SessionesGlobales.SUCCESS;
				}
			} catch (Exception e) {
				operationStatus = SessionesGlobales.OPERATION_STATUS_FAIL;
				return SessionesGlobales.SUCCESS;
			}
		}

		// Imagenes Secundarias
		if (multiplesImagenes != null) {
			for (int i = 0; i < multiplesImagenes.length; i++) {
				try {
					File file = multiplesImagenes[i];
					String name = multiplesImagenesFileName[i];
					tipoFoto = new TipoFoto();
					tipoFoto.setIdTipoFoto(2);
					foto = new Foto();
					foto.setTipoFoto(tipoFoto);
					foto.setParque(parque);
					fotoDAO.guardarFoto(foto);

					foto.setUrl(gestorImagenes.guardarImagen("foto", file, name, Integer.toString(foto.getIdFoto())));

					if (fotoDAO.actualizarFoto(foto)) {
						operationStatus = SessionesGlobales.OPERATION_STATUS_CORRECT;
					}
				} catch (Exception e) {
					operationStatus = SessionesGlobales.OPERATION_STATUS_FAIL;
					return SessionesGlobales.SUCCESS;
				}
			}
		}

		return SessionesGlobales.SUCCESS;
	}

	/**
	 * @return the parque
	 */
	public Parque getParque() {
		return parque;
	}

	/**
	 * @param parque the parque to set
	 */
	public void setParque(Parque parque) {
		this.parque = parque;
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

	/**
	 * @return the listCompanias
	 */
	public List<Compania> getListCompanias() {
		return listCompanias;
	}

	/**
	 * @param listCompanias the listCompanias to set
	 */
	public void setListCompanias(List<Compania> listCompanias) {
		this.listCompanias = listCompanias;
	}

	/**
	 * @return the localidad
	 */
	public Localidad getLocalidad() {
		return localidad;
	}

	/**
	 * @param localidad the localidad to set
	 */
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	/**
	 * @return the listaPaises
	 */
	public List<Pais> getListaPaises() {
		return listaPaises;
	}

	/**
	 * @param listaPaises the listaPaises to set
	 */
	public void setListaPaises(List<Pais> listaPaises) {
		this.listaPaises = listaPaises;
	}

	/**
	 * @return the listaProvincias
	 */
	public List<Provincia> getListaProvincias() {
		return listaProvincias;
	}

	/**
	 * @param listaProvincias the listaProvincias to set
	 */
	public void setListaProvincias(List<Provincia> listaProvincias) {
		this.listaProvincias = listaProvincias;
	}

	/**
	 * @return the listaLocalidades
	 */
	public List<Localidad> getListaLocalidades() {
		return listaLocalidades;
	}

	/**
	 * @param listaLocalidades the listaLocalidades to set
	 */
	public void setListaLocalidades(List<Localidad> listaLocalidades) {
		this.listaLocalidades = listaLocalidades;
	}

	/**
	 * @return the multiplesImagenes
	 */
	public File[] getMultiplesImagenes() {
		return multiplesImagenes;
	}

	/**
	 * @param multiplesImagenes the multiplesImagenes to set
	 */
	public void setMultiplesImagenes(File[] multiplesImagenes) {
		this.multiplesImagenes = multiplesImagenes;
	}

	/**
	 * @return the multiplesImagenesFileName
	 */
	public String[] getMultiplesImagenesFileName() {
		return multiplesImagenesFileName;
	}

	/**
	 * @param multiplesImagenesFileName the multiplesImagenesFileName to set
	 */
	public void setMultiplesImagenesFileName(String[] multiplesImagenesFileName) {
		this.multiplesImagenesFileName = multiplesImagenesFileName;
	}

	/**
	 * @return the multiplesImagenesContentType
	 */
	public String[] getMultiplesImagenesContentType() {
		return multiplesImagenesContentType;
	}

	/**
	 * @param multiplesImagenesContentType the multiplesImagenesContentType to set
	 */
	public void setMultiplesImagenesContentType(String[] multiplesImagenesContentType) {
		this.multiplesImagenesContentType = multiplesImagenesContentType;
	}

}
