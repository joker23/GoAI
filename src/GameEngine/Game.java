import java.util.LinkedList;
import java.util.Arrays;
import java.awt.Point;

/**
 * Game
 * this class will store the game state
 * each cell in the board will have one of 3 characters :
 * 	'*' means the cell is empty
 * 	'B' means the cell is occupied by a black piece
 * 	'W' means the cell is occupied by a white piece
 *
 * @author Steven Zhang
 */
public class Game {

	protected int height;				// height
	protected int width;				// width
	protected char[][] board;			// representation of the board
	protected LinkedList<Move> moves;	// list of moves

	/** constructors **/

	/**
	 * @param height,width : the board size nxm
	 */
	public Game (int height, int width) {
		this.height = height;
		this.width = width;
		this.moves = new LinkedList<Move>();

		board = new char[height][width];
		for(int i=0; i<height; i++) {
			Arrays.fill(board[i], '*');
		}
	}

	/**
	 * default constructor makes a 9x9 board
	 */
	public Game () {
		this(9,9);
	}

	/**
	 * places a piece on the board
	 *
	 * @param color : the color of the piece must be 'W' or 'B'
	 * @param row,col : location of the piece to be placed 0 indexed
	 *
	 * @return boolean whether the piece is actually placed
	 */
	public boolean play(char color, int row, int col) {

		// sanity checks
		if(color != 'B' || color != 'W') {
			return false; //not a valid color
		}

		if(row < 0 || row >= height || col < 0 || col >= width) {
			return false; //not a valid coordinate
		}

		//TODO place the move validator here

		board[row][col] = color;

		moves.add(new Move(color, new Point(row, col)));

		return true;
	}

	/** getters and setters **/
	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public LinkedList<Move> getGamePlay() {
		return moves;
	}

	public char[][] getBoard() {
		return board;
	}

	public Move getLastMove() {
		if(moves.isEmpty()) {
			return null;
		}
		return moves.getLast();
	}
}