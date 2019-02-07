package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Money;
import coinpurse.Valuable;

/**
 * Find strategy to withdraw a money in the purse.
 * with recursive strategy.
 * @author Tanasorn Tritawisup
 *
 */
public class RecursiveWithdraw implements WithdrawStrategy{

	/**
     * Withdraw the amount, using only items that have 
     * the same currency as the parameter(amount). 
     * amount must not be null and amount.getValue() > 0.
     * @param amount is a money that want to withdraw.
     * @param valuables is a list of money.
     * @return List of Valuable class for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> valuables) {

		double value = amount.getValue();
		if(value == 0) return new ArrayList<>();
		if(value != 0 && valuables.size() == 0) return null;
		if(value < 0) return null;

		Valuable money = new Money(value - valuables.get(0).getValue(), amount.getCurrency());
		
		List<Valuable> list = withdraw(money, valuables.subList(1, valuables.size()));
		
		if(list != null) {
			list.add(valuables.get(0)); 
			return list;
		}
		return withdraw(amount, valuables.subList(1, valuables.size())); 
	
			
	}
	

}
