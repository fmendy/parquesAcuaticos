package com.alvaro.parquesAcuaticos.business.dao;

import java.util.List;

import com.alvaro.parquesAcuaticos.bean.Pais;
import com.alvaro.parquesAcuaticos.bean.Provincia;

public interface ProvinciaDAO {

	public List<Provincia> getProvinciasPorPais(Pais pais);
	}
