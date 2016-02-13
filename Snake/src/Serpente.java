public class Serpente {
	private Cubo[] elencocubi;
	private final int NUM_MAX_CUBI = 50;

	public Serpente() {
		elencocubi = new Cubo[NUM_MAX_CUBI];
	}

	public boolean aggiungi(Cubo c) {
		for (int i = 0; i < NUM_MAX_CUBI; i++) {
			if (elencocubi[i] == null) {
				elencocubi[i] = new Cubo(c);
				return true;
			}
		}
		return false;
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

	public Cubo[] getCompresi(int x1, int x2, int y1, int y2) {
		int conta = 0;
		int k = 0;
		for (int j = 0; j < NUM_MAX_CUBI; j++) {
			if (elencocubi[j] != null && elencocubi[j].getX() >= x1 && elencocubi[j].getY() >= y1
					&& elencocubi[j].getX() <= x2 && elencocubi[j].getY() <= y2) {
				conta++;
			}
		}
		Cubo p[] = new Cubo[conta];
		for (int i = 0; i < NUM_MAX_CUBI; i++) {
			if (elencocubi[i] != null && elencocubi[i].getX() >= x1 && elencocubi[i].getY() >= y1
					&& elencocubi[i].getX() <= x2 && elencocubi[i].getY() <= y2) {
				p = new Cubo[conta];
				p[k] = elencocubi[i];
				k++;

			}
		}
		return p;
	}

}
