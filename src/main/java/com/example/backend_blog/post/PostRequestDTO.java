package com.example.backend_blog.post;

import com.example.backend_blog.usuario.Usuario;

public record PostRequestDTO(String titulo, String conteudo, Long autor, String imagem_url) {
	
}
