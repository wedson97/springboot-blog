package com.example.backend_blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_blog.usuario.Usuario;
import com.example.backend_blog.usuario.UsuarioRepository;
import com.example.backend_blog.usuario.UsuarioRequestDTO;
import com.example.backend_blog.usuario.UsuarioResponseDTO;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<UsuarioResponseDTO> getAll() {
		
		List<UsuarioResponseDTO> usuarios = usuarioRepository.findAll().stream().map(UsuarioResponseDTO::new).toList();
		return usuarios;
	}
	
	@PostMapping
	public void salvarUsuario(@RequestBody UsuarioRequestDTO data) {
		Usuario usuarioData = new Usuario(data);
		usuarioRepository.save(usuarioData);
	}
}
