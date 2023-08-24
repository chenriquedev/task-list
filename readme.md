# Api de tarefas

#### Desafio: Implementar um Sistema de Gerenciamento de Tarefas usando Spring Boot e Spring MVC

###Descrição:
O objetivo deste desafio é criar um sistema simples de gerenciamento de tarefas utilizando o Spring Framework. O sistema permitirá que os usuários cadastrem, visualizem, atualizem e excluam tarefas.

###Configuração do Projeto:

Utilize o Spring Initializr para configurar o projeto Spring Boot.
Adicione as dependências necessárias

##Dependências utilizadas:

- Spring boot data JPA
- Spring boot DevTools
- Spring boot Starter Web
- UUID
- Flyway Core
- ModelMapper
- Postgresql
- Lombok

###Tarefa:

Crie uma entidade "Task" que tenha os seguintes atributos: id, título, descrição, data de criação e status (concluída ou não).

Camadas do Aplicativo:

Crie uma camada de serviço para lidar com a lógica de negócios relacionada às tarefas.
Implemente um repositório usando o Spring Data JPA para interagir com o banco de dados.
Controladores:

Crie controladores para lidar com as operações CRUD das tarefas.

Implemente endpoints para:

- Listar todas as tarefas.
- Exibir detalhes de uma tarefa específica.(em implementação)
- Criar uma nova tarefa.
- Atualizar uma tarefa existente.
- Excluir uma tarefa.

Validações:(a ser implantado)

Adicione validações nos campos do formulário, como garantir que o título da tarefa não esteja vazio.

Testes:(a ser implantado)

Crie testes unitários para os componentes principais, como serviços e controladores.
