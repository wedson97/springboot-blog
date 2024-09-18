package com.example.backend_blog.usuario;

import java.sql.Timestamp;

public record UsuarioResponseDTO(Long id, String nome_usuario, String email, String senha, Boolean admin, Timestamp criado_em, Timestamp deletado_em) {
    public UsuarioResponseDTO(Usuario usuario) {
        this(usuario.getId(), 
             usuario.getNome_usuario(), 
             usuario.getEmail(), 
             usuario.getSenha(), 
             usuario.getAdmin(), 
             usuario.getCriado_em(), 
             usuario.getDeletado_em());
    }
}
