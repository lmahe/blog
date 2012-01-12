package edu.ecm.blog.service;

import java.util.List;


import edu.ecm.blog.domain.Post;


public interface PostService {

	public void save(Post post);

	public void delete(Long id);
	
	public void clear();

	public List<Post> find(int pageIndex, int pageSize);

	public int count();

	public Post findBySlug(String slug);

	public Post findById(Long id);

}