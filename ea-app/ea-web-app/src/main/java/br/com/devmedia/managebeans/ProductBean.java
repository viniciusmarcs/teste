/**
 * 
 */
package br.com.devmedia.managebeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

import org.apache.log4j.Logger;

import br.com.devmedia.ejb.services.IServicesBean;
import br.com.devmedia.entity.Product;

/**
 * @author marcos
 *
 */
@Named(value = "productBean")
@SessionScoped
public class ProductBean implements Serializable {

    /**
     * Paginator variables
     */
    int startId;
    int endId;
    private int recordCount = 1000;
    private int pageSize = 10;
    private Product current;
    private int selectedItemIndex;
    /** End paginator variables */
    
    DataModel<?> products;

    @EJB
    private IServicesBean sessionBean;
    
    private static Logger logger;
    
    static {
    	logger = Logger.getLogger(ProductBean.class);
    }

    /**
     * Creates a new instance of ProductBean
     */
    public ProductBean() {
    	logger.info("Loading ProductBean.............>>>>>>>");
        startId = 1;
        endId = 10;
        
        logger.info("Loading IServicesBean.............>>>>>>> " + sessionBean);
    }
    
    public ProductBean(int startId, int endId) {
        this.startId = startId;
        this.endId = endId;
    }

    public Product getSelected() {
        if (current == null) {
            current = new Product();
            selectedItemIndex = -1;
        }
        return current;
    }


//    public DataModel getFilmTitles() {;
//        if (products == null) {
//            products = new ListDataModel(helper.getFilmTitles(startId, endId));
//        }
//        return products;
//    }

    void recreateModel() {
        products = null;
    }    

    public DataModel<?> getProducts() {
    	System.out.println("sessionBean: " + sessionBean);
        if (products == null) {
            products = new ListDataModel(sessionBean.getListProducts());
        }

        return products;
    }

    public boolean isHasNextPage() {
        if (endId + pageSize <= recordCount) {
            return true;
        }
        return false;
    }

    public boolean isHasPreviousPage() {
        if (startId - pageSize > 0) {
            return true;
        }
        return false;
    }

    public String next() {
        startId = endId + 1;
        endId = endId + pageSize;
        recreateModel();
        return "index";
    }

    public String previous() {
        startId = startId - pageSize;
        endId = endId - pageSize;
        recreateModel();
        return "index";
    }

    public int getPageSize() {
        return pageSize;
    }

    public String prepareView() {
        current = (Product) sessionBean.getListProducts(); //.getRowData();
        return "browse";
    }

    public String prepareList() {
        recreateModel();
        return "index";
    }

}
