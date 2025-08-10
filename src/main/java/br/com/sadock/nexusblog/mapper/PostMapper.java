package br.com.sadock.nexusblog.mapper;

import br.com.sadock.nexusblog.dto.PostRequestDTO;
import br.com.sadock.nexusblog.dto.PostResponseDTO;
import br.com.sadock.nexusblog.model.Post;
import br.com.sadock.nexusblog.model.Usuario;

public class PostMapper {
	
	public static PostResponseDTO toResponseDTO(Post post) {
		return new PostResponseDTO(post.getId(),
								   post.getTitulo(),
								   post.getConteudo(),
								   post.getUsuario().getNome(),
								   post.getDataCriacao());
	}
	
	public static Post toEntity(PostRequestDTO dto, Usuario usuario) {
		Post post = new Post();
		post.setTitulo(dto.titulo());
		post.setConteudo(dto.conteudo());
		post.setUsuario(usuario);
		return post;
	}

}
