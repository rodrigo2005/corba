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






