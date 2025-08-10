package br.com.sadock.nexusblog.dto;

import java.time.LocalDateTime;

public record PostResponseDTO(Integer id, String titulo, String conteudo, String nomeUsuario, LocalDateTime dataCriacao) {

}
