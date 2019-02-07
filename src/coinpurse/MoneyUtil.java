package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *  A class that use to test compareTo mathod of Coin object with Valuable class. 
 *  @author Tanasorn Tritawisup
 */
public class MoneyUtil {
	
	private static long serialNumber = 1000000;

	public static void main(String[] args){
		List<Valuable> value = new ArrayList<Valuable>();
		value.add(new Coin(10,"Baht"));
		value.add(new Coin(5, "Rupie"));
		value.add(new Coin(15, "Baht"));
		value.add(new Coin(2, "Baht"));
		value.add(new BankNote(20, "Euro", serialNumber++));
		value.add(new BankNote(50, "Baht", serialNumber++));
	    filterByCurrency(value, "Baht");
		printValue(value);
		sortMoney(value);
		
		 Money m1 = new BankNote(100, "Baht", serialNumber++);
	     Money m2 = new BankNote(500, "Baht", serialNumber++);
	     Money m3 = new Coin(20, "Baht");
	     Money max = MoneyUtil.max( m1, m2, m3 );
		 System.out.println(max.toString());
		 
		 List<BankNote> list = new ArrayList<BankNote>(); 
		 list.add( new BankNote(10.0, "USD", serialNumber++) ); 
		 list.add( new BankNote(500.0, "Baht", serialNumber++) ); 
		 MoneyUtil.sortMoney( list );
		 
		 List<Coin> coins = Arrays.asList( new Coin(5,"Baht"), new Coin(0.1,"Ringgit"), new Coin(5,"Cent") );
         List<Coin> result = MoneyUtil.filterByCurrency(coins, "Baht");
		
	}
	
	/**
	 * Return the larger argument, based on sort order, using
	 * the objects' own compareTo method for comparing.
	 * @param args one or more Comparable objects to compare.
	 * @return the argument that would be last if sorted the elements.
	 * @throws IllegalArgumentException if no arguments given.
	*/
	public static <E extends Comparable<? super E>> E max(E ... args) {
		E max = args[0];
		for(E element : args){
			max = (element.compareTo(max) > 0) ? element : max;
		}
		return max;
	}
	
	/**
	 * This method use to print every value in the list.
	 * @param value is the List of the object that is a subclass of valuable.
	 */
	static void printValue(List<? extends Valuable> value){
		for(int i = 0; i < value.size(); i++){
			System.out.println(value.get(i));
		}
	}
	
	/**
	 * Make the List that have only value with the same currency.
	 * @param element is the List of the object that is a subclass of valuable.
	 * @param currency of the object that you want to get in a List.
	 * @return a List of object that you get from parameter with the same currency 
	 *     as the currency(parameter).
	 */
    static <E extends Valuable> List<E> filterByCurrency(List<E> element, String currency){
    	List<E> filter = new ArrayList<E>();
    	for(E e : element){
    		if(e.getCurrency().equals(currency)){
    			filter.add(e);
    		}
    	}
	return filter;		
	}
	
	/**
	 * Sort method to test compareTo method.
	 * @param value is the List of the object that is a subclass of valuable.
	 */
	public static void sortMoney(List<? extends Valuable> value){
		Comparator<Valuable> comparator = new ValueComparator();
		Collections.sort(value, comparator);
	}
	
	
	
	
}
