package com.example.backend_blog.usuario;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Table(name="usuarios")
@Entity(name="usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Data
@Setter
public class Usuario {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome_usuario;
	
	private String email;
	
	private String senha;
	
	private Boolean admin;
	
	private Timestamp criado_em;
	
	private Timestamp deletado_em;
	
	public Usuario() {
		
	}
  
	public Usuario(UsuarioRequestDTO data) {
        this.nome_usuario = data.nome_usuario();
        this.email = data.email();
        this.senha = data.senha();
        this.admin = data.admin();
        this.criado_em =  Timestamp.from(Instant.now());
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome_usuario() {
		return nome_usuario;
	}

	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public Timestamp getCriado_em() {
		return criado_em;
	}

	public void setCriado_em(Timestamp criado_em) {
		this.criado_em = criado_em;
	}

	public Timestamp getDeletado_em() {
		return deletado_em;
	}

	public void setDeletado_em(Timestamp deletado_em) {
		this.deletado_em = deletado_em;
	}
	
	

}
