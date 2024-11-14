package com.Leonardo.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Leonardo.projeto.dto.UsuarioDTO;
import com.Leonardo.projeto.entity.UsuarioEntity;
import com.Leonardo.projeto.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<UsuarioDTO> listarTodos() {
		List<UsuarioEntity> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(UsuarioDTO::new).toList();
	}
	
	//UsuarioDTO usado como parametro para classe Inserir()
	public void inserir(UsuarioDTO usuario) {
		 UsuarioEntity usuarioentity = new UsuarioEntity(usuario); //vai ser inserido um novo UsuarioDTO que veio do Controller para o UsuarioEntity
		 usuarioRepository.save(usuarioentity); //UsuarioRepository vai salvar o novo usuario na tabela que é o ususarioentity
	}
	
	// Retorna o UsuarioDTO que ira ser alterado
	public UsuarioDTO alterar(UsuarioDTO usuario) {				
		UsuarioEntity usuarioentity = new UsuarioEntity(usuario); 
		return new UsuarioDTO(usuarioRepository.save(usuarioentity)); 
	}
	
	public void excluir(Long id) {
		UsuarioEntity usuario = usuarioRepository.findById(id).get();
		usuarioRepository.delete(usuario);
	}
	
}
