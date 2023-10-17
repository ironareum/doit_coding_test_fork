package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import 연습코드.CalculatorTest;

class Test_Q1 {

	@org.junit.Test //(timeout = 5000) //expected = RuntimeException.class,
	public void testSum() {
//		fail("Not yet implemented");
		CalculatorTest calculatorTest = new CalculatorTest();
		
		assertEquals(6, calculatorTest.sum(1, 2));
		
		assertEquals(6, calculatorTest.sum(3, 3));
		
		//assert 메소드 정리 
		
	}
	
	@Test 
	public void testSum2() {
//		fail("Not yet implemented");
		CalculatorTest calculatorTest = new CalculatorTest();
		
		assertEquals(6, calculatorTest.sum(1, 2));
		
		assertEquals(6, calculatorTest.sum(3, 3));
		
		//assert 메소드 정리 
		
	}

}
