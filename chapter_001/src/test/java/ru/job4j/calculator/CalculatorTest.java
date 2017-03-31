package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test class of class Calculator.
*
* @author Kucyh Vasily (mailto:basil135@mail.ru)
* @since 31.03.2017
* @version 0.1
*/
public class CalculatorTest {

	/**
	* Test add method.
	*/
	@Test
	public void whenAddOnePlusOneThenTwo() {

		Calculator calc = new Calculator();

		double expectedValue;
		double actualValue;

		calc.add(1D, 1D);

		expectedValue = 2D;
		actualValue = calc.getResult();

		assertThat(expectedValue, is(actualValue));

	}

	/**
	* Test add method.
	*/
	@Test
	public void whenAddThreeAndAHalfPlusFourAndAHalfThenEight() {

		Calculator calc = new Calculator();

		double expectedValue;
		double actualValue;

		calc.add(3.5D, 4.5D);

		expectedValue = 8D;
		actualValue = calc.getResult();

		assertThat(expectedValue, is(actualValue));

	}

	/**
	* Test substruct method.
	*/
	@Test
	public void whenSubstructFiveAndAFourthMinusThreeAndAHalfThenOneAndThreeFourth() {

		Calculator calc = new Calculator();

		double expectedValue;
		double actualValue;

		calc.substruct(5.25D, 3.5D);

		expectedValue = 1.75D;
		actualValue = calc.getResult();

		assertThat(expectedValue, is(actualValue));

	}

	/**
	* Test substruct method.
	*/
	@Test
	public void whenSubstructThreeMinusFiveAndAHalfThenNegativeTwoAndAHalf() {

		Calculator calc = new Calculator();

		double expectedValue;
		double actualValue;

		calc.substruct(3D, 5.5D);

		expectedValue = -2.5D;
		actualValue = calc.getResult();

		assertThat(expectedValue, is(actualValue));

	}

	/**
	* Test div method.
	*/
	@Test
	public void whenDivEightDivideFourThenTwo() {

		Calculator calc = new Calculator();

		double expectedValue;
		double actualValue;

		calc.div(8D, 4D);

		expectedValue = 2D;
		actualValue = calc.getResult();

		assertThat(expectedValue, is(actualValue));

	}

	/**
	* Test div method.
	*/
	@Test
	public void whenDivTwoAndAHalfDivideTwoAndAHalfThenOne() {

		Calculator calc = new Calculator();

		double expectedValue;
		double actualValue;

		calc.div(2.5D, 2.5D);

		expectedValue = 1D;
		actualValue = calc.getResult();

		assertThat(expectedValue, is(actualValue));

	}

	/**
	* Test multiply method.
	*/
	@Test
	public void whenMultiplyOneMultiplyOneThenOne() {

		Calculator calc = new Calculator();

		double expectedValue;
		double actualValue;

		calc.multiply(1D, 1D);

		expectedValue = 1D;
		actualValue = calc.getResult();

		assertThat(expectedValue, is(actualValue));

	}

	/**
	* Test multiply method.
	*/
	@Test
	public void whenMultiplyTwoMultiplyFourThenEight() {

		Calculator calc = new Calculator();

		double expectedValue;
		double actualValue;

		calc.multiply(2D, 4D);

		expectedValue = 8D;
		actualValue = calc.getResult();

		assertThat(expectedValue, is(actualValue));

	}

}
