package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.Cuenta;
import domain.Movimiento;

public class CuentaTester {

	static Cuenta cuenta;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cuenta = new Cuenta("0001.0002.43.1234567890", "Caja B");
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
			assertTrue(cuenta.getSaldo() == 100.0);
		} catch (Exception e) {
			fail("no deberia fallar");
		}
	}

	@Test
	public void ingresar2500() {
		try {
			cuenta.ingresar("Cobro parné", 2500);
			assertTrue(cuenta.getSaldo() == 2600.0);
		} catch (Exception e) {
			fail("no deberia fallar");
		}
	}

	@Test
	public void retirar600() {
		try {
			cuenta.retirar(600);
		} catch (Exception e) {
			fail("No deberia fallar al retirar");
		}
		assertTrue(cuenta.getSaldo() == 2000.0);
	}

	@Test
	public void retirarConcepto() {
		try {
			cuenta.retirar("Papa dame pelas", 2000);
		} catch (Exception e) {
			fail("No deberia fallar al retirar");
		} finally {

		}
		assertTrue(cuenta.getSaldo() == 0);

	}

	@Test
	public void ingresarYRetirar() {
		try {
			cuenta.ingresar(500);
			cuenta.retirar(500);
		} catch (Exception e) {
			fail("No deberia fallar al retirar");
		}
		assertTrue(cuenta.getSaldo() == 0.0);
	}
	
	
	/*
	 * Test de Exceptions
	 */
	
	@Test public void ingresar(){
		try {
			cuenta.ingresar(0);
		} catch (Exception e) {
			assertNotNull(e);
		}
		
		try {
			cuenta.ingresar("expcepcional",0);
		} catch (Exception e) {
			assertNotNull(e);
		}
	}
	
	@Test public void retirar(){
		try {
			cuenta.retirar(0);
		} catch (Exception e) {
			assertNotNull(e);
		}
		
		try {
			cuenta.retirar("expcepcional",0);
		} catch (Exception e) {
			assertNotNull(e);
		}
	}

	/*
	 * Tests de getters
	 */

	@Test
	public void testGetMovimientos() {
		assertNotNull(cuenta.getmMovimientos());
	}

	@Test
	public void testGetmNumero() {
		String s = cuenta.getmNumero();
		assertTrue(s.length() == 23);
	}

	@Test
	public void testGetmTitular() {
		assertNotNull(cuenta.getmTitular());
	}

	/*
	 * Test de setters
	 */

	@Test public void testSetmMovimientos(){
		ArrayList<Movimiento> movs = new ArrayList<Movimiento>();
		cuenta.setmMovimientos(movs);
		assertSame(movs, cuenta.getmMovimientos());
	}
	
	@Test public void testSetmTitular(){
		String nombre = "Jane Doe";
		cuenta.setmTitular(nombre);
		assertSame(nombre, cuenta.getmTitular());
	}
	@Test public void testSetmNumero(){
		String num = "12345678901234567890123";
		cuenta.setmNumero(num);
		assertSame(num, cuenta.getmNumero());
	}

}
