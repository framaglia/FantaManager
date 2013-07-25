package extractor;
import model.Player;
import java.util.Comparator;


public class NameComparatorByRole implements Comparator<Player>{

	@Override
	public int compare(Player o1, Player o2) {
		
		return o1.getNome().compareTo(o2.getNome());
	}
	

}
