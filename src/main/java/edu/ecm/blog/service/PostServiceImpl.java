package edu.ecm.blog.service;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import edu.ecm.blog.domain.Post;

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
		session.save(post);
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

//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//
//	}

}
