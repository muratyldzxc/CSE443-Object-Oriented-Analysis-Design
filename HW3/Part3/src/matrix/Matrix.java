package matrix;

import java.util.ArrayList;

/**
 * Holds a ComplexNumber Matrix
 * @author murat
 */
public class Matrix {
	/**
	 * Holds matrix as two dimensional arraylist
	 */
	ArrayList<ArrayList<ComplexNumber>> matrix;
	/**
	 * Row size of Matrix
	 */
	int rows;
	/**
	 * Column size of Matrix
	 */
	int cols;
	
	/**
	 * Create a Matrix with given parameters
	 * @param matrix will be set to two dimensional arraylist
	 * @param rows will be set to Row size of
	 * @param cols will be set to Column size
	 */
	public Matrix(ArrayList<ArrayList<ComplexNumber>> matrix, int rows, int cols) {
		
		this.rows = rows;
		this.cols = cols;
		this.matrix = matrix;
	}
	
	/**
	 * Returns indexed element from matrix, if index out of bound then returns null
	 * @param rowi row index of matrix
	 * @param coli column index of matrix
	 * @return indexed element from matrix
	 */
	public ComplexNumber getElement(int rowi, int coli) {
		if(rowi >= matrix.size() && coli >= matrix.get(0).size())
			return null;
		
		ArrayList<ComplexNumber> currRow = matrix.get(rowi);
		return currRow.get(coli);
	}
	
	/**
	 * Returns indexed element from matrix, if index out of bound then returns null
	 * @param rowi row index of matrix
	 * @param coli column index of matrix
	 * @param c element that will be set
	 * @return indexed element from matrix
	 */
	public ComplexNumber setElement(int rowi, int coli, ComplexNumber c) {
		
		if(rowi >= matrix.size() && coli >= matrix.get(0).size())
			return null;
		
		ArrayList<ComplexNumber> currRow = matrix.get(rowi);
		return currRow.set(coli, c);
	}
	
	/**
	 * Prints Matrix
	 */
	public void print() {
		System.out.println("[");
		for(int i = 0; i < rows; i++) {
			System.out.println("");
            for (int j = 0; j < cols; j++) {
            	System.out.print(" " + this.getElement(i, j));
            }
        }
		System.out.println("\n]");
	}
}
