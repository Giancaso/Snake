import java.util.Arrays;

public class Serpente {
	private Cubo[] elencocubi;
	private final int NUM_MAX_CUBI = 50;

	public Serpente() {
		elencocubi = new Cubo[0];
	}

	public void aggiungi(Cubo c) {
		elencocubi = Arrays.copyOf(elencocubi, elencocubi.length + 1);
		elencocubi[elencocubi.length - 1] = c.clone();
	}

	public boolean elimina(int pos) {
		for (int i = 0; i < NUM_MAX_CUBI; i++) {
			if (elencocubi[i] != null && pos == i) {
				elencocubi[pos] = null;
				return true;
			}
		}
		return false;
	}

	public Cubo getCubo(int pos) {
		for (int i = 0; i < NUM_MAX_CUBI; i++) {
			if (elencocubi[i] != null && pos == i) {
				return elencocubi[pos];
			}
		}
		return null;
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < NUM_MAX_CUBI; i++) {
			if (elencocubi[i] != null) {
				s = s + elencocubi[i].toString() + ", ";
			}
		}
		return s;
	}

	public Cubo getCdaP(int p) {
		return new Cubo(elencocubi[p].getX(), elencocubi[p].getY(), elencocubi[p].getL());
	}

	public int getElementi() {
		return elencocubi.length;
	}

	public void muovi(String m) {
		switch (m) {

		case "dx":
			if (elencocubi[0].getX() < 490) {
				for (int i = 0; i < elencocubi.length; i++) {
					elencocubi[i].setX(elencocubi[i].getX() + elencocubi[i].getL());
				}
			}
			break;

		case "sx":
			if (elencocubi[0].getX() > 0) {
				for (int i = 0; i < elencocubi.length; i++) {
					elencocubi[i].setX(elencocubi[i].getX() - elencocubi[i].getL());
				}
			}
			break;

		case "su":
			if (elencocubi[0].getY() > 0) {
				for (int i = 0; i < elencocubi.length; i++) {
					elencocubi[i].setY(elencocubi[i].getY() - elencocubi[i].getL());
				}
			}
			break;

		case "giu":
			if(elencocubi[0].getY() < 390)
			for (int i = 0; i < elencocubi.length; i++) {
				elencocubi[i].setY(elencocubi[i].getY() + elencocubi[i].getL());
			}
			break;
		}
	}

}
