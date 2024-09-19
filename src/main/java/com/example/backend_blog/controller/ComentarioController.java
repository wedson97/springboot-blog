package com.example.backend_blog.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_blog.comentario.Comentario;
import com.example.backend_blog.comentario.ComentarioRepository;
import com.example.backend_blog.comentario.ComentarioRequestDTO;
import com.example.backend_blog.comentario.ComentarioResponseDTO;
import com.example.backend_blog.post.Post;
import com.example.backend_blog.post.PostRepository;
import com.example.backend_blog.post.PostRequestDTO;
import com.example.backend_blog.usuario.UsuarioRepository;

@RestController
@RequestMapping("comentario")
public class ComentarioController {
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	@Autowired
	private PostRepository postrepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	
	@GetMapping
	public List<ComentarioResponseDTO> getAll() {
		
		List<ComentarioResponseDTO> comentarios = comentarioRepository.findAll().stream().map(ComentarioResponseDTO::new).toList();
		return comentarios;
	}
	
	@PostMapping 
	public void salvarComentario(@RequestBody ComentarioRequestDTO data) {
		Comentario comentarioData = new Comentario(data, usuarioRepository, postrepository);
		comentarioRepository.save(comentarioData);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Comentario> editarComentario(@PathVariable Long id, @RequestBody ComentarioRequestDTO data) {
		Optional<Comentario> comentario_id = comentarioRepository.findById(id);
		Comentario comentario = comentario_id.get();
        comentario.setConteudo(data.conteudo());
        comentarioRepository.save(comentario);
        return ResponseEntity.ok(comentario);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Comentario> deletarComentario(@PathVariable Long id) {
		Optional<Comentario> comentario_id = comentarioRepository.findById(id);
		Comentario comentario = comentario_id.get();
		comentarioRepository.delete(comentario);
		return ResponseEntity.ok(comentario);
	}
}
