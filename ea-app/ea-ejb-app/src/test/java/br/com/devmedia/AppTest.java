package br.com.devmedia;

import java.math.BigDecimal;
import java.util.Random;

import org.hibernate.Session;

import br.com.devmedia.entity.Product;
import br.com.devmedia.hibernate.HibernateUtil;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		System.out.println("Maven + Hibernate + Oracle");
		Session session = HibernateUtil.getSessionFactory().openSession();
 
		session.beginTransaction();
		BigDecimal id = new BigDecimal( new Random().nextInt() ).setScale(0);
		Product product = new Product( id.longValue(), "" + new Random().nextDouble() , new BigDecimal( 3500 ) );
		assertNotNull(session.save(product));
		session.getTransaction().commit();
		session.close();
		
		updateApp();
	}
	
	public void updateApp(){
//		System.out.println("Maven + Hibernate + Oracle");
//		Session session = HibernateUtil.getSessionFactory().openSession();
// 
//		session.beginTransaction();
//		Product product = (Product) session.get(Product.class, new Random().nextLong());
//		product.setName("MacBook Update ");
//		
//		assertNotNull(session.merge(product));
//		session.getTransaction().commit();
//		session.close();
	}
}
