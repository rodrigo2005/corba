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
