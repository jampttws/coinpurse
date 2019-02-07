package coinpurse.strategy;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import coinpurse.Valuable;
import coinpurse.ValueComparator;

/**
 * Find strategy to withdraw a money in the purse.
 * @author Tanasorn Tritawisup
 *
 */
public class GreedyWithdraw implements WithdrawStrategy {
	
	private Comparator<Valuable> comparator = new ValueComparator();
	
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

		List<Valuable> withdraw = new ArrayList<Valuable>();

		double getBalance = 0;
		for(Valuable v : valuables) getBalance  += v.getValue();
		if (value <= 0 || value > getBalance) return null;

		java.util.Collections.sort(valuables);
		Collections.sort((List<Valuable>) valuables, comparator);

		for (int i = valuables.size() - 1; i >= 0; i--) {
			if (value >= valuables.get(i).getValue()) {
				value -= valuables.get(i).getValue();
				withdraw.add(valuables.get(i));
			}
		}

		if (value != 0) return null;

		return withdraw;

	}

}
