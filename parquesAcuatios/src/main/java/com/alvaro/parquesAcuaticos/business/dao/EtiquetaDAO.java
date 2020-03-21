package com.alvaro.parquesAcuaticos.business.dao;

import java.util.List;

import com.alvaro.parquesAcuaticos.bean.Etiqueta;

public interface EtiquetaDAO {

	public boolean guardarEtiqueta(Etiqueta etiqueta);
	
	public boolean actualiarEtiqueta(Etiqueta etiqueta);
	
	public Etiqueta getEtiquetaNombreExacto(Etiqueta etiqueta);
	
	public Etiqueta getEtiquetaByID(Etiqueta etiqueta);
	
	public List<Etiqueta> getAllEtiquetas();
}
