package com.alvaro.parquesAcuaticos.business.dao;

import java.util.List;

import com.alvaro.parquesAcuaticos.bean.Foto;

public interface FotoDAO {
	
	public boolean guardarFoto(Foto foto);
	
	public boolean actualizarFoto(Foto foto);
	
	public boolean desactivarFotoPrincipal(Object object);
	
	public List<Foto> getAllFotos(Object object);
	
	public boolean desactivarFotoActivas(Object object);

}
