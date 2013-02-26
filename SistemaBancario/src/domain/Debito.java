/**
 * 
 */
package domain;

import java.util.Date;

/**
 * @author Pablo
 *
 */
public class Debito implements Tarjeta {


	private Cuenta mCuentaAsociada;
	private Date mFechaDeCaducidad;
	private String mNumero;
	private String mTitular;
	
	/**
	 * @param mCuentaAsociada
	 * @param mFechaDeCaducidad
	 * @param mNumero
	 * @param mTitular
	 */
	public Debito(Cuenta mCuentaAsociada, Date mFechaDeCaducidad,String mNumero, String mTitular) {
		this.mCuentaAsociada = mCuentaAsociada;
		this.mFechaDeCaducidad = mFechaDeCaducidad;
		this.mNumero = mNumero;
		this.mTitular = mTitular;		
	}
	
	public Cuenta getmCuentaAsociada() {
		return mCuentaAsociada;
	}

	public void setmCuentaAsociada(Cuenta mCuentaAsociada) {
		this.mCuentaAsociada = mCuentaAsociada;
	}

	public Date getmFechaDeCaducidad() {
		return mFechaDeCaducidad;
	}

	public void setmFechaDeCaducidad(Date mFechaDeCaducidad) {
		this.mFechaDeCaducidad = mFechaDeCaducidad;
	}

	public String getmNumero() {
		return mNumero;
	}

	public void setmNumero(String mNumero) {
		this.mNumero = mNumero;
	}

	public String getmTitular() {
		return mTitular;
	}

	public void setmTitular(String mTitular) {
		this.mTitular = mTitular;
	}

	public double getSaldo() {
		return this.mCuentaAsociada.getSaldo();
	}
	
	public void ingresar(double x) {
		this.mCuentaAsociada.ingresar(x);
	}
	
	public void pagoEnEstablecimiento(String caca, double x) {
		this.mCuentaAsociada.retirar(caca, x);
	}
	
	public void retirar(double x){
		this.mCuentaAsociada.retirar(x);
	}
	
	public void setCuenta(Cuenta c) {
		this.mCuentaAsociada = c;
	}
}
