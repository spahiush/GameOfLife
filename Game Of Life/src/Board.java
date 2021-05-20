/**
 * Klasa Board modelon tabelen (''board-in'')
 * @author Shpati
 *
 */
public class Board {
	int[][] board;

	/**
	 * Konstuktor per objektet e klases Board. 
	 * Nje Board i ri i zbrazet inicializohet me 0
	 * @param rows numri i rreshtave te matrices (2-d array)
	 * @param cols numri i kolonave te matrices (2-d array)
	 */
	public Board(int rows, int cols) {
		board = new int[rows][cols];
	}


	/**
	 * Metoda getValue rikthen vleren qe ruhet ne lokacionin specifik (row,col).
	 * 
	 * @param row rreshti ne matrice
	 * @param col kolona ne matrice
	 * @return vlera int e ruajtur ne (row,col)
	 */
	public int getValue(int row, int col) {
		return board[row][col];
	}
   

	/**
	 * Metoda setValue cakton vleren specifike ne lokacionin (row,col) specifik
	 * 
	 * @param row rreshti ne matrice
	 * @param col kolona ne matrice
	 * @param value vlera e qelizes (0 ose 1)
	 */
	public void setValue(int row, int col, int value) {
		board[row][col] = value;
	}
	

	/**
	 * Metoda getRows rikthen numrin e rreshtave te matrices
	 * 
	 * @return rreshtat e matrices
	 */
	public int getRows() {
		return board.length;
	}


	/**
	 * Metoda getCols rikthen numrin e kolonave te matrices
	 * 
	 * @return kolonat e matrices
	 */
	public int getCols() {
		return board[0].length;
	}
	

	/**
	 * Metoda toString rikthen nje String qe mund te printohet per paraqitje te
	 * matrices
	 * 
	 * @return nje String qe paraqet matricen
	 */
	public String toString() {
		String result = "";
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				result += board[r][c];
			}
			result += "\n";
		}
		return result;
	}
	

	/**
	 * Metoda isAlive teston nese qeliza ne poziten (r,c) eshte e gjalle apo e vdekur
	 * @param r - pozita e rreshtit
	 * @param c - pozita e kolones
	 * @return - nje vlere int qe tregon se qeliza eshte e gjalle apo jo
	 */
	public int isAlive(int r, int c) {
		int isAlive;
		if (getValue(r, c) == 0) {
			isAlive = 0;
		} else {
			isAlive = 1;
		}

		return isAlive;
	}
	
	
	/**
	 * Metoda getNextGen e mer tabelen aktuale dhe nje tabele te
	 * re te zbrazet dhe kalkulon gjeneraten e re per tabelen
	 * e re bazuar ne rregullat standarde te ''Conway's Game Of Life''
	 * 1. qeliza e gjalle vdes nese ka me pak se dy fqinje (vetmia)
	 * 2. qeliza e gjalle jeton nese ka 2 - 3 fqinje (mesi i arte)
	 * 3. qeliza e gjalle vdes nese ka me shume se 3 fqinje (ngulfatja)
	 * 4. qeliza e vdekur n'gjallet nese ka fiks 3 fqinje (reproduksioni)
	 * @param board - tabela aktuale
	 * @param nextBoard - tabela e re me gjeneraten e re ne te
	 */
	public void getNextGen(Board board, Board nextBoard) {
		int dead = 0;
		int alive = 1;
		for (int r = 0; r < getRows(); r++) {
			for (int c = 0; c < getCols(); c++) {
				int neighbors = countNeighbors(r, c, board);

				if (getValue(r, c) == alive && neighbors < 2) 		// 1.
				{
					nextBoard.setValue(r, c, dead);
				} else if (getValue(r, c) == alive && neighbors < 4) // 2.
				{
					nextBoard.setValue(r, c, alive);
				} else if (getValue(r, c) == alive && neighbors > 3) // 3.
				{
					nextBoard.setValue(r, c, dead);
				} else if (getValue(r, c) == dead && neighbors == 3) // 4.
				{
					nextBoard.setValue(r, c, alive);
				} else 
				{
					nextBoard.setValue(r, c, dead);
				}

			}
		}
	}
	
	
	/**
	 * Metoda countNeighbors numeron 8 qelizat perreth qelizes aktuale
	 * duke mos numeruar veteveten dhe qelizat jashta madhesise se matrices
	 * @param row - rreshti i qelizes aktuale
	 * @param col - kolona e qelizes aktuale
	 * @param board - tabela origjinale nen shqyrtim
	 * @return - numri i fqinjeve te gjalle (0 - 8)
	 */
	public int countNeighbors(int row, int col, Board board) {
		int count = 0;
		for (int r = row - 1; r <= row + 1; r++) {
			for (int c = col - 1; c <= col + 1; c++) {
				if (r >= 0 && r < getRows() && 			
					c >= 0 && c < getCols() && 
					!(r == row && c == col) && 
					getValue(r, c) == 1) 
				{
					count++;
				}
			}
		}

		return count;
	}

}
