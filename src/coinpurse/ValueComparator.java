package coinpurse;

import java.util.Comparator;

/**
 * A comparator of a Valuable class.
 * @author Tanasorn Tritawisup
 *
 */

public class ValueComparator implements Comparator<Valuable> {
	
	/**
     * Compare two objects that implement Valuable.
     * First compare them by currency, so that "Baht" < "Dollar".
     * If both objects have the same currency, order them by value.
     */
	public int compare(Valuable a, Valuable b)	{
		if (a.getCurrency().equals(b.getCurrency())) {
			 if(a.getValue() < b.getValue())  return -1;
			 else if(a.getValue() > b.getValue())  return 1;
			 else if(a.getValue() == b.getValue()) return 0;
		} 
		return a.getCurrency().compareTo(b.getCurrency());
	}

}
