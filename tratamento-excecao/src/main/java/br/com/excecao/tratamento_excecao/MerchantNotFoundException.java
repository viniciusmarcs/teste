/**
 * 
 */
package br.com.excecao.tratamento_excecao;

/**
 * @author viniciustatiane
 *
 */
public class MerchantNotFoundException extends BusinessException {

	/**
	 * 
	 */
	public MerchantNotFoundException() {
		System.out.println( "MerchantNotFoundException =======>>>>>>> " );
	}

	/**
	 * @param message
	 */
	public MerchantNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public MerchantNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public MerchantNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public MerchantNotFoundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
