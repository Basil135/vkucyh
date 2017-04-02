package ru.job4j.loop;

/**
* This class paints a triangle.
*
* @author Kucyh Vasily (mailto:basil135@mail.ru)
* @version $Id$
* @since 02.04.2017
*/
public class Paint {

	/**
	* This methot paints a picture af a triangle.
	*
	* @param h is height of a triangle
	* @return String of symbols that a picture
	*/
	public String piramid(final int h) {

		StringBuilder result = new StringBuilder();
		int length = h * 2 - 1;
		int center = length / 2;

		for (int colomn = 0; colomn < h; colomn++) {

			for (int line = 0; line < length; line++) {

				if (line < center - colomn || line > center + colomn) {
					result.append(" ");
				} else {
					result.append("^");
				}

			}
			if (colomn < h - 1) {
				result.append(System.getProperty("line.separator"));
			}

		}

		return result.toString();

	}

}
