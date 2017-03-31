package ru.job4j.calculator;

/**
* Class simple calculator.
*
* @author Kucyh Vasily (mailto:basil135@mail.ru)
* @version $Id$
* @since 0.1
*/
public class Calculator {

	/** this is the result. */
	private double result = 0.0;

	/**
	* The method return result.
	*
	* @return result this is the result of the method
	*/
	public double getResult() {
		return this.result;
	}

	/**
	* The method adds two numbers.
	*
	* @param first this is the first number
	* @param second this is the second number
	*/
	public void add(final double first, final double second) {
		this.result = first + second;
	}

	/**
	* The method substructs two numbers.
	*
	* @param first this is the first number
	* @param second this is the second number
	*/
	public void substruct(final double first, final double second) {
		this.result = first - second;
	}

	/**
	* The method divides two numbers.
	*
	* @param first this is the first number
	* @param second this is the second number
	*/
	public void div(final double first, final double second) {
		this.result = first / second;
	}

	/**
	* The method multiplies two numbers.
	*
	* @param first this is the first number
	* @param second this is the second number
	*/
	public void multiply(final double first, final double second) {
		this.result = first * second;
	}

}
