package edu.ecm.blog.service;



import java.util.Date;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import edu.ecm.blog.domain.Author;
import edu.ecm.blog.domain.Post;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class PostServiceTest {
	@Inject   
	private SessionFactory sessionFactory;
	
	   @Inject
	   private PostService postService;

//	   @Before
//	   public void createSessionFactory() {
//	      Configuration configuration = new Configuration();
//
//	      configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyDialect");
//	      configuration.setProperty("hibernate.connection.url", "jdbc:derby:target/testdb;create=true");
//	      configuration.setProperty("hibernate.connection.driver_class", "org.apache.derby.jdbc.EmbeddedDriver");
//	      configuration.setProperty("hibernate.hbm2ddl.auto", "create-drop");
//
//	      configuration.addAnnotatedClass(Author.class);
//	      configuration.addAnnotatedClass(Post.class);
//
//	      sessionFactory = configuration.buildSessionFactory();
//	   }

	   @After
	   public void cleanDb() {
	      Session session = sessionFactory.openSession();

	      Transaction transaction = session.beginTransaction();

	      session.createQuery("delete from Post").executeUpdate();

	      transaction.commit();

	      session.close();

	      //sessionFactory.close();
	   }

	   @Test
	   public void save() {
//	       PostService postService = new PostService();
//	       postService.setSessionFactory(sessionFactory);
		   


	       Post post = new Post();
	       post.setTitle("un post");
	       post.setDate(new Date());

	       postService.save(post);
	       
	       Session session = sessionFactory.openSession();

	       Assert.assertEquals(1, session.createQuery("from Post").list().size());

	       session.close();
	   }
	   
	   
	   @Test
	   public void delete() {
	       //PostService postService = new PostService();
	       //postService.setSessionFactory(sessionFactory);

	       Post post = new Post();
	       post.setTitle("un post");
	       post.setDate(new Date());

	       postService.save(post);

	       postService.delete(post.getId());

	       Session session = sessionFactory.openSession();

	       Assert.assertEquals(0, session.createQuery("from Post").list().size());

	       session.close();
	   }
	   
	   
	   @Test
	   public void find() {
	       //PostService postService = new PostService();
	       //postService.setSessionFactory(sessionFactory);

	       Post post = new Post();
	       post.setTitle("un post");
	       post.setDate(new Date());

	       postService.save(post);

	       post = new Post();
	       post.setTitle("un post");
	       post.setDate(new Date());

	       postService.save(post);

	       Assert.assertEquals(2, postService.find(0, 10).size());
	       Assert.assertEquals(1, postService.find(0, 1).size());
	       Assert.assertEquals(0, postService.find(1, 10).size());
	   }
	   
	   @Test
	   public void count() {
	       //PostService postService = new PostService();
	       //postService.setSessionFactory(sessionFactory);

	       Post post = new Post();
	       post.setTitle("un post");
	       post.setDate(new Date());

	       postService.save(post);

	       post = new Post();
	       post.setTitle("un post");
	       post.setDate(new Date());

	       postService.save(post);

	       Assert.assertEquals(2, postService.count());
	   }
	   
	}