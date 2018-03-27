import java.rmi.*;
public interface CurrencyConverter extends Remote{
	public double converter(String from_currency, String to_currency,double amount)throws RemoteException;
}
