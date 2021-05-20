import javax.swing.JOptionPane;

/**
 * Klasa UI pranon te dhenat nga perdoruesi
 * @author Shpati
 *
 */
public class UI {
	
	/**
	 * Metoda getSize pyet perdoruesin per madhesine e tabeles (Board)
	 * @return size - madhesia e board, min 4 dhe max 40
	 */
	public int getSize() {
		String input = JOptionPane.showInputDialog("Shtyp madhesine e boardit! [udhezim: 4 - 40]");
		int size = Integer.parseInt(input);

		// Kufizimi i madhesise se Board-it
		if (size < 4) {
			JOptionPane.showMessageDialog(null, "Board-i duhet te jete me i madh se \"3\"!");
		} else if (size > 40) {
			JOptionPane.showMessageDialog(null, "Board-i duhet te jete me i vogel se \"40\"!");
		}

		return size;
	}
	
	
	/**
	 * Metoda getNumOfGens pyet perdoruesin per numrin e gjeneratave qe deshiron t'i shohe
	 * @return numri i gjeneratave
	 */
	public int getNumOfGens() {
		String input = JOptionPane.showInputDialog
				("Ne sa gjenerata te shtrihet jeta? [udhezim: minimum 10] ");
		int gens = Integer.parseInt(input);

		return gens;
	}
	
	/**
	 * Metoda displayBoard paraqet qelizen specifike me simbol specifik. Pasi qe
	 * board-i eshte nje matrice (int[][]), atehere per paraqitjen e saj duhet te perdoren
	 * karaktere si --"." dhe "X",-- bazuar ne faktin se a eshte qeliza e gjalle 
	 * apo e vdekur
	 * @param isAlive  0 - qelize e vdekur, 1 - qelize e gjalle, -1 - rresht i ri
	 */
	public void displayBoard(int isAlive) {
		if (isAlive == 0) {
			System.out.print(".");
		} else if (isAlive == 1) {
			System.out.print("X");
		} else {
			System.out.println();
		}
	}
}
