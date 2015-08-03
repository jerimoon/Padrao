package br.gov.al.itec.util.repositorio;

import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.gov.al.itec.web.session.SessionFilter;
/**
 * Classe Interceptora de transações no sistema
 * @author robson.pastor
 *
 */
public class TransactionInterceptor implements MethodInterceptor{
	public Object invoke(MethodInvocation invocation) throws Throwable{
		Object toReturn = null;
		Map<String,Object> map = (Map<String,Object>) SessionFilter.getThreadLocal().get();
		Session session = (Session)map.get("session"); 
		Transaction transaction = session.beginTransaction();
		try {
			toReturn = invocation.proceed();
			session.flush();
			transaction.commit();
		}
		catch (Exception e){
			e.printStackTrace();
			transaction.rollback();
			throw e;
		}
		
		return toReturn;
	}

}
