package com;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.util.MathFunction;

public class MathTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSigmoid() {
		
		double res = MathFunction.sigmoid.apply(0.0);
		
		Assert.assertEquals(0.5, res, 0);
		
	}
	
	@Test
	public void testSigmoidShouldLessThanEqual1() {
		
		double res = MathFunction.sigmoid.apply(10.0);
		
		Assert.assertTrue(res <= 1);
		
	}
	
	@Test
	public void testForDSigmoid() {
		
		double res = MathFunction.dSigmoid.apply(0.5);
		
		Assert.assertEquals(0.25, res, 0);
		
	}

}
