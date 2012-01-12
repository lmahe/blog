package edu.ecm.blog.service;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ecm.blog.domain.Post;

@Service
public class PostServiceImpl implements PostService {

	@Inject
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see edu.ecm.blog.service.PostService#save(edu.ecm.blog.domain.Post)
	 */
	@Override
	@Transactional
	public void save(Post post) {
		//Session session = sessionFactory.openSession();
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(post);
		//session.close();

	}

	/* (non-Javadoc)
	 * @see edu.ecm.blog.service.PostService#delete(java.lang.Long)
	 */
	@Override
	@Transactional
	public void delete(Long id) {

		Session session = sessionFactory.getCurrentSession();


		session.createQuery("delete from Post where id =:id").setLong("id", id)
				.executeUpdate();



		//session.close();
	}
	
	@Override
	@Transactional
	public void clear()
	{
		Session session = sessionFactory.getCurrentSession();
		
		session.createQuery("delete from Post")
		.executeUpdate();
		
	}
	

	/* (non-Javadoc)
	 * @see edu.ecm.blog.service.PostService#find(int, int)
	 */
	@Override
	@Transactional(readOnly=true)
	public List<Post> find(int pageIndex, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(Post.class);
		criteria.setFirstResult(pageIndex * pageSize);
		criteria.setMaxResults(pageSize);
		criteria.addOrder(Order.desc("date"));
		
		
		@SuppressWarnings("unchecked")
		List<Post> list = criteria.list();
		
		//session.close();
		
		return list;

		
	}

	/* (non-Javadoc)
	 * @see edu.ecm.blog.service.PostService#count()
	 */
	@Override
	@Transactional(readOnly=true)
	public int count() {
		Session session = sessionFactory.getCurrentSession();
		Long r = (Long) session.createQuery("select count (*) from Post").uniqueResult();
		//session.close();
		return r.intValue();

	}

	@Override
	@Transactional(readOnly=true)
	public Post findBySlug(String slug) {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Post where slug =:slug").setString("slug", slug);
	
		@SuppressWarnings("unchecked")
		List<Post> list = query.list();

		if (list.size() == 0)
		{		
			return null;
		}
		else
		{
			return list.get(0);
		}
	}

	@Override
	@Transactional
	public Post findById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Post where id =:id").setLong("id", id);
		
		@SuppressWarnings("unchecked")
		List<Post> list = query.list();

		if (list.size() == 0)
		{		
			return null;
		}
		else
		{
			return list.get(0);
		}
	}

//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//
//	}

}
