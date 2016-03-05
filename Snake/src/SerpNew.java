import java.util.ArrayList;

public class SerpNew {
	
	private final int NUM_MAX_CUBI = 50;
	private ArrayList<Cubo> elenco;
	
	public SerpNew(){
		elenco = new ArrayList<Cubo> (NUM_MAX_CUBI);
	}
	
	public void muovi(String m) {
		switch (m) {
		case "dx":
			for(int i=0; i<elenco.size(); i++){
				elenco.get(i).setX(elenco.get(i).getX()+elenco.get(i).getL());
			}
			break;
			
		case "sx":
			for(int i=0; i<elenco.size(); i++){
				elenco.get(i).setX(elenco.get(i).getX()-elenco.get(i).getL());
			}
			break;
			
		case "su":
			for(int i=0; i<elenco.size(); i++){
				elenco.get(i).setY(elenco.get(i).getY()-elenco.get(i).getL());
			}
			break;
			
			
		}
	}
}
