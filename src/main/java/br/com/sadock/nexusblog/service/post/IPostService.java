package br.com.sadock.nexusblog.service.post;

import java.util.List;

import br.com.sadock.nexusblog.dto.PostRequestDTO;
import br.com.sadock.nexusblog.dto.PostResponseDTO;

public interface IPostService {
	
	public List<PostResponseDTO> listarTodos();
	public PostResponseDTO findById(Integer id);
	public PostResponseDTO criarPost(PostRequestDTO dto);
	public PostResponseDTO alterarPost(Integer id, PostRequestDTO dto);
	public void deletarPost(Integer id);

}
