package br.gov.al.itec.web.session;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Classe que abre as sessões do Spring
 * @author robson.pastor
 *
 */
public class SessionFilter extends OncePerRequestFilter {

	private static ThreadLocal<Map<String,Object>> myTreadLocal = new ThreadLocal<Map<String,Object>>();
	
	public static ThreadLocal<Map<String,Object>> getThreadLocal(){
		return myTreadLocal;
	}

	protected void doFilterInternal(
			HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {


		Session session;
		SessionFactory sessionFactory =
		(SessionFactory) WebUtils.getWebApplicationContext(this.getServletContext()).getBean("sessionFactory");
		session = sessionFactory.openSession();

		try{
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("session",session);
			myTreadLocal.set(map);
			filterChain.doFilter(request, response);

			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			((Session)((Map)myTreadLocal.get()).get("session")).close();
			session =null;
			myTreadLocal.set(null);
			System.gc();
		}
	}


}
