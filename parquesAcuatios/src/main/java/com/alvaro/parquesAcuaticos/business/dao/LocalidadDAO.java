package com.alvaro.parquesAcuaticos.business.dao;

import com.alvaro.parquesAcuaticos.bean.Localidad;

public interface LocalidadDAO {

	public boolean localidadValidarNombre(Localidad localidad);
	
	public boolean aniadirLocalidad(Localidad localidad);
}
