package com.example.backend_blog.comentario;

import java.sql.Timestamp;
import java.time.Instant;

import com.example.backend_blog.post.Post;
import com.example.backend_blog.post.PostRepository;
import com.example.backend_blog.post.PostRequestDTO;
import com.example.backend_blog.usuario.Usuario;
import com.example.backend_blog.usuario.UsuarioRepository;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="comentarios")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Data
@Setter
public class Comentario {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
	private Post post;
	 
	@OneToOne
	@JoinColumn(name = "autor_id")
	private Usuario usuario;
	
	private String conteudo;
	
	private Timestamp criado_em;
	
	private Timestamp deletado_em;
	
	public Comentario() {
		
	}
	
	 public Comentario(ComentarioRequestDTO data, UsuarioRepository usuarioRepository, PostRepository postreposiotry) {
	        this.post = postreposiotry.findById(data.post()).orElse(null);
	        this.usuario = usuarioRepository.findById(data.usuario()).orElse(null);
	        this.conteudo = data.conteudo();
	        this.criado_em = Timestamp.from(Instant.now());
	    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPost() {
		return post.getId();
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Long getUsuario() {
		return usuario.getId();
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
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
