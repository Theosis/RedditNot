package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/add")
	public String add(Model m) {
		m.addAttribute("Post", new Post());	
		return "add";
	}
	
	@PostMapping("/add")
	public String save(@ModelAttribute("Post") Post post, Model m) {
		postRepository.save(post);
		Iterable<Post> posts = postRepository.findAll();
		m.addAttribute("list", posts);
		return "redirect:/";
	}

}
