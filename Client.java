import java.rmi.*;
import java.util.*;
import java.io.*;
public class Client{

	public static void main(String args[]){
		try{
			BufferedReader brinp = null;
			brinp = new BufferedReader(new InputStreamReader(System.in));
			CurrencyConverter stub=(CurrencyConverter)Naming.lookup("rmi://localhost:5000/sonoo");
			System.out.println("Inr to Dollar:"+ stub.converter("inr","usd",50));
			System.out.print("Enter From_Currency:");
			String from_currency=brinp.readLine();
			System.out.print("Enter To_Currency:");
			String to_currency=brinp.readLine();
			System.out.print("Enter Amount:");
			double amount =Double.parseDouble(brinp.readLine());
			System.out.println("Inr to Dollar:"+ stub.converter(from_currency,to_currency,amount));
		}catch(Exception e){System.out.println(e);}
	}

}
