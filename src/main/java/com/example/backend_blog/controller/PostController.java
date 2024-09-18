package com.example.backend_blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
		Post usuarioData = new Post(data,usuarioRepository);
		postrepository.save(usuarioData);
	}
}
