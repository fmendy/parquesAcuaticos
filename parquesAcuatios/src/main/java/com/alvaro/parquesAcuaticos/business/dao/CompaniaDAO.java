package com.alvaro.parquesAcuaticos.business.dao;

import com.alvaro.parquesAcuaticos.bean.Compania;

public interface CompaniaDAO {

	public Compania buscarCompaniaID(Compania compania); 
	
	public boolean guardarCompania(Compania compania);
	
	public boolean actualizarCompania(Compania compania);
}
