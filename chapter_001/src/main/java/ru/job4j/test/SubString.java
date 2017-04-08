package ru.job4j.test;

/**
* This class contains the method "contains" that find a substring in the string.
*
* @author Kucykh Vasily (mailto:basil135@mail.ru)
* @version $Id$
* @since 04.04.2017
*/
public class SubString {

	/**
	* This method returns true if the input string contains the input substring.
	*
	* @param origin is input string
	* @param sub is input substring
	* @return true if string origin contains string sub
	*/
	public boolean contains(String origin, String sub) {

		if (origin == null || sub == null) {
			return false;
		}

		char[] originString = origin.toCharArray();
		char[] subString = sub.toCharArray();

		int pointerOfOriginString;
		int pointerOfSubString = 0;

		boolean result = false;
		boolean flag;

		for (pointerOfOriginString = 0; pointerOfOriginString < originString.length; pointerOfOriginString++) {

			if (originString.length < subString.length) {

				result = false;
				break;

			} else if (originString.length == subString.length) {

				if (origin.equals(sub)) {
					result = true;
					break;
				}

			} else {

				if (originString[pointerOfOriginString] == subString[pointerOfSubString]) {

					pointerOfSubString++;

					if (pointerOfSubString == subString.length) {
						result = true;
						break;
					}

				} else {
					pointerOfSubString = 0;
				}
			}

		}

		return result;

	}

	/**
	* This method is alternative method throw the hashcode.
	*
	* @param origin is the input string
	* @param sub is the substring
	* @return true if sub is a substring of origin
	*/
	public boolean containsHash(String origin, String sub) {

		if (origin == null || sub == null) {
			return false;
		}

		int hashSub = sub.hashCode();
		int hashSubOrigin;

		int beginIndex = 0;
		int endIndex = sub.length();

		while (endIndex <= origin.length()) {

			hashSubOrigin = origin.substring(beginIndex, endIndex).hashCode();

			if (hashSubOrigin == hashSub || origin.substring(beginIndex, endIndex).equals(sub)) {
				return true;
			}

			beginIndex++;
			endIndex++;

		}

		return false;

	}

}
