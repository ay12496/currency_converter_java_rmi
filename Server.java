import java.rmi.*;
import java.rmi.registry.*;

public class Server{

	public static void main(String args[]){
		try{

			CurrencyConverterRemote stub=new CurrencyConverterRemote(5);
			Naming.rebind("rmi://localhost:5000/sonoo",stub);

		}catch(Exception e){System.out.println(e);}
	}

}
