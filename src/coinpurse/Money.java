package coinpurse;

/**
 * Money class represent any coin and banknote
 * with value and currency.
 * @author Tanasorn Tritawisup
 *
 */
public class Money implements Valuable{

	protected double value;
	protected String currency;

	/**
	 * Initialize a new Money.
	 * @param value
	 * @param currency
	 */
	public Money(double value, String currency){
//	if(value >= 0) 
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Get the value of the money.
	 * @return value.
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Get the currency of the money.
	 * @return currency
	 */
	public String getCurrency() {
		return currency;
	}
	
	/**
     * Compare two objects that implement Valuable.
     * First compare them by currency, so that "Baht" < "Dollar".
     * If both objects have the same currency, order them by value.
     */
	@Override
	public int compareTo(Valuable v){
		if (this.getCurrency().equals(v.getCurrency())) {
			return Double.compare(this.getValue(), v.getValue());
		} 
		return this.getCurrency().compareTo(v.getCurrency());
	}
	
	/**
	 * @param arg is the Object that you want to compare.
	 * @return true if two Money have the same value and currency.
	 */
    @Override
	public boolean equals(Object obj){
		if (obj == null) return false;
	    if (obj.getClass() != this.getClass()) return false;
	    Money other = (Money)obj;
		return this.getValue() == other.getValue() && this.getCurrency().equals(other.getCurrency());
	}

}