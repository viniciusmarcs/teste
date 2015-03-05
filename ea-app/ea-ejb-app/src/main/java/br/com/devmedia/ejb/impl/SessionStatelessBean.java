package br.com.devmedia.ejb.impl;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import br.com.devmedia.bo.UsuarioBO;
import br.com.devmedia.dao.ProductDAO;
import br.com.devmedia.ejb.services.IServicesBean;
import br.com.devmedia.entity.Pedido;
import br.com.devmedia.entity.Product;
import br.com.devmedia.entity.Usuario;

/**
 *
 * @author marcos
 */
@Stateless
public class SessionStatelessBean implements IServicesBean {

	@PersistenceContext(name = "devmedia")
	private EntityManager em;
	
    private static Logger logger;
    
    static {
    	logger = Logger.getLogger(SessionStatelessBean.class);
    }	
	
	public SessionStatelessBean() {
		logger.info("Session: " + em);
	}

	public Pedido getPedido() {
		return new Pedido(10000L, "Aberto");
	}

	public void addProduct(Product product) {
		if( logger.isDebugEnabled() ) {
			logger.debug("Product: " + product + ", Session: " + em);
		}
		ProductDAO dao = new ProductDAO(em);
		dao.add(product);
	}

	public List<Product> getListProducts() {
		List<Product> products = new LinkedList<Product>();

		String query = "FROM Product";
		Query queryList = em.createQuery(query);
		products = (List<Product>) queryList.getResultList();
		
		return products;
	}
	
	public void addUser(Usuario usuario){
		UsuarioBO bo = new UsuarioBO();
		bo.salvar(usuario);
	}
}
