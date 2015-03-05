package br.com.devmedia.ejb.services;

import java.util.List;

import javax.ejb.Remote;

import br.com.devmedia.entity.Pedido;
import br.com.devmedia.entity.Product;

/**
 *
 * @author marcos
 */
@Remote
public interface IServicesBean {
    
    public Pedido getPedido();
    
    public List<Product> getListProducts();
}
