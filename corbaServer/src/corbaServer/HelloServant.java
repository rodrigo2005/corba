package corbaServer;

import org.omg.CORBA.ORB;

import HelloApp.HelloPOA;

public class HelloServant extends HelloPOA {

	private String msg = "\nOla Mundo!\n";
	
	private ORB org;
	
	
	public void setOrg(ORB org) {
		this.org = org;
	}

	@Override
	public String msg() {		
		return this.msg;
	}

	@Override
	public void msg(String newMsg) {
		this.msg = newMsg;		
	}

}
