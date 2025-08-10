package br.com.sadock.nexusblog.service.post;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sadock.nexusblog.dto.PostRequestDTO;
import br.com.sadock.nexusblog.dto.PostResponseDTO;
import br.com.sadock.nexusblog.mapper.PostMapper;
import br.com.sadock.nexusblog.model.Post;
import br.com.sadock.nexusblog.model.Usuario;
import br.com.sadock.nexusblog.repository.PostRepository;
import br.com.sadock.nexusblog.repository.UsuarioRepository;

@Service
public class PostServiceImpl implements IPostService {
	
	private final PostRepository postRepository;
	private final UsuarioRepository usuarioRepository;
	
	public PostServiceImpl(PostRepository postRepository, UsuarioRepository usuarioRepository) {
		this.postRepository = postRepository;
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public List<PostResponseDTO> listarTodos() {
		// TODO Auto-generated method stub
		return postRepository.findAll().stream().map(PostMapper::toResponseDTO).toList();
	}

	@Override
	public PostResponseDTO findById(Integer id) {
		// TODO Auto-generated method stub
		Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post não encontrado com o id " + id));
		
		return PostMapper.toResponseDTO(post);
	}

	@Override
	public PostResponseDTO criarPost(PostRequestDTO dto) {
		Usuario usuario = usuarioRepository.findById(dto.usuarioId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado com o id " + dto.usuarioId()));
		
		Post post = PostMapper.toEntity(dto, usuario);
		
		Post salvo = postRepository.save(post);
		
		return PostMapper.toResponseDTO(salvo);
	}

	@Override
	public PostResponseDTO alterarPost(Integer id, PostRequestDTO dto) {
		Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post não encontrado com o id " + id));
		
		Usuario usuario = usuarioRepository.findById(dto.usuarioId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado com o id " + dto.usuarioId()));
		
		post.setTitulo(dto.titulo());
		post.setConteudo(dto.conteudo());
		post.setUsuario(usuario);
		
		Post atualizado = postRepository.save(post);
		
		return PostMapper.toResponseDTO(atualizado);
	}

	@Override
	public void deletarPost(Integer id) {
		if(!postRepository.existsById(id)) {
			throw new RuntimeException("Post não encontrado!");
		}
		
		postRepository.deleteById(id);
		
	}
	
	

}
