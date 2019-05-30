# Atividade prática

Desenvolva uma aplicação que realize as operações de CRUD para a entidade `Cliente` e `Produto`. 
As funcionalidades precisam estar disponíveis com UI (interface para o usuário) com um template usável e implementadas fazendo uso da arquitetura 
__Enterprise JavaBeans__.

```java
class Cliente{
    private int id;
    private String nome;
    private String cpf;
}
class Produto{
    private int id;
    private String descricao;
    private BigDecimal valor;
}
```

## Metodologia

Esta atividade prática está planejada para ser executada entre duas equipes, a turma deve ser dividida em duas equipes.
Toda a atividade deverá ser executada o intervalo das aulas e quando o tempo se esgotar as equipes devem fazer a entrega da respectiva atividade. Cada equipe deve fazer o __fork__ deste projeto e implementar sua própria solução. 

Caso surja alguma dúvida no desenvolvimento, falar de imediato via [Slack](https://ifpb-dac-20191.slack.com/messages/CHZGZMM17/). 
> Lembrete: Não guardem dúvidas, elas são como as dívidas. Acumulam-se e nos prejudicam :)
 

## Requisitos Funcionais

* **RF01** - Implementar a classe `Venda`; 
* **RF02** - Implementar o acesso aos dados com 'DataSource'; 
* **RF03** - Na pasta __cliente__, criar as páginas `edit.xhtml` e `list.xhtml` para o arquivo de template `template.xhtml`; 
* **RF04** - Implementar um carrinho de Compras fazendo uso de um componente `Stateful`. 
* **RF05** - Adicionar um `selectOneMenu` na página `edit.xhtml` da pasta __venda__. 
Deve ser possível selecionar um `Produto` e associar sua instância ao atributo `produtos` da classe `Venda`. 
* **RF06** - Criar as páginas para edição e listagem da entidade `Produto`; 
* **RF07** - Criar uma página que permita realizar uma busca por `CPF`; 
* **RF08** - Criar uma página que permita realizar uma busca por `descricao`; 
* **RF09** - Criar uma página que permita realizar uma nova `Venda`; 

## Requisitos Não Funcionais
* **RN01** - A aplicação será desenvolvida em módulos. Deve ser possível acessá-la em ambiente web e standalone. 
* **RN02** - Não é preciso fazer uso de interface gráfica no módulo __standalone__
* **RN03** - Realizar o deploy da aplicação usando o [Docker Compose](https://docs.docker.com/compose/).

