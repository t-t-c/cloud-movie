package com.skcc.content.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.content.service.ContentService;
import com.skcc.content.vo.Content;

@RestController
public class ContentRestController {
	
	private ContentService contentService;
	
	public ContentRestController(ContentService contentService) {
		this.contentService = contentService;
	}
	
	@GetMapping
	public String index() {
		return "Welcome to Cloud Movie";
	}
	
	// 전체조회 
//	@RequestMapping(path="/contents", method=RequestMethod.GET)
	@GetMapping("/contents")
	public List<Content> getContents(){
		return contentService.getContents();
	}
	
	// 상세조회 
	// http:/localhost:8090/content/1
	@GetMapping("/contents/{id}")
	public Content getContentById(@PathVariable("id") int id) {
		return contentService.getContentById(id);
	}
	
	// 데이터 수정 
	// http://localhost:8090/content/1 (body : ~~ 기준으로 수정) 
	@PutMapping("/contents/{id}")
	public int updateContents(@PathVariable("id") int id, @RequestBody Content content) {
		content.setId(id);
		return contentService.updateContent(content);
	}
	
	// 데이터 입력
	// http://localhost:8090/contents (body : ~~ 기준으로 입력)
	@PostMapping("/contents")
	public int createContent(@RequestBody Content content) {
		return contentService.createContent(content);
	}
	
	// 데이터 삭제
	// http://localhost:8090/contents/{id}
	@DeleteMapping("/contents/{id}")
	public int deleteContent(@PathVariable("id") int id) {
		return contentService.deleteContent(id);
	}
	
}








