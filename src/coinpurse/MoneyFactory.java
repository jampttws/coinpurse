package coinpurse;

/**
 * MoneyFactory is the class for creating money.
 * @author Tanasorn Tritawisup
 *
 */
public abstract class MoneyFactory{
	
	/** singleton instance of MoneyFactory. */
	private static MoneyFactory instance;
			
	/**
	 * Get an instance of MoneyFactory.
	 * @return an object of a subclass (such as ThaiMoneyFactory).
	 */
	public static MoneyFactory getInstance(){
		if(instance == null){
			instance = new ThaiMoneyFactory();
		}
		return instance;
	}
	
	/**
	 * Create new money object in the local currency.
	 * @param value of money that you want to create.
	 * @return Valuable of the money.
	 */
	public abstract Valuable createMoney(double value);
	
	/**
	 * Accepts money value as a String
	 * @param value of money that you want to create.
	 * @return Valuable of the money.
	 */
	public Valuable createMoney(String value) {
		double valued = 0;
		try{
		    valued = Double.parseDouble(value);
		}catch(IllegalArgumentException ex){
			System.out.print(ex.getMessage());
		}
		return createMoney(valued);	
	}
	
	/**
	 * Set MoneyFactory that you want to create any type of money.
	 * @param mf 
	 */
	public static void setFactory(MoneyFactory mf){
		instance = mf;
	}
	
	
	
	
		
	
	
	
	
	 
	

}
