package coinpurse;

import java.util.ResourceBundle;

/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 * @author Tanasorn Tritawisup
 */
public class Main {
	
	public static MoneyFactory init(){
		ResourceBundle bundle = ResourceBundle.getBundle( "purse" );
		String factoryclass = bundle.getString( "moneyfactory" );
		MoneyFactory factory = null;
		try {
		    factory = (MoneyFactory)Class.forName(factoryclass).newInstance();
		}
		catch (ClassCastException cce) {
		    System.out.println(factoryclass + " is not type MoneyFactory");
		}
		catch (Exception ex) {
		    System.out.println("Error creating MoneyFactory "+ex.getMessage() );
		}
		if (factory == null) System.exit(1);
		MoneyFactory.setFactory(factory);		
		return factory;
	}

    /**
     * Configure and start the application.
     * @param args not used
     */
    public static void main( String[] args ) {
        // 1. create a Purse
    	Purse purse = new Purse(10);
        // 2. create a ConsoleDialog with a reference to the Purse object
    	ConsoleDialog ui = new ConsoleDialog(purse);
        // 3. run the ConsoleDialog
    	ui.run();

    }
}
