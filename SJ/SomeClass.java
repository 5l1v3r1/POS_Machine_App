
/***
 * You cannot release or distribute 
 * this code without instructor's permission.
 * COMP217018: Java Programming
 * Instructor: Prof. Suh, Young-Kyoon
 * Lab #12-4: A Serializable class
 * @author yksuh
 */
import java.io.Serializable;
public class SomeClass implements Serializable {
	private int number;
	private char letter;
	public SomeClass() {
		number = 0;
		letter = 'A';
	}
	public SomeClass(int theNumber, char theLetter) {
		number = theNumber;
		letter = theLetter;
	}
	public String toString() {
		return "Number = " + number 
				+ " Letter = " + letter;
	}
}
