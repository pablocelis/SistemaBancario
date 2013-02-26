package domain;

import java.util.ArrayList;
import java.util.Date;

public class Cuenta {

	private ArrayList<Movimiento> mMovimientos;
	private String mNumero;
	private String mTitular;
	
	public Cuenta(String mNumero, String mTitular) {
		this.mNumero = mNumero;
		this.mTitular = mTitular;
	}
	
	public ArrayList<Movimiento> getmMovimientos() {
		return mMovimientos;
	}

	public void setmMovimientos(ArrayList<Movimiento> mMovimientos) {
		this.mMovimientos = mMovimientos;
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
		return 0;
	}
	
	public void ingresar(double x) {
		Movimiento mov = new Movimiento();
		mov.setFecha(new Date());
		mov.setmConcepto("Sobres - Luis el Cabron");
		mov.setmImporte(x);
	}
	
	public void ingresar(String concepto, double x) {
		Movimiento mov = new Movimiento();
		mov.setFecha(new Date());
		mov.setmConcepto(concepto);
		mov.setmImporte(x);
	}
	
	public void retirar(double x) {
		Movimiento mov = new Movimiento();
		mov.setFecha(new Date());
		mov.setmConcepto("Sobres - Luis el Cabron");
		mov.setmImporte(-x);
	}
	
	public void retirar(String concepto, double x) {
		Movimiento mov = new Movimiento();
		mov.setFecha(new Date());
		mov.setmConcepto(concepto);
		mov.setmImporte(-x);
	}
}
