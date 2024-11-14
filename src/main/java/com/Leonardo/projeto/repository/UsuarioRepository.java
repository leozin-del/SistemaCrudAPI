package com.Leonardo.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Leonardo.projeto.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{
	
}
