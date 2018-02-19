import java.util.Comparator;

public class ComparadorDistancias implements Comparator<Distancias>{

	@Override
	public int compare(Distancias a1, Distancias a2) {
		if(a1.getDistancia()>a2.getDistancia())
			return +1;
		else if(a2.getDistancia()>a1.getDistancia()) 
			return -1;
		else return 0;
	}
	
}
