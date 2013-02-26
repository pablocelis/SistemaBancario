/**
 * 
 */
package domain;

import java.util.Date;

/**
 * @author Pablo
 *
 */
public class Movimiento {

	private String mConcepto;
	private Date Fecha;
	private double mImporte;
	
	public Movimiento() {}

	public String getmConcepto() {
		return mConcepto;
	}

	public void setmConcepto(String mConcepto) {
		this.mConcepto = mConcepto;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public double getmImporte() {
		return mImporte;
	}

	public void setmImporte(double mImporte) {
		this.mImporte = mImporte;
	}
	
	
}
