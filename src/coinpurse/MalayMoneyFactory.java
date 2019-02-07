package coinpurse;

import java.util.ArrayList;
import java.util.List;

/**
 * MalayMoneyFactory is the class for creating Malaysia's money.
 * This class is a subclass of MoneyFactory.
 * @author Tanasorn Tritawisup
 *
 */
public class MalayMoneyFactory extends MoneyFactory{
		
	/**Serial number of banknote*/
	private long serialNumber = 1000000;
	
	/**All the value of Malaysia's money*/
	private double[] malayMoney = {0.05, 0.10, 0.20, 0.50, 1, 2, 5, 10, 20, 50, 100};
	
	/**
	 * Create Malaysia's money with a currency "Ringgit".
	 * @param value of the money that want to create.
	 * @return valuable
	 */
	@Override
	public Valuable createMoney(double value) throws IllegalArgumentException {
		List<Double> mm = new ArrayList<Double>();
		for(double m : malayMoney){
			mm.add(m);
		}
		if (mm.contains(value)) {
			if (value < 1) return new Coin(value, "Ringgit");
			else return new BankNote(value, "Ringgit", serialNumber++);
		}
		return null;
	}
	
}
