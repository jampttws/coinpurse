package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currecy. 
 * @author Tanasorn Tritawisup
 *
 */
public class Coin extends Money {
	
	/** 
	 * Initialize a new Coin.
	 * @param value is value of coin.
	 * @param currency is type of coin.
	 */
	public Coin(double value, String currency){
		super(value, currency);
	}
	
    @Override
	public String toString(){
    	if(this.getCurrency().equals("Ringgit") && this.getValue() < 1){
    		return String.format("%.0f-Sen", this.getValue()*100);
    	}
		return String.format("%.0f-%s", this.getValue(), this.getCurrency());		
	}
	
}
