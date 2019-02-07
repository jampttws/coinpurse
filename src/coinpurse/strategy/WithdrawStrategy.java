package coinpurse.strategy;

import java.util.List;
import coinpurse.Valuable;

/**
 * Interface for withdraw strategy.
 * @author Tanasorn Tritawisup
 *
 */
public interface WithdrawStrategy {
	
	/**
	 * Find and return items from a collection whose
	 * total value equals the requested amount.
	 * @param amount is the amount of money to withdraw, with currency.
	 * @param valuables money the contents that are available for possible withdraw.
	 *        Must not to be null, but may be an empty list.
	 *        This list is not modified. 
	 * @return if a solution is found, return a List containing references
	 *         from the money parameter(List) whose sum equals the amount.
	 *         If a solution is not found, returns null. 
	 */
	public List<Valuable> withdraw(Valuable amount, List<Valuable> valuables);

}
