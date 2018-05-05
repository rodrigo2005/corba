# corba

Passo - 1

Criar um projeto java:

Criar uma class Main:

Criar um arquivo HelloApp.idl


|--nomeProjeto
|	|-- Main.java
|
|-- HelloApp.idl
```
module HelloApp{

	interface Hello{
		attribute string msg;
	};
};
```


Comando para criar estrutura do corba:   
   
   
   
   
   
F:\idlj -fall HelloApp.idl
