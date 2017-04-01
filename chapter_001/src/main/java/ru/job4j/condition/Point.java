package ru.job4j.condition;

/**
* Class Point is point on line.
*
* @author Kucyh Vasily (mailto:basil135@mail.ru)
* @version $Id$
* @since 31.03.2017
*/
public class Point {

	/**
	* X is the x axis.
	*/
	private final int x;
	/**
	* Y is the y axis.
	*/
	private final int y;

	/**
	* Constructor.
	*
	* @param x is the x axis
	* @param y is the y axis
	*/
	public Point(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	/**
	* The method returns x of x axis.
	*
	* @return integer x of x axis
	*/
	public int getX() {
		return this.x;
	}

	/**
	* The method returns y of y axis.
	*
	* @return integer y of y axis
	*/
	public int getY() {
		return this.y;
	}

	/**
	* The method returns true if point is on axis.
	*
	* @param a is the first number
	* @param b is the second number
	* @return true if point is on axis y(x) = a * x + b
	*/
	public boolean is(final int a, final int b) {
		return this.y == a * this.x + b;
	}

}
