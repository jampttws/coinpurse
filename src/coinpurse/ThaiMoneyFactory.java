package coinpurse;

import java.util.ArrayList;
import java.util.List;

/**
 * ThaiMoneyFactory is the class for creating Thai's money.
 * This class is a subclass of MoneyFactory.
 * @author Tanasorn Tritawisup
 *
 */
public class ThaiMoneyFactory extends MoneyFactory{
	
	/**Serial number of banknote*/
	private long serialNumber = 1000000;
	
	/**All the value of Thai's money*/
	private double[] thaiMoney = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
	
	/**
	 * Create Thai's money with a currency "Bath".
	 * @param value of the money that want to create.
     * @return valuable
	 */
	@Override
	public Valuable createMoney(double value) throws IllegalArgumentException{
		List<Double> tm = new ArrayList<Double>();
		for(double m : thaiMoney){
			tm.add(m);
		}
		if (tm.contains(value)) {
			if (value < 20) return new Coin(value, "Baht");
			else return new BankNote(value, "Baht", serialNumber++);
		}
		return null;
	}
	
}
