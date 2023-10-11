## Endpoints

### Professores

#### Listar Professores

- **Endpoint**: `/professor`
- **Método**: GET
- **Descrição**: Retorna a lista de todos os professores.
- **Parâmetros**:
  - `paginacao` (query, obrigatório): Objeto de paginação. Consulte a definição em [Pageable](#pageable).
- **Resposta**:
  - Código HTTP 200
  - Corpo da resposta: Lista de objetos [DadosListagemProfessor](#dadoslistagemprofessor).

#### Atualizar Professor

- **Endpoint**: `/professor`
- **Método**: PUT
- **Descrição**: Atualiza os dados de um professor.
- **Parâmetros**:
  - `dados` (query, obrigatório): Objeto com os dados a serem atualizados. Consulte a definição em [DadosAtualizacaoProfessor](#dadosatualizacaoprofessor).
- **Resposta**:
  - Código HTTP 200
  - Corpo da resposta: Objeto [DadosAtualizacaoProfessor](#dadosatualizacaoprofessor).

#### Cadastrar Professor

- **Endpoint**: `/professor`
- **Método**: POST
- **Descrição**: Cadastra um novo professor.
- **Corpo da Solicitação**:
  - Formato: JSON
  - Conteúdo: Objeto com os dados do professor a ser cadastrado. Consulte a definição em [DadosCadastroProfessor](#dadoscadastroprofessor).
- **Resposta**:
  - Código HTTP 200
  - Corpo da resposta: Objeto [DadosCadastroProfessor](#dadoscadastroprofessor).

#### Deletar Professor

- **Endpoint**: `/professor/{id}`
- **Método**: DELETE
- **Descrição**: Deleta um professor pelo ID.
- **Parâmetros**:
  - `id` (path, obrigatório): ID do professor a ser deletado.
- **Resposta**:
  - Código HTTP 200

### Alunos

#### Listar Alunos

- **Endpoint**: `/alunos`
- **Método**: GET
- **Descrição**: Retorna a lista de todos os alunos.
- **Parâmetros**:
  - `paginacao` (query, obrigatório): Objeto de paginação. Consulte a definição em [Pageable](#pageable).
- **Resposta**:
  - Código HTTP 200
  - Corpo da resposta: Lista de objetos [DadosListagemAluno](#dadoslistagemaluno).

#### Atualizar Aluno

- **Endpoint**: `/alunos`
- **Método**: PUT
- **Descrição**: Atualiza os dados de um aluno.
- **Parâmetros**:
  - `dados` (query, obrigatório): Objeto com os dados a serem atualizados. Consulte a definição em [DadosAtualizacaoAluno](#dadosatualizacaoaluno).
- **Resposta**:
  - Código HTTP 200
  - Corpo da resposta: Objeto [DadosAtualizacaoAluno](#dadosatualizacaoaluno).

#### Cadastrar Aluno

- **Endpoint**: `/alunos`
- **Método**: POST
- **Descrição**: Cadastra um novo aluno.
- **Corpo da Solicitação**:
  - Formato: JSON
  - Conteúdo: Objeto com os dados do aluno a ser cadastrado. Consulte a definição em [DadosCadastroAluno](#dadoscadastroaluno).
- **Resposta**:
  - Código HTTP 200
  - Corpo da resposta: Objeto [DadosCadastroAluno](#dadoscadastroaluno).

#### Excluir Aluno

- **Endpoint**: `/alunos/{id}`
- **Método**: DELETE
- **Descrição**: Exclui um aluno pelo ID.
- **Parâmetros**:
  - `id` (path, obrigatório): ID do aluno a ser excluído.
- **Resposta**:
  - Código HTTP 200

### Autenticação

#### Efetuar Login

- **Endpoint**: `/login`
- **Método**: POST
- **Descrição**: Realiza a autenticação de um usuário.
- **Corpo da Solicitação**:
  - Formato: JSON
  - Conteúdo: Objeto com os dados de autenticação. Consulte a definição em [DadosAutentiacao](#dadosautenticacao).
- **Resposta**:
  - Código HTTP 200
  - Corpo da resposta: Objeto com informações de autenticação.

## Modelos de Dados

### DadosAtualizacaoProfessor

- **Descrição**: Modelo de dados para atualização de professor.
- **Campos**:
  - `id` (integer, int64, obrigatório): ID do professor.
  - `nome` (string): Nome do professor.
  - `email` (string): Endereço de email do professor.
  - `endereco` (object): Objeto com informações de endereço. Consulte a definição em [DadosEndereco](#dadosendereco).

### DadosAtualizacaoAluno

- **Descrição**: Modelo de dados para atualização de aluno.
- **Campos**:
  - `id` (integer, int64, obrigatório): ID do aluno.
  - `nome` (string): Nome do aluno.
  - `responsavel` (string): Nome do responsável pelo aluno.
  - `email` (string): Endereço de email do aluno.
  - `endereco` (object): Objeto com informações de endereço. Consulte a definição em [DadosEndereco](#dadosendereco).

### DadosCadastroProfessor

- **Descrição**: Modelo de dados para cadastro de professor.
- **Campos**:
  - `nome` (string, obrigatório): Nome do professor.
  - `cpf` (string): CPF do professor.
  - `telefone` (string): Número de telefone do professor.
  - `disciplina` (string, enum): Disciplina lecionada pelo professor (opções: INGLÊS, MATEMÁTICA, FÍSICA, GRAMÁTICA, QUÍMICA, LITERATURA, REDAÇÃO, SOCIOLOGIA, GEOGRAFIA, HISTÓRIA, ARTES).
  - `email` (string): Endereço de email do professor.
  - `filhos` (boolean): Indica se o professor tem filhos.
