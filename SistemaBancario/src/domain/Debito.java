/**
 * 
 */
package domain;

import java.util.Date;

/**
 * @author Pablo
 * 
 */
public class Debito extends Tarjeta {

	public Debito(Date mFechaDeCaducidad, String mNumero, String mTitular) {
		super(mFechaDeCaducidad, mNumero, mTitular);
	}

	public double getSaldo() {
		return this.mCuentaAsociada.getSaldo();
	}

	public void ingresar(double x) throws Exception {
		this.mCuentaAsociada.ingresar(x);
	}

	public void pagoEnEstablecimiento(String caca, double x) throws Exception {
		this.mCuentaAsociada.retirar(caca, x);
	}

	public void retirar(double x) throws Exception {
		this.mCuentaAsociada.retirar(x);
	}
}
