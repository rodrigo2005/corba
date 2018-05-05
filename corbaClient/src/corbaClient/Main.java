package corbaClient;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import HelloApp.Hello;
import HelloApp.HelloHelper;

public class Main {

	public static void main(String[] args) {
		
		
		try {
			
			ORB orb  = ORB.init(args,null);
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			NamingContextExt ncref = NamingContextExtHelper.narrow(objRef);
			Hello helloobj = (Hello) HelloHelper.narrow(ncref.resolve_str("ABC"));
			
			System.out.println("welcome server orb");
			String r = helloobj.msg();
			System.out.println("MSG:: "+r);
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
