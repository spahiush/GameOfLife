/**
 * Klasa GameOfLife kontrollon GUI, Board dhe mundeson komunikimin dhe
 * shkembimin e te dhenave ne mes tyre
 * @author Shpati
 *
 */

public class GameOfLife {
	private static int rows; // number of Rows in the Board
	private static int cols; // number of Cols in the Board (2 x rows)
	private static UI face;
	private static Board board;
	private static Board nextBoard;
	private final static int TIME_DELAY = 500; // gjysem sekondi 
	
	/**
	 * Konstruktor per krijimin e instancave te reja te te
	 * gjitha klasave te programit, dhe i shoqeron ato me ndryshoret-field.
	 */
	public GameOfLife() {
		face = new UI();
		board = new Board(rows, cols);
		nextBoard = new Board(rows, cols);
	}
	
	
	/**
	 * Metoda setSize percakton madhesine e board-it, 
	 * percakton madhesite legale per boardin
	 * inicializon numrin e rreshtave dhe shtyllave te boardit
	 */
	public void setSize() {
		int size = face.getSize();
		
		// Perderisa vlera size, nuk eshte legale, therret metoden gestSize()
		while (size < 4 || size > 40) {
			size = face.getSize();
		}
		// intiacializimi i numrit te rreshtave x shtyllave
		rows = size;
		// cols = rows x 2
		cols = 2 * size;

		// Ritheret konstruktorin per marrje te vlerave te duhura
		new GameOfLife();
	}
	
	
	/**
     * Metoda initializeBoard() gjeneron gjeneraten e pare te qelizave
     * te gjalla me probabilitet 1/3, dhe ia cakton (board.set()) atyre 
     * pozitat respektive.
     */
	public void initializeBoard() {
		for (int r = 0; r < board.getRows(); r++) {
			for (int c = 0; c < board.getCols(); c++) {
				// random number of 0, 1 or 2
				int randVal = (int) (Math.random() * 3);
				// 1/3 jane gjasat per t'u ngjallur qeliza ne shqyrtim
				if (randVal == 0) {
					board.setValue(r, c, 1);
				}
			}
		}
	}
    
	
	/**
	 * Metoda getLife udhezon GUI-n per qelizat e gjalla dhe therret
	 * metoden displayBoard() te instances se GUI-t.
	 */
	public void getLife() {

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (board.isAlive(r, c) == 0) {
					face.displayBoard(0);
				} else {
					face.displayBoard(1);
				}
			}
			face.displayBoard(-1);
		}
	}
	
	
	/**
	 * Metoda nextToCurrent() transferon board-in e ri te krijuar tek
	 * board-i aktual (tabela standarde e percaktuar per tu shfaqe ne Command Line)
	 * @param board - tabela aktuale (standarde)
	 * @param nextBoard - tabela e re (vlera te reja te qelizave)
	 */
	public static void nextToCurrent(Board board, Board nextBoard) {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				board.setValue(r, c, nextBoard.getValue(r, c));
			}
		}
	}
	
	
	/**
	 * Metoda delay() vonon ekzekutimin perserites te programit per 
	 * TIME_DELAY milisekonda
	 */
	public static void delay() {
		try {
			Thread.sleep(TIME_DELAY);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
	
	/**
	 * Metoda numberOfGenerations percakton numrin e gjeneratave evoluese
	 * dhe pastron Command Line Inteface me unazen for.
	 */
	public void numberOfGenerations() {

		int genTimes = face.getNumOfGens();
		for (int i = 0; i < genTimes; i++) {
			getLife();
			delay();
			
			for (int z = 0; z < 50; ++z) // unaza '' pastron '' CLI 
			{
				System.out.println();
			}
			board.getNextGen(board, nextBoard);
			nextToCurrent(board, nextBoard);
		}
	}
	
	
}
