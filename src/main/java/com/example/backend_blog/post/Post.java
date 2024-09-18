package com.example.backend_blog.post;

import java.sql.Timestamp;
import java.time.Instant;

import com.example.backend_blog.usuario.Usuario;
import com.example.backend_blog.usuario.UsuarioRepository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "posts")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String conteudo;

    private String imagem_url;

    @OneToOne
    @JoinColumn(name = "id")
    private Usuario autor;

    private Timestamp criado_em;

    private Timestamp deletado_em;
    
    public Post() {
		
	}
  
    public Post(PostRequestDTO data, UsuarioRepository usuarioRepository) {
        this.titulo = data.titulo();
        this.conteudo = data.conteudo();
        this.imagem_url = data.imagem_url();
        this.criado_em = Timestamp.from(Instant.now());
        this.autor = usuarioRepository.findById(data.autor()).orElse(null);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getImagem_url() {
		return imagem_url;
	}

	public void setImagem_url(String imagem_url) {
		this.imagem_url = imagem_url;
	}

	public Long getAutor() {
		return autor.getId();
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
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
