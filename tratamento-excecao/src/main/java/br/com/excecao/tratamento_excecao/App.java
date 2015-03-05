package br.com.excecao.tratamento_excecao;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws BusinessException {

		System.out.println(dividePorZero());
	}

	public static int dividePorZero() throws BusinessException {
		int a = 10;

		try {
			System.out.println(a / 0);
		} catch (InternalError e) {
			throw new DivisaoPorZeroException();
		} catch (Exception e) {
			throw new MerchantNotFoundException();
		}

		return a;
	}
}
