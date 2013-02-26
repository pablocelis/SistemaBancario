package domain;

public interface Tarjeta {

	
	public double getSaldo();
	
	public void ingresar(double x);
	
	public void pagoEnEstablecimiento(String caca, double x);
	
	public void retirar(double x);
	
	public void setCuenta(Cuenta c);
}
