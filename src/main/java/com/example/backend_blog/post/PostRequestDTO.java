package com.example.backend_blog.post;


public record PostRequestDTO(String titulo, String conteudo, Long autor, String imagem_url) {
	
}
