package com.alvaro.parquesAcuaticos.business.dao;

import java.util.List;

import com.alvaro.parquesAcuaticos.bean.Localidad;
import com.alvaro.parquesAcuaticos.bean.Provincia;

public interface LocalidadDAO {

	public boolean localidadValidarNombre(Localidad localidad);
	
	public boolean aniadirLocalidad(Localidad localidad);
	
	public List<Localidad> getLocalidadesPorProvincia(Provincia provincia);
}
