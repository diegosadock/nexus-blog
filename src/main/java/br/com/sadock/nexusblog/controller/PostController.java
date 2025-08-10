package br.com.sadock.nexusblog.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sadock.nexusblog.dto.PostRequestDTO;
import br.com.sadock.nexusblog.dto.PostResponseDTO;
import br.com.sadock.nexusblog.service.post.IPostService;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	private final IPostService postService;
	
	public PostController(IPostService postService) {
		this.postService = postService;
	}
	
	@GetMapping
	public ResponseEntity<List<PostResponseDTO>> listarTodos() {
		return ResponseEntity.ok(postService.listarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PostResponseDTO> listarPeloId(@PathVariable Integer id) {
		PostResponseDTO response = postService.findById(id);
		
		if (response != null) {
			return ResponseEntity.ok(response);
		}
		
		return ResponseEntity.badRequest().build();
		
	}
	
	@PostMapping
	public ResponseEntity<PostResponseDTO> criarPost(@RequestBody PostRequestDTO dto) {
		PostResponseDTO response = postService.criarPost(dto);
		
		if (response != null) {
			return ResponseEntity.status(201).body(response);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PostResponseDTO> alterarPost(@RequestBody PostRequestDTO dto, @PathVariable Integer id) {
		PostResponseDTO response = postService.alterarPost(id, dto);
		
		if (response != null) {
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id) {
		postService.deletarPost(id);
		return ResponseEntity.noContent().build();
	}
	
	
	

}
