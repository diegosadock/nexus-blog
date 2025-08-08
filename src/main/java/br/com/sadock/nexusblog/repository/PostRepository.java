package br.com.sadock.nexusblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sadock.nexusblog.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
