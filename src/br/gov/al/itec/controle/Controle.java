package br.gov.al.itec.controle;


import static br.gov.al.itec.util.Utilidades.isEmpty;

import java.util.List;
import java.util.Map;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

import br.gov.al.itec.negocio.CatalogoRegraNegocio;
import br.gov.al.itec.util.Entidade;
import br.gov.al.itec.util.repositorio.SingleSessionHibernateTemplate;
import br.gov.al.itec.web.session.SessionFilter;


public abstract class Controle  
{
	
	private SingleSessionHibernateTemplate hibernateTemplate;
	private CatalogoRegraNegocio catalogoRegraNegocio;
	private LocalSessionFactoryBean sessionFactory; 
	
	public Controle(CatalogoRegraNegocio catalogoRegraNegocio, SingleSessionHibernateTemplate hibernateTemplate)
	{
		setCatalogoRegraNegocio(catalogoRegraNegocio);
		setHibernateTemplate(hibernateTemplate);
	}

	public Controle(CatalogoRegraNegocio catalogoRegraNegocio)
	{
		setCatalogoRegraNegocio(catalogoRegraNegocio);
		setHibernateTemplate(hibernateTemplate);
	}
	
	protected CatalogoRegraNegocio getCatalogoRegraNegocio()
	{
		return catalogoRegraNegocio;
	}

	private void setCatalogoRegraNegocio(CatalogoRegraNegocio catalogoRegraNegocio)
	{
		this.catalogoRegraNegocio = catalogoRegraNegocio;
	}

	public LocalSessionFactoryBean getSessionFactory()
	{
		return sessionFactory;
	}

	public void setSessionFactory(LocalSessionFactoryBean sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	
	@SuppressWarnings("deprecation")
	public SingleSessionHibernateTemplate getHibernateTemplate(){
		Map<String,Object > map =  SessionFilter.getThreadLocal().get();
		Session session = (Session)map.get("session");
		session.setFlushMode(FlushMode.NEVER);
		return new SingleSessionHibernateTemplate(session);
	}

	public void setHibernateTemplate(SingleSessionHibernateTemplate hibernateTemplate)
	{
		this.hibernateTemplate = hibernateTemplate;
	}

	protected List<Entidade> obterListaEntidadePorAtributo( Class<? extends  Entidade> classe, String nomeAtributo, Object valorAtributo ){
		
		DetachedCriteria pesquisa = DetachedCriteria.forClass(classe);
		pesquisa.add(Restrictions.eq(nomeAtributo, valorAtributo));
		
		@SuppressWarnings("unchecked")
		List<Entidade> retornoPesquisa = getHibernateTemplate().findByCriteria(pesquisa);
		return retornoPesquisa;
	}
	protected void validarAtributo(Map<String, String> mapErros,Entidade entidade, String nomeAtributo, Object valorAtributo,boolean obrigatorio, boolean unico,long tamanhoMaximo){
		if (obrigatorio&&isEmpty(valorAtributo)){
			mapErros.put(nomeAtributo,"Campo obrigatório : "+nomeAtributo);
		}else if(tamanhoMaximo>0&&!isEmpty(valorAtributo)&&(valorAtributo instanceof String)&&(valorAtributo.toString().length()>tamanhoMaximo)){
			
				mapErros.put(nomeAtributo,"O tamanho máximo do Campo "+nomeAtributo+" é de "+tamanhoMaximo+" caracteres.");
			
		}else if(unico && !isEmpty(valorAtributo)){
			List<Entidade> retornoPesquisa = obterListaEntidadePorAtributo(entidade.getClass(), nomeAtributo, valorAtributo);
			String descricao ;
			if ((retornoPesquisa.size() == 1	&& !retornoPesquisa.get(0).equals(entidade))||(retornoPesquisa.size()>1)) {
				if (valorAtributo instanceof Entidade) {
					descricao = ((Entidade) valorAtributo).getId().toString();
				}else{
					descricao = valorAtributo.toString();
				}
				mapErros.put(
						nomeAtributo,
						"O valor \""
								+ descricao
								+ "\" para o campo "+nomeAtributo+" já está sendo utilizado por outro registro!");
			}
		}
		
	}
	
	protected void validarAtributo(Map<String, String> mapErros,Entidade entidade, String nomeAtributo, Object valorAtributo,boolean obrigatorio, boolean unico){
		
		validarAtributo(mapErros, entidade, nomeAtributo, valorAtributo, obrigatorio, unico,60);
	}

	
}
