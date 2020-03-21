package com.alvaro.parquesAcuaticos.business.dao;

import java.util.List;

import com.alvaro.parquesAcuaticos.bean.Compania;

public interface CompaniaDAO {

	public Compania buscarCompaniaID(Compania compania); 
	
	public boolean guardarCompania(Compania compania);
	
	public boolean actualizarCompania(Compania compania);
	
	public List<Compania> getAllCompanias();
}
