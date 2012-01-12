package edu.ecm.blog.web.controller;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ecm.blog.domain.Post;
import edu.ecm.blog.service.PostService;

@Controller
public class BlogController {
   @RequestMapping("/index")
   public String index(Model model) {
	   model.addAttribute("posts", postService.find(0, 10));
      return "index";
   }
   
   @RequestMapping("/billet/{slug}")
   public String post(@PathVariable String slug, Model model) {
       model.addAttribute("post", postService.findBySlug(slug));

       return "post";
   }
   
   @Inject
   private PostService postService;
   
   @PostConstruct
   public void bootstrap() {
	   if (postService.count()!=0)
	   {
		   //postService.clear();
		   return;
	   }
	   
	   //postService.clear();
	   
   
	   
	   Post post = new Post();
	   post.setTitle("un post");
	       post.setDate(new Date());
	       post.setSlug("un-slug");

	       postService.save(post);
	       
	       Post post2 = new Post();
	       post2.setTitle("deux post");
	       post2.setDate(new Date());
	       post2.setSlug("deux-slug");

	       postService.save(post2);
	       
	       Post post3 = new Post();
	       post3.setTitle("trois post");
	       post3.setDate(new Date());
	       post3.setSlug("trois-slug");

	       postService.save(post3);
	   

   }
}