/**
 * 
 */
package domain;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Pablo
 *
 */
public class Credito implements Tarjeta {

	private Cuenta mCuentaAsociada;
	private Date mFechaDeCaducidad;
	private String mNumero;
	private String mTitular;
	private double mCredito;
	private ArrayList<Movimiento> mMovimientos;
	
	public Credito(Cuenta mCuentaAsociada, Date mFechaDeCaducidad,String mNumero,
			String mTitular, double mCredito, ArrayList<Movimiento> mMovimientos) {
		this.mCuentaAsociada = mCuentaAsociada;
		this.mFechaDeCaducidad = mFechaDeCaducidad;
		this.mNumero = this.mCuentaAsociada.getmNumero();
		this.mTitular = this.mCuentaAsociada.getmTitular();
		this.mCredito = mCredito;
		this.mMovimientos = mMovimientos;
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

	public double getmCredito() {
		return mCredito;
	}

	public void setmCredito(double mCredito) {
		this.mCredito = mCredito;
	}

	public ArrayList<Movimiento> getmMovimientos() {
		return mMovimientos;
	}

	public void setmMovimientos(ArrayList<Movimiento> mMovimientos) {
		this.mMovimientos = mMovimientos;
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
	
	public double getCreditoDisponible() {
		return mCredito;
	}
	
	public void liquidar(int mes, int anno) {
		// Buscar movimientos de mes&anno
	}
	
}
