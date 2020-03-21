package com.alvaro.parquesAcuaticos.business.dao;

import java.util.List;

import com.alvaro.parquesAcuaticos.bean.Compania;
import com.alvaro.parquesAcuaticos.bean.Parque;

public interface ParqueDAO {

	public boolean guardarParque(Parque parque);
	
	public Parque buscarParque(Parque parque);
	
	public boolean actualizarParque(Parque parque);
	
	public List<Parque> getParquePorCompania(Compania compania);
}
