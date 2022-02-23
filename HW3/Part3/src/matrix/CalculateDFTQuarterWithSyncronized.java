package matrix;

import synchronizationBarrier.MyBarrier;

/**
 * Calculates DFT for given Quarter of Matrix
 * @author murat
 */
public class CalculateDFTQuarterWithSyncronized implements Runnable{
	
	/**
	 * Given matrix to be added and calculated
	 */
	Matrix A;
	/**
	 * Given matrix to be added and calculated
	 */
	Matrix B;
	/**
	 * To save result of added and calculated matrices
	 */
	Matrix sumMatrix;
	/**
	 * Which Quarter it represents
	 */
	int quarterNum;
	
	/**
	 * Begin row of given Quarter
	 */
	int beginRow;
	/**
	 * Begin row of given Quarter
	 */
	int endRow;
	/**
	 * Begin row of given Quarter
	 */
	int beginCol;
	/**
	 * Begin row of given Quarter
	 */
	int endCol;
	
	/**
	 * Barrier for synchronization
	 */
	MyBarrier barrier;
	
	/**
	 * Create calculation of DFT as given Quarter 
	 * @param A Given matrix to be added and calculated
	 * @param B Given matrix to be added and calculated
	 * @param sumMatrix To save result of added and calculated matrices
	 * @param barrier Barrier for synchronization
	 * @param quarterNum Which Quarter it represents
	 */
	public CalculateDFTQuarterWithSyncronized(Matrix A, Matrix B, Matrix sumMatrix, MyBarrier barrier, int quarterNum) {
		this.A = A;
		this.B = B;
		this.sumMatrix = sumMatrix;
		this.quarterNum = quarterNum;
		this.barrier = barrier;
		calculateBorders();
	}

	/**
	 * First, calculates A+B of given Quarter then wait other threads to complete A+B. After that calculates DFT for given Quarter
	 */
	@Override
	public void run() {
		
		addQuarterOfMatrices();

		System.out.println("Quarter num: " + quarterNum + " add operation finished. Waiting others");

		try {
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		CalculatingDFTQuarter();
		
		try {
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Calculates DFT for given Quarter
	 */
	private void CalculatingDFTQuarter() {
		System.out.println("Quarter num: " + quarterNum + " CalculateDFT operation finished. Waiting others");
	}
	
	/**
	 * Calculates A+B for given Quarter
	 */
	private void addQuarterOfMatrices() {
		
		for(int i = beginRow; i < endRow; i++) {
            for (int j = beginCol; j < endCol; j++) {
            	ComplexNumber element = A.getElement(i, j);
            	sumMatrix.setElement(i, j, element.addComplexNumber(B.getElement(i, j)));
            }
        }
	}

	
	/**
	 * Calculates borders for given Quarter
	 */
 	private void calculateBorders() {
		switch(quarterNum) {
			case 1:
				beginRow = 0;
				endRow = A.rows/2;
				beginCol = 0;
				endCol = A.cols/2;
				break;
			case 2:
				beginRow = A.rows/2;
				endRow = A.rows;
				beginCol = 0;
				endCol = A.cols/2;
				break;
			case 3:
				beginRow = 0;
				endRow = A.rows/2;
				beginCol = A.cols/2;
				endCol = A.cols;
				break;
			case 4:
				beginRow = A.rows/2;
				endRow = A.rows;
				beginCol = A.cols/2;
				endCol = A.cols;
				break;
				
		}
	}
	
}
