import java.rmi.*;
import java.rmi.server.*;
import java.util.*;


public class CurrencyConverterRemote extends UnicastRemoteObject implements CurrencyConverter{

	int numOfCurrency;
	Vector<Vector<Double>> ExchangeRate = new Vector<Vector<Double>>();
	Map m1 = new HashMap(); 

	public static void main(String[] args) throws RemoteException {
		new CurrencyConverterRemote(5);

	}


	CurrencyConverterRemote(int numOfCurrency)throws RemoteException {
		super();
		this.numOfCurrency=numOfCurrency;
		intializingExchangeRate(numOfCurrency);
	}

	void intializingExchangeRate(int numOfCurrency){

		m1.put("inr", 0);
		m1.put("usd", 1);
		m1.put("pound", 2);
		m1.put("yen", 3);
		m1.put("euro", 4);

		Vector<Double> row = new Vector<Double>();
		for(int i=0;i<numOfCurrency;i++){
			row.removeAllElements();
			for(int j=0;j<numOfCurrency;j++){
				if(i<=j){
					row.add(new Double(Math.random()));	
				}
				else{

					Vector<Double> temp = ExchangeRate.elementAt(j);
					System.out.println();
					row.add(temp.elementAt(i));
				}
			}
			ExchangeRate.add(new Vector<Double>(row));
		}

		for(int i=0;i<numOfCurrency;i++){
			row=ExchangeRate.elementAt(i);
			for(int j=0;j<numOfCurrency;j++){
					System.out.print(row.elementAt(j)+"\t");
			}
			System.out.println();
		}
	}

	public int getExchangeRate(String from_currency, String to_currency) {
		return ExchangeRate.elementAt()
	}
	public int converter(String from_currency, String to_currency,float amount)throws RemoteException {
		return 1;
	}

}
