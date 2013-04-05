package test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.Movimiento;

public class MovimientoTester {

	static Movimiento movimiento;
	static Date time;
	static String concepto;
	static double importe;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		movimiento = new Movimiento();
		time = Calendar.getInstance().getTime();
		concepto = "Conceptuando";
		importe = 100;
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		movimiento.setFecha(time);
		movimiento.setmConcepto(concepto);
		movimiento.setmImporte(importe);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetmConcepto() {
		assertSame(concepto, movimiento.getmConcepto());
	}

	@Test
	public void testSetmConcepto() {
		String test = "sup";
		movimiento.setmConcepto(test);
		assertSame(test, movimiento.getmConcepto());
	}

	@Test
	public void testGetFecha() {
		assertSame(time,movimiento.getFecha());
	}

	@Test
	public void testSetFecha() {
		Date test = Calendar.getInstance().getTime();
		movimiento.setFecha(test);
		assertSame(test, movimiento.getFecha());
	}

	@Test
	public void testGetmImporte() {
		assertTrue(importe == movimiento.getmImporte());
	}

	@Test
	public void testSetmImporte() {
		double test = 200;
		movimiento.setmImporte(test);
		assertTrue(test == movimiento.getmImporte());
	}

}
