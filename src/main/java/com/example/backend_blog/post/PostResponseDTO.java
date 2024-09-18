package com.example.backend_blog.post;

import java.sql.Timestamp;

import com.example.backend_blog.usuario.Usuario;

public record PostResponseDTO(Long id, String titulo, String conteudo, String imagem_url, Long autor, Timestamp criado_em, Timestamp deletado_em) {
	public PostResponseDTO(Post post) {
		this(post.getId(),
				post.getTitulo(),
				post.getConteudo(),
				post.getImagem_url(),
				post.getAutor(),
				post.getCriado_em(),
				post.getDeletado_em()
				);
	}
}
