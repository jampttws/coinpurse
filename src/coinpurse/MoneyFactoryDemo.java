package coinpurse;

/**
 * Test the method of any MoneyFactory.
 * @author Tanasorn Tritawisup
 *
 */
public class MoneyFactoryDemo {
	
	public static void main(String[] args){		
		//test create Thai's money
		MoneyFactory tm = new ThaiMoneyFactory();
		System.out.println(tm.createMoney(1));
		System.out.println(tm.createMoney(20));
		System.out.println(tm.createMoney(50));
		
		//test create Malaysia's money
		MoneyFactory mm = new MalayMoneyFactory();
		System.out.println(mm.createMoney(0.05));
		System.out.println(mm.createMoney(2));
		System.out.println(mm.createMoney(100));
		
		//test setFactory
		MoneyFactory mf1 = MoneyFactory.getInstance();
		System.out.println(mf1.createMoney(2));
		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory mf2 = MoneyFactory.getInstance();
		System.out.println(mf2.createMoney(0.10));
		MoneyFactory mf3 = MoneyFactory.getInstance();
		if(mf2 == mf3) {
			System.out.println("singleton");
		}else {
			System.out.println("not singleton");
		}
		
	}

}
