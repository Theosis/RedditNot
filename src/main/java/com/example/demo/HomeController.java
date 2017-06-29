package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@Autowired
	private PostRepository postRepository;
	
	@RequestMapping("/")
	public String home(Model m) {
		Iterable<Post> posts = postRepository.findAll();
		m.addAttribute("list", posts);
		return "index";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

}
