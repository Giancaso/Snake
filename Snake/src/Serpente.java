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

	public Cubo getCdaP(int p) {
		return new Cubo(elencocubi[p].getX(), elencocubi[p].getY(), elencocubi[p].getL());
	}
	
	public int getElementi(){
		return elencocubi.length;
	}

	public void muovi(String m) {
		switch (m) {
		case "dx":
			for(int i=0; i<elencocubi.length; i++){
				elencocubi[i].setX(elencocubi[i].getX()+elencocubi[i].getL());
			}
			break;
			
		case "sx":
			for(int i=0; i<elencocubi.length; i++){
				elencocubi[i].setX(elencocubi[i].getX()-elencocubi[i].getL());
			}
			break;
		}
	}

}
