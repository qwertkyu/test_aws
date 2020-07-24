package com.example.webservice.web;

import org.springframework.web.bind.annotation.RestController;

import com.example.webservice.domain.posts.PostsRepository;
import com.example.webservice.dto.posts.PostsSaveRequestDto;
import com.example.webservice.service.PostsService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@AllArgsConstructor
public class WebRestController {
	
	//private PostsRepository postsRepository;
	private PostsService postsService;
	
	@GetMapping("/hello")
	public String hello() {
		return "HelloWorld";
	}
	
	@PostMapping("/posts")
	public void savePosts(@RequestBody PostsSaveRequestDto dto) {
		postsService.save(dto);
	}
}