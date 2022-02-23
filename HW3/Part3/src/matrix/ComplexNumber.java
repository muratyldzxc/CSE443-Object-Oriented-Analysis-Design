package matrix;

/**
 * Holds real and imaginary part of the Complex Number
 * @author murat
 */
public class ComplexNumber {
	/**
	 * Real part of the Complex Number
	 */
	int realPart;
	/**
	 * Imaginary part of the Complex Number
	 */
	int imaginaryPart;
	
	/**
	 * Create a Complex Number with given parameters
	 * @param realPart will be set to real part of Complex Number
	 * @param imaginaryPart will be set to imaginary Part of Complex Number
	 */
	public ComplexNumber(int realPart, int imaginaryPart) {
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}
	
	/**
	 * Adds two complex number and returns it
	 * @param c2 to be added this complex number
	 * @return return result of addition two complex number
	 */
	public ComplexNumber addComplexNumber(ComplexNumber c2) {
		
		return new ComplexNumber(this.realPart+c2.realPart, this.imaginaryPart+c2.imaginaryPart);
	}
	
	/**
	 * Prints complex number
	 */
	@Override
	public String toString() {
		return realPart + "+" + imaginaryPart + "i";
	}
}
