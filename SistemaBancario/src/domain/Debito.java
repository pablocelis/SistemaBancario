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

	
	public Debito(Date mFechaDeCaducidad,
			String mNumero, String mTitular) {
		super(mFechaDeCaducidad, mNumero, mTitular);
	}
	
	public double getSaldo() {
		return this.mCuentaAsociada.getSaldo();
	}
	
	public void ingresar(double x) {
		try {
			this.mCuentaAsociada.ingresar(x);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void pagoEnEstablecimiento(String caca, double x) {
		try {
			this.mCuentaAsociada.retirar(caca, x);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void retirar(double x) {
		try {
			this.mCuentaAsociada.retirar(x);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
