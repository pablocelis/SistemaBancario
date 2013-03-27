/**
 * 
 */
package domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Pablo
 * 
 */
public class Credito extends Tarjeta {

	private double mCredito;
	private ArrayList<Movimiento> mMovimientos;

	public Credito(Date mFechaDeCaducidad, String mNumero, String mTitular) {
		super(mFechaDeCaducidad, mNumero, mTitular);
		this.mMovimientos = new ArrayList<Movimiento>();
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

	public void ingresar(double x) throws Exception {

		if (x <= 0) {
			throw new Exception("No se pueden ingresar cantidades negativas");
		}
		Movimiento mov = new Movimiento();
		mov.setFecha(new Date());
		mov.setmConcepto("Ingreso Credito");
		mov.setmImporte(x);
		this.mMovimientos.add(mov);

		this.mCredito += x;
	}

	public void pagoEnEstablecimiento(String caca, double x) throws Exception {

		if (x <= 0) {
			throw new Exception("No se pueden retirar cantidades negativas");
		}
		Movimiento mov = new Movimiento();
		mov.setFecha(new Date());
		mov.setmConcepto(caca);
		mov.setmImporte(-x);
		mMovimientos.add(mov);

		this.mCredito -= x;
	}

	public void retirar(double x) throws Exception {

		if (x <= 0) {
			throw new Exception("No se pueden retirar cantidades negativas");
		}
		Movimiento mov = new Movimiento();
		mov.setFecha(new Date());
		mov.setmConcepto("Retirar credito");
		mov.setmImporte(-x);
		mMovimientos.add(mov);

		this.mCredito -= x;
	}

	public void setCuenta(Cuenta c) {
		this.mCuentaAsociada = c;
	}

	public double getCreditoDisponible() {
		return mCredito;
	}

	public void liquidar(int mes, int anno) {
		// Buscar movimientos de mes&anno
		double amount = 0;
		/*
		 * Date es una clase que se mantiene por retrocompatibilidad. Realmente
		 * se deber’a usar Calendar, pero la especificaci—n pone Date. En la
		 * actualidad para obtener un Date, hay que hacer un Calendar.
		 */
		Calendar cal = Calendar.getInstance();
		cal.set(anno, mes, 1);
		Date fecha = cal.getTime();

		for (Movimiento mov : mMovimientos) {
			if (mov.getFecha().before(fecha) && mov.getFecha().after(fecha)) {
				amount += mov.getmImporte();
			}
			// Test sin fecha
			amount += mov.getmImporte();
		}

		try {
			if (amount > 0) {
				this.mCuentaAsociada.ingresar("Liquidacion Tarjeta de Credito",
						amount);
			} else if (amount < 0) {
				this.mCuentaAsociada.retirar("Liquidacion Tarjeta de Credito",
						Math.abs(amount));
			} else {
				// Si es 0 no hace nada
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
