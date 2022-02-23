package demo;

import java.util.ArrayList;
import java.util.Random;

import matrix.CalculateDFTQuarterWithSemaphore;
import matrix.CalculateDFTQuarterWithSyncronized;
import matrix.ComplexNumber;
import matrix.Matrix;
import synchronizationBarrier.MyBarrier;

public class Demo {

	public static void main(String[] args) {
		int rowSize = 10;
		int colSize = 10;
		
		System.out.println("\n----- DEMO WITH SYNCHRONIZED -----\n");
		Matrix A, B, sumMatrix;
		Thread threads [];
		MyBarrier barrier;
		
		A = new Matrix(null, 0, 0);
		B = new Matrix(null, 0, 0);
		sumMatrix = new Matrix(null, 0, 0);
		threads = new Thread[4];
		barrier = new MyBarrier(4);
		
		
		A = initRandomMatrix(rowSize, colSize);
		System.out.println("\nMatrix A created");
		
		B = initRandomMatrix(rowSize, colSize);
		System.out.println("\nMatrix B created\n");
		
		sumMatrix = initRandomMatrix(rowSize, colSize);
		
		for(int i=0; i<4; i++) {
			threads[i] = new Thread(new CalculateDFTQuarterWithSyncronized(A, B, sumMatrix, barrier, i+1));
		}
		
		for(int i=0; i<4; i++) {
			threads[i].start();
		}
		
		for(int i=0; i<4; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		
		System.out.println("All threads are done");
		
		/* Printing Matrices
		System.out.println("\n Matrix A\n");
		A.print();
		System.out.println("\n");
		
		System.out.println("\n Matrix B\n");
		B.print();
		System.out.println("\n");
		
		System.out.println("\n Sum Matrix of A+B\n");
		sumMatrix.print();
		*/
		
		System.out.println("\n----- DEMO WITH SEMAPHORES -----\n");
		
		A = new Matrix(null, 0, 0);
		B = new Matrix(null, 0, 0);
		sumMatrix = new Matrix(null, 0, 0);
		threads = new Thread[4];
		
		A = initRandomMatrix(rowSize, colSize);
		System.out.println("\nMatrix A created");
		B = initRandomMatrix(rowSize, colSize);
		System.out.println("\nMatrix B created\n");
		sumMatrix = initRandomMatrix(rowSize, colSize);
		
		for(int i=0; i<4; i++) {
			threads[i] = new Thread(new CalculateDFTQuarterWithSemaphore(A, B, sumMatrix, i+1));
		}
		
		for(int i=0; i<4; i++) {
			threads[i].start();
		}
		
		for(int i=0; i<4; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		
		System.out.println("All threads are done");
		
		/* Printing Matrices
		
		System.out.println("\n Matrix A\n");
		A.print();
		System.out.println("\n");
		
		System.out.println("\n Matrix B\n");
		B.print();
		System.out.println("\n");
		
		System.out.println("\n Sum Matrix of A+B\n");
		sumMatrix.print();
		
		*/
		
	}
	
	/**
	 * Creates Random Matrix with given parameters
	 * @param rowSize row size of the matrix will be created
	 * @param colSize column size of the matrix will be created
	 * @return Random Matrix with given parameters
	 */
	public static Matrix initRandomMatrix(int rowSize, int colSize) {
		Random random = new Random();
		ArrayList<ArrayList<ComplexNumber>> newMatrix = new ArrayList<ArrayList<ComplexNumber>>();
		
		ArrayList<ComplexNumber> newRow;
		
		for(int i = 0; i < rowSize; i++) {
			newRow = new ArrayList<ComplexNumber>();
            for (int j = 0; j < colSize; j++) {
            	newRow.add(new ComplexNumber(random.nextInt(10), random.nextInt(10)));
            }
            newMatrix.add(newRow);
        }
		
		return new Matrix(newMatrix, rowSize, colSize);
	}
	
}
