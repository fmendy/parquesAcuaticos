package com.alvaro.parquesAcuaticos.action.etiqueta;

import com.alvaro.parquesAcuaticos.bean.Etiqueta;
import com.alvaro.parquesAcuaticos.session.SessionesGlobales;
import com.opensymphony.xwork2.ActionSupport;

public class EtiquetaAdministradorAction extends EtiquetaGeneralAction {

	public String irEtiqueta() {

		if (etiqueta.getIdEtiqueta() > 0) {
			etiqueta = etiquetaDAO.getEtiquetaByID(etiqueta);
		}

		return SessionesGlobales.SUCCESS;
	}
	
	public String verTodas() {
		listEtiquetas = etiquetaDAO.getAllEtiquetas();
		return SessionesGlobales.SUCCESS;
	}

	public String guardarEtiqueta() {

		operationStatus = SessionesGlobales.OPERATION_STATUS_FAIL;
		if (etiqueta.getIdEtiqueta() > 0) {
			if (etiquetaDAO.actualiarEtiqueta(etiqueta)) {
				operationStatus = SessionesGlobales.OPERATION_STATUS_CORRECT;
			}
		} else if (etiquetaDAO.guardarEtiqueta(etiqueta)) {
			operationStatus = SessionesGlobales.OPERATION_STATUS_CORRECT;

		}

		return SessionesGlobales.SUCCESS;
	}

	public void validateGuardarEtiqueta() {
		// TODO Auto-generated method stub
		ActionSupport actionSupport = new ActionSupport();
		Etiqueta aux = etiquetaDAO.getEtiquetaNombreExacto(etiqueta);
		if (aux != null && (etiqueta == null || (etiqueta.getIdEtiqueta() != aux.getIdEtiqueta()))) {
			addFieldError("etiqueta.nombre", actionSupport.getText("Etiqueta.nombre.ya.registrado"));
			operationStatus = SessionesGlobales.OPERATION_STATUS_FAIL;
		}

	}

}
