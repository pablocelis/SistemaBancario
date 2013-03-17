package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.Cuenta;

public class CuentaTester {

	static Cuenta cuenta;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cuenta = new Cuenta("0001.0002.43.1234567890","Caja B");
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
			cuenta.ingresar(100);
			assertTrue(cuenta.getSaldo()==100.0);
		} 
		catch (Exception e)
		{
			fail("no deberia fallar");
		}
	}
	
	@Test
	public void ingresar2500() {
		try {
			cuenta.ingresar("Cobro parné", 2500);
			assertTrue(cuenta.getSaldo()==2600.0);
		}
		catch (Exception e)
		{
			fail("no deberia fallar");
		}
	}
	
	@Test
	public void retirar600() {
		try {
			cuenta.retirar(600);
		}
		catch (Exception e)
		{
			fail("No deberia fallar al retirar");
		}
		assertTrue(cuenta.getSaldo()==2000.0);
	}
	
	@Test
	public void retirar2000() {
		try {
			cuenta.retirar(2000);
		}
		catch (Exception e)
		{
			fail("No deberia fallar al retirar");
		}
		assertTrue(cuenta.getSaldo()==0.0);
	}

	@Test
	public void ingresarYRetirar() {
		try {
			cuenta.ingresar(500);
			cuenta.retirar(500);
		}
		catch (Exception e)
		{
			fail("No deberia fallar al retirar");
		}
		assertTrue(cuenta.getSaldo()==0.0);
	}
}
