import java.rmi.*;
import java.rmi.server.*;
import java.util.*;


public class CurrencyConverterRemote extends UnicastRemoteObject implements CurrencyConverter{

	int numOfCurrency;
	Vector<Vector<Double>> ExchangeRate = new Vector<Vector<Double>>();
	Map m1 = new HashMap(); 

	// public static void main(String[] args) throws RemoteException {
	// 	CurrencyConverter con = new CurrencyConverterRemote(5);
	// 	// System.out.println("Inr to Dollar:"+con.converter("inr","usd",50));
	// }


	CurrencyConverterRemote(int numOfCurrency)throws RemoteException {
		super();
		this.numOfCurrency=numOfCurrency;
		intializingExchangeRate(numOfCurrency);
	}

	void intializingExchangeRate(int numOfCurrency){

		m1.put("inr", new Integer(0));
		m1.put("usd", new Integer(1));
		m1.put("pound", new Integer(2));
		m1.put("yen", new Integer(3));
		m1.put("euro", new Integer(4));

		Vector<Double> row = new Vector<Double>();
		for(int i=0;i<numOfCurrency;i++){
			row.removeAllElements();
			for(int j=0;j<numOfCurrency;j++){
				if(i<j){
					row.add(new Double(Math.random()));	
				}
				else if(i==j){
					row.add(new Double(1));
				}
				else{

					Vector<Double> temp = ExchangeRate.elementAt(j);
					System.out.println();
					row.add(1/temp.elementAt(i));
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

	public double getExchangeRate(String from_currency, String to_currency) {
		int i=((Integer)m1.get(from_currency)).intValue();
		int j=((Integer)m1.get(to_currency)).intValue();
		Vector<Double> temp = ExchangeRate.elementAt(i);
		return ((Double)temp.elementAt(j)).doubleValue();
	}
	public double converter(String from_currency, String to_currency,double amount)throws RemoteException {
		double exchange_rate=getExchangeRate(from_currency,to_currency);
		return exchange_rate*amount;
	}

}
