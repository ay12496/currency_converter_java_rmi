import java.rmi.*;
public interface CurrencyConverter extends Remote{
	public int converter(String from_currency, String to_currency,float amount)throws RemoteException;
}
