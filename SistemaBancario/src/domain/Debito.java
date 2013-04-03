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

	@Override
	public double getSaldo() {
		return this.mCuentaAsociada.getSaldo();
	}

	@Override
	public void ingresar(double x) throws Exception {
		this.mCuentaAsociada.ingresar(x);
	}
	
	@Override
	public void pagoEnEstablecimiento(String caca, double x) throws Exception {
		this.mCuentaAsociada.retirar(caca, x);
	}
	
	@Override
	public void retirar(double x) throws Exception {
		this.mCuentaAsociada.retirar(x);
	}
}
