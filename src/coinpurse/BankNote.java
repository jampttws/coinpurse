package coinpurse;

import java.util.Random;

/**
 * Banknote represents banknote (money) with a fixed value ,currency and serial number. 
 * @author Tanasorn Tritawisup
 *
 */

public class BankNote extends Money {

	private long serialNumber = 1000000;
	
	/**
	 * Initialize a new BankNote.
	 * @param value of the banknote.
	 * @param currency of the banknote.
	 */
	public BankNote(double value, String currency, long serialNumber){
		super(value, currency);
		this.serialNumber = serialNumber;
	}
	
	/**
	 * Get a serial number of the Banknote.
	 * @return serialNumber.
	 */
	public long getSerial(){
		return serialNumber;	
	}
	
    @Override
	public String toString(){
		return String.format("%.0f-%s note [%d]", this.getValue() ,this.getCurrency() ,getSerial());
	}
}
