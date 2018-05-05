package corbaServer;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import HelloApp.Hello;
import HelloApp.HelloHelper;

public class Main {

	public static void main(String[] args) {

	try {
		ORB orb = ORB.init(args,null);
		POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		rootpoa.the_POAManager().activate();
		
		HelloServant helloobj = new HelloServant();
		helloobj.setOrg(orb);
		
		org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloobj);
		Hello href = HelloHelper.narrow(ref);
		
		org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
		NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
		
		NameComponent path[] = ncRef.to_name("ABC");
		ncRef.rebind(path, href);
		
		System.out.println("Hello Server ready and waiting");
		
		for (;;) {
			orb.run();
		}
		
		
		} catch (InvalidName | AdapterInactive | org.omg.CosNaming.NamingContextPackage.InvalidName | ServantNotActive | WrongPolicy | NotFound | CannotProceed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	System.out.println("Hello Server exit");
		
	}

}
