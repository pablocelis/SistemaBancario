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
		this.mMovimientos = new ArrayList<Movimiento>();
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
		double saldo = 0;
		
		for(Movimiento mov: mMovimientos) {
			saldo += mov.getmImporte();
		}
		return saldo;
	}
	
	public void ingresar(double x) throws Exception {
		
		if (x <= 0) {
			throw new Exception("No se pueden ingresar cantidades negativas");
		}		
		Movimiento mov = new Movimiento();
		mov.setFecha(new Date());
		mov.setmConcepto("Sobres - Luis el Cabron");
		mov.setmImporte(x);
		mMovimientos.add(mov);
	}
	
	public void ingresar(String concepto, double x) throws Exception {
		
		if (x <= 0) {
			throw new Exception("No se pueden ingresar cantidades negativas");
		}		
		Movimiento mov = new Movimiento();
		mov.setFecha(new Date());
		mov.setmConcepto(concepto);
		mov.setmImporte(x);
		mMovimientos.add(mov);
	}
	
	public void retirar(double x) throws Exception {
		
		if (x <= 0) {
			throw new Exception("No se pueden retirar cantidades negativas");
		}
		Movimiento mov = new Movimiento();
		mov.setFecha(new Date());
		mov.setmConcepto("Sobres - Luis el Cabron");
		mov.setmImporte(-x);
		mMovimientos.add(mov);
	}
	
	public void retirar(String concepto, double x) throws Exception {
		
		if (x <= 0) {
			throw new Exception("No se pueden retirar cantidades negativas");
		}
		Movimiento mov = new Movimiento();
		mov.setFecha(new Date());
		mov.setmConcepto(concepto);
		mov.setmImporte(-x);
		mMovimientos.add(mov);
	}
}
