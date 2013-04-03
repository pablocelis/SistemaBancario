package domain;

import java.util.Date;

public abstract class Tarjeta {

	protected Cuenta mCuentaAsociada;
	private Date mFechaDeCaducidad;
	private String mNumero;
	private String mTitular;
	
	public Tarjeta(Date mFechaDeCaducidad,
			String mNumero, String mTitular) {
		this.mFechaDeCaducidad = mFechaDeCaducidad;
		this.mNumero = mNumero;
		this.mTitular = mTitular;
		Cuenta c  = new Cuenta(mNumero, mTitular);
		setCuenta(c);
	}

	abstract double getSaldo();
	
	abstract void ingresar(double x) throws Exception;
	
	abstract void pagoEnEstablecimiento(String caca, double x) throws Exception;
	
	abstract void retirar(double x) throws Exception;
	
	public void setCuenta(Cuenta c) {
		this.mCuentaAsociada = c;
	}
	
	public Cuenta getmCuentaAsociada() {
		return mCuentaAsociada;
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

}
