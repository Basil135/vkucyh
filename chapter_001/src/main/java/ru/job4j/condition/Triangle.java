package ru.job4j.condition;

//import java.lang.Math;

/**
* Class Triangle to find an area of any triangle.
*
* @author Kucyh Vasily (mailto:basil135@mail.ru)
* @version $Id$
* @since 01.04.2017
*/
public class Triangle {

	/**
	* This point is axis point.
	*/
	private Point a;
	/**
	* This point is axis point.
	*/
	private Point b;
	/**
	* This point is axis point.
	*/
	private Point c;

	/**
	* Constructor of class Point.
	* @param a is axis point of the triangle
	* @param b is axis point of the triangle
	* @param c is axis point of the triangle
	*/
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**
	* This method shows us can we take a triangle with points we have.
	*
	* @param pointOne is axis point one
	* @param pointTwo is axis point two
	* @param pointThree is axis point three
	* @return true if we take a triangle
	*/
	private boolean condition(final Point pointOne, final Point pointTwo, final Point pointThree) {

		boolean result = true;

		if (pointOne.getX() == pointTwo.getX() && pointOne.getY() == pointTwo.getY()) {
			result = false;
		} else if (pointOne.getX() == pointThree.getX() && pointOne.getY() == pointThree.getY()) {
			result = false;
		} else if (pointTwo.getX() == pointThree.getX() && pointTwo.getY() == pointThree.getY()) {
			result = false;
		} else if (pointOne.getX() == pointTwo.getX() && pointOne.getX() == pointThree.getX()) {
			result = false;
		} else if (pointOne.getY() == pointTwo.getY() && pointOne.getY() == pointThree.getY()) {
			result = false;
		}

		return result;

	}

	/**
	* This method return value * value.
	*
	* @param value is a number
	* @return value * value
	*/
	private double pow(final double value) {
		return value * value;
	}

	/**
	* This method find an area of any triangle.
	*
	* @return result is area of triangle. If result is negative one that means triangle does not exist
	*/
	public double area() {

		double result = -1D;
		double p;
		double ab;
		double bc;
		double ac;

		if (condition(a, b, c)) {

			ab = Math.sqrt(pow(this.b.getX() - this.a.getX()) + pow(this.b.getY() - this.a.getY()));
			bc = Math.sqrt(pow(this.c.getX() - this.b.getX()) + pow(this.c.getY() - this.b.getY()));
			ac = Math.sqrt(pow(this.c.getX() - this.a.getX()) + pow(this.c.getY() - this.a.getY()));

			p = (ab + bc + ac) / 2;
			result = Math.sqrt(p * (p - ab) * (p - bc) * (p - ac));

		}

		return result;

	}

}
