package coinpurse;

/**
 * An interface for objects having a monetary value and currency.
 * @author Tanasorn Tritawisup
 * 
*/
public interface Valuable extends Comparable<Valuable>{
	
	/**
     * Get the monetary value of this object, in its own currency.
     * @return the value of this object
     */	
	public double getValue();
	
	/**
     * Get the currency.
     * @return the currency of this object
     */	
	public String getCurrency();
	

}
