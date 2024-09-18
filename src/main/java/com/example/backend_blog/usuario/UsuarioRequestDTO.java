package com.example.backend_blog.usuario;

import java.sql.Timestamp;

public record UsuarioRequestDTO(String nome_usuario, String email, String senha, Boolean admin) {

}
