package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.Credito;
import domain.Cuenta;

public class CreditoTester {

	static Cuenta cuenta;
	static Credito credito;
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		credito = new Credito(new Date(10,12,2015), "5565.3321.3456.1123", "Se–or X");
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
			credito.setCuenta(cuenta);
		}
		catch (Exception e)
		{
			fail("No se ha asociado la cuenta");
		}
	}
	
	@Test
	public void ingresar100() {
		try {
			credito.ingresar(100);
			assertTrue(credito.getCreditoDisponible()==100.0);			
		} 
		catch (Exception e)
		{
			fail("no deberia fallar");
		}
		assertTrue(credito.getSaldo()==0.0);
	}
	
	@Test
	public void retirar100() {
		try {
			credito.retirar(100);
			assertTrue(credito.getCreditoDisponible()==0.0);			
		} 
		catch (Exception e)
		{
			fail("no deberia fallar");
		}
		assertTrue(credito.getSaldo()==0.0);
	}

	@Test
	public void pago300() {
		try {
			credito.pagoEnEstablecimiento("compra",300);
			assertTrue(credito.getCreditoDisponible()==-300.0);			
		} 
		catch (Exception e)
		{
			fail("no deberia fallar");
		}
		assertTrue(credito.getSaldo()==0.0);
	}
	
	@Test
	public void ingresarNeg() {
		try {
			credito.ingresar(-100);
		} 
		catch (Exception e)
		{
			assertTrue(credito.getSaldo()==0.0);
			assertTrue(credito.getCreditoDisponible()==-300.0);
		}
	}
	
	@Test
	public void ingresarEnCuenta() {
		try {
			cuenta.ingresar(1200);
		} 
		catch (Exception e)
		{
			assertTrue(credito.getSaldo()==1200.0);
			assertTrue(credito.getCreditoDisponible()==-300.0);
		}
	}
	
	/*
	 * Liquida todos los pagos realizados en el test
	 */
	@Test
	public void liquidar() {
		try {
			credito.liquidar(2, 2013);
		}
		catch (Exception e)
		{
			fail("No deberia fallar");
		}
		assertTrue(credito.getSaldo()==900.0);
		assertTrue(credito.getCreditoDisponible()==-300.0);
	}
	
	
}
