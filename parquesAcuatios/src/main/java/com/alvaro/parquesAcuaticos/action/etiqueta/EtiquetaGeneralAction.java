package com.alvaro.parquesAcuaticos.action.etiqueta;

import java.util.ArrayList;
import java.util.List;

import com.alvaro.parquesAcuaticos.action.GeneralAction;
import com.alvaro.parquesAcuaticos.bean.Etiqueta;
import com.alvaro.parquesAcuaticos.business.dao.EtiquetaDAO;
import com.alvaro.parquesAcuaticos.business.dao.impl.EtiquetaDAOImpl;

public class EtiquetaGeneralAction extends GeneralAction{

	protected Etiqueta etiqueta = new Etiqueta();
	protected EtiquetaDAO etiquetaDAO = new EtiquetaDAOImpl();
	
	protected List<Etiqueta> listEtiquetas = new ArrayList<Etiqueta>();

	/**
	 * @return the etiqueta
	 */
	public Etiqueta getEtiqueta() {
		return etiqueta;
	}

	/**
	 * @param etiqueta the etiqueta to set
	 */
	public void setEtiqueta(Etiqueta etiqueta) {
		this.etiqueta = etiqueta;
	}

	/**
	 * @return the listEtiquetas
	 */
	public List<Etiqueta> getListEtiquetas() {
		return listEtiquetas;
	}

	/**
	 * @param listEtiquetas the listEtiquetas to set
	 */
	public void setListEtiquetas(List<Etiqueta> listEtiquetas) {
		this.listEtiquetas = listEtiquetas;
	}
	
	
}
