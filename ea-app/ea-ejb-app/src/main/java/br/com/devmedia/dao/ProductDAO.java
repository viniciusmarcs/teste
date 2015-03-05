package br.com.devmedia.dao;

import javax.persistence.EntityManager;

import br.com.devmedia.entity.Product;

/**
 *
 * @author marcos
 */
public class ProductDAO extends GenericDAO<Product> {

	private EntityManager em;

	public ProductDAO(EntityManager em) {
		this.em = em;
	}

	public void add(Product product) {
		if (product == null) {
			System.out.println("Product is null " + product);
			return;
		}
		super.salvar(product);
	}

	public void delete(Product product) {
		if (product == null) {
			System.out.println("Product is null " + product);
			return;
		}
		super.excluir(product);
	}

	public void update(Product product) {
        if (product == null) {
            System.out.println("Product is null " );
            return;
        }
        super.salvar(product);   }
}
