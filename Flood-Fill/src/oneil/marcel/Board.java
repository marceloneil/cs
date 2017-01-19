package oneil.marcel;


import java.util.Random;

public class Board {
	private Cell[][] board;
	private int rows;
	private int cols;

	public Board(int aRows, int aCols) {
		rows = aRows;
		cols = aCols;
		
		board = new Cell[aRows][aCols];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				board[i][j] = new Cell(randomColor());
			}
		}
	}
	
	final static Random RAND = new Random();
	final static int SIZE = ColorState.values().length;
	final static ColorState[] STATES = ColorState.values();
	
	private static ColorState randomColor() {
		return STATES[RAND.nextInt(SIZE)];
	}
	
	public ColorState getColor(int x, int y) {
		return board[x][y].getColor();
	}
	
	public boolean isValid(int x, int y){
		return (x < cols) && (y < rows) && (x >= 0) && (y >= 0);
	}
	
	public void unVisit(){
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				board[i][j].setVisited(false);
			}
		}
	}
	
	public void fill(int x, int y, ColorState newColor, ColorState replaceColor) throws InterruptedException{
	
		// Refer to https://en.wikipedia.org/wiki/Flood_fill#Stack-based_recursive_implementation_.28four-way.29
		
		if (!isValid(x,y)) { return; }
		if (newColor==replaceColor) { return; }
		
		
		if (board[x][y].getColor()!=newColor) { return; }
		if (board[x][y].hasVisited()) { return; }
		
		board[x][y].setColor(replaceColor);
		board[x][y].setVisited(true);

		fill(x+1, y, newColor, replaceColor);
		fill(x-1, y, newColor, replaceColor);
		fill(x, y+1, newColor, replaceColor);
		fill(x, y-1, newColor, replaceColor);
			
	}
		
	public boolean check(ColorState cs){
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j].getColor()!=cs)  {return false; }
			}
		}
		return true;
	}
	
	public void display() {
		System.out.println("BOARD");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.printf("%s ", board[i][j]);
			}
			System.out.println();
		}
	}
}
