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

import com.example.backend_blog.post.Post;
import com.example.backend_blog.post.PostRepository;
import com.example.backend_blog.post.PostRequestDTO;
import com.example.backend_blog.post.PostResponseDTO;
import com.example.backend_blog.usuario.UsuarioRepository;

@RestController
@RequestMapping("post")
public class PostController {
	@Autowired
	private PostRepository postrepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<PostResponseDTO> getAll() {
		
		List<PostResponseDTO> posts = postrepository.findAll().stream().map(PostResponseDTO::new).toList();
		return posts;
	}
	
	@PostMapping
	public void salvarPost(@RequestBody PostRequestDTO data) {
		Post postData = new Post(data,usuarioRepository);
		postrepository.save(postData);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Post> editarPost(@PathVariable Long id,@RequestBody PostRequestDTO data ) {
		Optional<Post> post_por_id = postrepository.findById(id);
		Post post = post_por_id.get();
        post.setTitulo(data.titulo());
        post.setConteudo(data.conteudo());
        post.setImagem_url(data.imagem_url());
        postrepository.save(post);
        return ResponseEntity.ok(post);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Post> excluirPost(@PathVariable Long id){
		Optional<Post> post_por_id = postrepository.findById(id);
		Post post = post_por_id.get();
		postrepository.delete(post);
		return ResponseEntity.ok(post);
	}
}
