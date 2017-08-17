package com;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.util.MathFunctions;

public class MathTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSigmoid() {
		
		double res = MathFunctions.sigmoid(0);
		
		Assert.assertEquals(0.5, res, 0);
		
	}
	
	@Test
	public void testSigmoidShouldLessThanEqual1() {
		
		double res = MathFunctions.sigmoid(10);
		
		Assert.assertTrue(res <= 1);
		
	}
	
	@Test
	public void testForDSigmoid() {
		
		double res = MathFunctions.dSigmoid(0.5);
		
		Assert.assertEquals(0.25, res, 0);
		
	}

}
