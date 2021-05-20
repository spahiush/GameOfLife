/**
 * RunGameOfLife starton lojen ''Conway's Game Of Life''
 * @author Shpati
 *
 */
public class RunGameOfLife {
	public static void main(String[] args) {
		
		GameOfLife myGame = new GameOfLife();
		
		myGame.setSize();
		myGame.initializeBoard();
		myGame.numberOfGenerations();
		
	}
}
