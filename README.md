# corba

### Passo - 1

Criar um projeto java:

Criar uma class Main:

Criar um arquivo HelloApp.idl

```
|--nomeProjeto
|	|-- Main.java
|
|-- HelloApp.idl
```

### Conteudo HelloApp.idl

```
module HelloApp{

	interface Hello{
		attribute string msg;
	};
};
```

Após criar o arquivo acima executar o seguinte comando abaixo: 
F:\caminho_projeto> idlj -fall HelloApp.idl

Este comando criar a estrutura baseando no HelloApp.idl

Criando arquivo Servant:

Servant - Esta é uma entidade de linguagem de programação de implementação que define as operações que suportam uma interface IDL CORBA. Os servidores podem ser escritos em vários idiomas, incluindo C, C ++, Java, Smalltalk e Ada.
 
Ou seja e a implementação que será chamda e executada no server:

```
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

``` 

Após isso criamos 



o conteudo do main :

```
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

``` 

Antes de rodar o main, adicionar este argumento na configuração da execução:

-ORBInitialHost localhost -ORBInitialPort 9999

E depois executa : start tnameserv -ORBInitialPort 9999



