package test;

import static org.junit.Assert.*;

import java.util.Calendar;
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

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.set(2015, 12, 10);
		Date fecha = cal.getTime();
		debito = new Debito(fecha, "5565.3321.3456.1123", "Se–or X");
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
	public void ingresarNeg() {
		try {
			debito.ingresar(-100);		
		} 
		catch (Exception e)
		{
			assertTrue(debito.getSaldo()==100.0);
		}
	}
	
	@Test
	public void retirar101() {
		try {
			debito.retirar(101);
		} 
		catch (Exception e)
		{
			assertTrue(debito.getSaldo() == 100.0);
			assertNotNull(e);
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
			assertTrue(debito.getSaldo()==2000.0);
		}
		catch (Exception e)
		{
			fail("No deberia fallar al retirar");
		}
	
	}
	
	@Test
	public void pago1000() {
		try {
			debito.pagoEnEstablecimiento("Pago Supermercado",1000.0);
			assertTrue(debito.getSaldo()==1000.0);
		}
		catch (Exception e)
		{
			fail("No deberia fallar al pagar");
		}
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
	
	/*
	 * Tests de getters
	 */

	@Test
	public void testGetmCuentaAsociada() {
		assertNotNull(debito.getmCuentaAsociada());
	}

	@Test
	public void testGetmNumero() {
		assertNotNull(debito.getmNumero());
	}

	@Test
	public void testGetmTitular() {
		assertNotNull(debito.getmTitular());
	}
	
	@Test
	public void testGetmFechaCaducidad() {
		assertNotNull(debito.getmFechaDeCaducidad());
	}

	/*
	 * Test de setters
	 */

	@Test 
	public void testSetmCuentaAsociada(){
		Cuenta c = new Cuenta("5565.3321.3456.1123", "Se–or X");
		debito.setCuenta(c);
		assertSame(c, debito.getmCuentaAsociada());
	}
	
	@Test 
	public void testSetmTitular(){
		String nombre = "Jane Doe";
		debito.setmTitular(nombre);
		assertSame(nombre, debito.getmTitular());
	}
	@Test public void testSetmNumero(){
		String num = "12345678901234567890123";
		debito.setmNumero(num);
		assertSame(num, debito.getmNumero());
	}

	@Test
	public void testSetmFechaCaducidad() {
		Calendar cal = Calendar.getInstance();
		cal.set(2015, 12, 10);
		Date fecha = cal.getTime();
		debito.setmFechaDeCaducidad(fecha);
		assertSame(fecha, debito.getmFechaDeCaducidad());
	}
}
