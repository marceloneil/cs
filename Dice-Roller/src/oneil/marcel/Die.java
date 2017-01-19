package oneil.marcel;

public class Die {
	private int numSides;
	private int value;

	public Die(int numFaces) {
		this.numSides = numFaces;
	}

	public void roll() {
		value = (int) (Math.random() * numSides) + 1;
	}

	public int getValue() {
		return value;
	}
}
