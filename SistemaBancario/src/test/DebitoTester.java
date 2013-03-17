package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.Cuenta;
import domain.Debito;

public class DebitoTester {
	
	static Debito debito;
	static Cuenta cuenta;

	@SuppressWarnings("deprecation")
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		debito = new Debito(new Date(10,12,2015), "5565.3321.3456.1123", "Se–or X");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void setCuenta() {
		try {
			cuenta = new Cuenta("0001.0002.43.1234567890","Caja B");
			debito.setCuenta(cuenta);
		}
		catch (Exception e)
		{
			fail("No se ha asociado la cuenta");
		}
	}
	
	@Test
	public void ingresar100() {
		try {
			debito.ingresar(100);
			assertTrue(debito.getSaldo()==100.0);
		} 
		catch (Exception e)
		{
			fail("no deberia fallar");
		}
	}
	
	@Test
	public void ingresar2500() {
		try {
			debito.ingresar(2500);
			assertTrue(debito.getSaldo()==2600.0);
		}
		catch (Exception e)
		{
			fail("no deberia fallar");
		}
	}
	
	@Test
	public void retirar600() {
		try {
			debito.retirar(600);
		}
		catch (Exception e)
		{
			fail("No deberia fallar al retirar");
		}
		assertTrue(debito.getSaldo()==2000.0);
	}
	
	@Test
	public void pago2000() {
		try {
			debito.pagoEnEstablecimiento("Pago Supermercado",2000);
		}
		catch (Exception e)
		{
			fail("No deberia fallar al pagar");
		}
		assertTrue(debito.getSaldo()==0.0);
	}

	@Test
	public void ingresarYRetirar() {
		try {
			debito.ingresar(500);
			debito.retirar(500);
		}
		catch (Exception e)
		{
			fail("No deberia fallar al retirar");
		}
		assertTrue(debito.getSaldo()==0.0);
	}
}
