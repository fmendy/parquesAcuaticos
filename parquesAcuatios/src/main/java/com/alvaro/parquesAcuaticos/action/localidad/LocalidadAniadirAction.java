package com.alvaro.parquesAcuaticos.action.localidad;

import com.alvaro.parquesAcuaticos.action.GeneralAction;
import com.alvaro.parquesAcuaticos.bean.Localidad;
import com.alvaro.parquesAcuaticos.business.dao.LocalidadDAO;
import com.alvaro.parquesAcuaticos.business.dao.impl.LocalidadDAOImpl;
import com.alvaro.parquesAcuaticos.session.SessionesGlobales;
import com.opensymphony.xwork2.ActionSupport;

public class LocalidadAniadirAction extends GeneralAction {

	private Localidad localidad = new Localidad();
	private LocalidadDAO lDao = new LocalidadDAOImpl();

	@Override
	public String execute() throws Exception {
		if (isUserLoged()) {
			if (lDao.aniadirLocalidad(localidad)) {
				return SessionesGlobales.SUCCESS;
			} else {
				return SessionesGlobales.FAILED;
			}
		} else {
			return SessionesGlobales.NO_LOGEADO;
		}
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

}
