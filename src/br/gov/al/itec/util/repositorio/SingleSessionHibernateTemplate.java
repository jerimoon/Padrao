package br.gov.al.itec.util.repositorio;


import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;

import br.gov.al.itec.util.Entidade;

public class SingleSessionHibernateTemplate{
	private Session session;



	public Transaction beginTransaction()	{
		return getSession().beginTransaction();
	}

	public SingleSessionHibernateTemplate(Session session){
		setSession(session);
	}

	public Session getSession(){
		return session;
	}

	public void setSession(Session session){
		this.session = session;
	}


	@SuppressWarnings("rawtypes")
	public Object get(Class clazz, Serializable key){
		return getSession().get(clazz, key);
	}

	public void saveOrUpdate(Serializable object){
		getSession().saveOrUpdate(object);
	}

	@SuppressWarnings("rawtypes")
	public List findByCriteria(DetachedCriteria detachedCriteria/*, int maxLengt*/){
		List retorno = detachedCriteria.getExecutableCriteria(getSession()).list();
		return retorno;
	}


	@SuppressWarnings("unchecked")
	public void saveOrUpdateAll(final Collection<? extends Entidade> entities)
			throws DataAccessException{

		for (Iterator<Entidade> it = (Iterator<Entidade>) entities.iterator(); it.hasNext();){
			getSession().saveOrUpdate(it.next());
		}
	}

	@SuppressWarnings("unchecked")
	public List<Entidade> find(final String queryString, final Object[] values)
			throws DataAccessException{
		Query queryObject = session.createQuery(queryString);
		if (values != null){
			for (int i = 0; i < values.length; i++){
				queryObject.setParameter(i, values[i]);
			}
		}
		return queryObject.list();
	}

	public void delete(Object entity) throws DataAccessException{
		delete(entity, null);
	}

	public void delete(final Object entity, final LockMode lockMode)
			throws DataAccessException{

		getSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public void deleteAll(final Collection<? extends Entidade> entities) throws DataAccessException{
		for (Iterator<Entidade> it = (Iterator<Entidade>) entities.iterator(); it.hasNext();){
			getSession().delete(it.next());
		}
	}



	public List<Entidade> find(String queryString) throws DataAccessException{
		return find(queryString, (Object[]) null);
	}

	public void setFlushMode(int flushMode)
	{

	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Entidade> loadAll(final Class entityClass) throws DataAccessException{
		Criteria criteria = getSession().createCriteria(entityClass);
		return criteria.list();
	}

	@SuppressWarnings("rawtypes")
	public Criteria createCriteria(final Class entityClass) throws DataAccessException{
		return getSession().createCriteria(entityClass);
	}

	public void refresh(Object object){
		getSession().refresh(object);
	}

	public void lock(final Object entity, final LockMode lockMode)
			throws DataAccessException{
		getSession().lock(entity, lockMode);
	}

	public void save(Serializable entity){
		getSession().save(entity);
	}

	public List<Entidade> findByNamedParam(final String queryString,
			final String[] paramNames, final Object[] values)
			throws DataAccessException{
		if (paramNames.length != values.length){
			throw new IllegalArgumentException(
					"Length of paramNames array must match length of values array");
		}

		Query queryObject = session.createQuery(queryString);
		if (values != null){
			for (int i = 0; i < values.length; i++){
				applyNamedParameterToQuery(queryObject, paramNames[i],
						values[i]);
			}
		}
		return queryObject.list();
	}

	@SuppressWarnings("unchecked")
	protected void applyNamedParameterToQuery(Query queryObject,
			String paramName, Object value) throws HibernateException{

		if (value instanceof Collection){
			queryObject.setParameterList(paramName, (Collection<Entidade>) value);
		} else if (value instanceof Object[]){
			queryObject.setParameterList(paramName, (Object[]) value);
		} else{
			queryObject.setParameter(paramName, value);
		}
	}

}
