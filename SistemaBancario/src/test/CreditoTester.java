package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.Credito;
import domain.Cuenta;
import domain.Movimiento;

public class CreditoTester {

	static Cuenta cuenta;
	static Credito credito;
	static String nombre = "Se–or X";
	static String numero = "5565.3321.3456.1123";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.set(2015, 12, 10);
		Date fecha = cal.getTime();
		credito = new Credito(fecha, numero,
				nombre);
		cuenta = new Cuenta(numero, nombre);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		setCuenta();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void setCuenta() {
		try {
			credito.setCuenta(cuenta);
		} catch (Exception e) {
			fail("No se ha asociado la cuenta");
		}
	}


	
	@Test
	public void ingresar100() {
		try {
			credito.ingresar(100);
			assertTrue(credito.getCreditoDisponible() == 100.0);
		} catch (Exception e) {
			fail("no deberia fallar");
		}
		assertTrue(credito.getSaldo() == 0.0);
	}

	
	@Test
	public void retirar100() {
		try {
			credito.retirar(100);
			assertTrue(credito.getCreditoDisponible() == 0.0);
			assertTrue(credito.getSaldo() == 0.0);
		} catch (Exception e) {
			fail("no deberia fallar");
		}		
	}

	@Test
	public void pago300() {
		try {
			credito.pagoEnEstablecimiento("compra", 300);
			assertTrue(credito.getCreditoDisponible() == -300.0);
		} catch (Exception e) {
			fail("no deberia fallar");
		}
		assertTrue(credito.getSaldo() == 0.0);
	}

	@Test
	public void ingresarNeg() {
		try {
			credito.ingresar(-100);
		} catch (Exception e) {
			assertTrue(credito.getSaldo() == 0.0);
			assertTrue(credito.getCreditoDisponible() == -300.0);
		}
	}
	

	@Test
	public void ingresarEnCuenta() {
		try {
			cuenta.ingresar(1200);
		} catch (Exception e) {
			assertTrue(credito.getSaldo() == 1200.0);
			assertTrue(credito.getCreditoDisponible() == -300.0);
		}
	}

	/*
	 * Liquida todos los pagos realizados en el test
	 */
	@Test
	public void liquidar() {
		try {
			credito.liquidar(4, 2013);
			assertTrue(credito.getSaldo() == 900.0);
			assertTrue(credito.getCreditoDisponible() == -300.0);			
		} catch (Exception e) {
			fail("No deberia fallar"+e);
		}
	}
	
	@Test
	public void ingresar1000() {
		try {
			credito.ingresar(1000);
			assertTrue(credito.getCreditoDisponible() == 700.0);
		} catch (Exception e) {
			fail("no deberia fallar");
		}
		assertTrue(credito.getSaldo() == 900.0);
	}
	
	@Test
	public void liquidarSaldoPos() {
		try {
			credito.liquidar(4, 2013);
			assertTrue(credito.getSaldo() == 1600.0);
			assertTrue(credito.getCreditoDisponible() == 700.0);			
		} catch (Exception e) {
			fail("No deberia fallar"+e);
		}
	}
	
	@Test
	public void liquidarFuturo() {
		try {
			credito.liquidar(4, 2014);
		
		} catch (Exception e) {
			assertTrue(credito.getSaldo() == 900.0);
			assertTrue(credito.getCreditoDisponible() == -300.0);	
			assertNotNull(e);
		}
	}
	
	@Test
	public void liquidarAnterior() {
		try {
			credito.liquidar(1, 2013);
		
		} catch (Exception e) {
			assertTrue(credito.getSaldo() == 900.0);
			assertTrue(credito.getCreditoDisponible() == -300.0);	
			assertNotNull(e);
		}
	}
	
	@Test
	public void liquidarMesError() {
		try {
			credito.liquidar(14, 2011);
		
		} catch (Exception e) {
			assertTrue(credito.getSaldo() == 900.0);
			assertTrue(credito.getCreditoDisponible() == -300.0);	
			assertNotNull(e);
		}
	}
	
	@Test
	public void liquidarAnnoError() {
		try {
			credito.liquidar(4, 11);
		
		} catch (Exception e) {
			assertTrue(credito.getSaldo() == 900.0);
			assertTrue(credito.getCreditoDisponible() == -300.0);	
			assertNotNull(e);
		}
	}

	/*
	 * Test de getters
	 */

	@Test
	public void testGetMovimientos() {
		assertNotNull(credito.getmMovimientos());
	}

	/*
	 * Test de setters
	 */
	@Test
	public void testSetmMovimientos() {
		ArrayList<Movimiento> movs = new ArrayList<Movimiento>();
		credito.setmMovimientos(movs);
		assertSame(movs, credito.getmMovimientos());
	}

	/*
	 * Test de exceptions
	 */

	@Test
	public void testPagoEnEst() {
		try {
			credito.pagoEnEstablecimiento("Un jamon", -20000000);
		} catch (Exception e) {
			assertNotNull(e);
		}
	}

	@Test
	public void testRetirar() {
		try {
			credito.retirar(-23);
		} catch (Exception e) {
			assertNotNull(e);
		}
	}
}
