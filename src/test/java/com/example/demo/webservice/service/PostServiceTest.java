package com.example.demo.webservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.aspectj.lang.annotation.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.webservice.Application;
import com.example.webservice.domain.posts.Posts;
import com.example.webservice.domain.posts.PostsRepository;
import com.example.webservice.dto.posts.PostsSaveRequestDto;
import com.example.webservice.service.PostsService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class PostServiceTest {
	
	@Autowired
	private PostsService postsService;
	
	@Autowired
	private PostsRepository postsRepository;
	
	@After(value = "")
	public void cleanup() {
		postsRepository.deleteAll();
	}
	
	@Test
	public void Dtodata_save () {
		PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
				.author("spbot")
				.content("test")
				.title("testtitle")
				.build();
		
		postsService.save(dto);
		
		Posts posts = postsRepository.findAll().get(0);
		assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
	    assertThat(posts.getContent()).isEqualTo(dto.getContent());
	    assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
	}

}
