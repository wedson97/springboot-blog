package com.example.backend_blog.comentario;

import java.sql.Timestamp;


public record ComentarioResponseDTO(Long id, Long post, Long usuario, String conteudo, Timestamp criado_em, Timestamp deletado_em) {
	public ComentarioResponseDTO(Comentario comentario) {
		this(comentario.getId(), 
			comentario.getPost(), 
			comentario.getUsuario(), 
			comentario.getConteudo(), 
			comentario.getCriado_em(),
			comentario.getDeletado_em()
			);
	}
}	
