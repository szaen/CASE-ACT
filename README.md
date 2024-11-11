# Projeto CASE-ACT Digital - Lançamentos Financeiros e Consolidação de Dados

Este documento visa fornecer uma documentação consolidada dos arquivos README.md e CONTRIBUTING.md do projeto CASE-ACT Digital. A intenção é garantir uma apresentação abrangente e detalhada dos aspectos técnicos e das diretrizes de contribuição necessárias para a evolução profissional e colaborativa deste projeto. Ao centralizar e padronizar a documentação, visamos facilitar a integração de novos desenvolvedores, aumentar a eficiência das contribuições e garantir a escalabilidade da solução.

## Descrição Geral do Projeto

O CASE-ACT Digital é uma solução robusta e modular, baseada em uma arquitetura de microsserviços, voltada ao processamento eficiente de lançamentos financeiros, consolidação de saldos diários e geração de relatórios financeiros detalhados. Este projeto foi desenvolvido para atender a requisitos rigorosos de alta disponibilidade, segurança e escalabilidade, adotando uma abordagem que facilita a manutenção e extensão do sistema em ambientes complexos e resilientes. Além disso, a solução foi desenhada para suportar alto volume de transações, mantendo uma performance consistente e garantindo conformidade com padrões de segurança e melhores práticas do setor financeiro.

### Objetivos do Projeto

Os principais objetivos do CASE-ACT Digital são:

- **Automação de Processos Financeiros**: Minimizar a intervenção manual em operações de crédito e débito, garantindo precisão e agilidade.
- **Escalabilidade Modular**: A arquitetura de microsserviços permite que cada componente seja dimensionado independentemente, de acordo com a demanda, o que facilita adaptações futuras.
- **Segurança e Conformidade**: Implementar controles rigorosos para assegurar a integridade dos dados e proteger as informações financeiras sensíveis contra ameaças e acessos não autorizados.
- **Monitoramento Pró-ativo**: Utilizar ferramentas de monitoramento que permitam prever e prevenir problemas antes que afetem a experiência dos usuários finais.

## Estrutura do Projeto

A aplicação é composta por uma série de componentes fundamentais, cada um desempenhando um papel específico dentro da arquitetura global, o que proporciona flexibilidade na manutenção e na futura evolução da solução:

- **Serviço de Lançamentos**: Responsável pela gestão e criação de transações financeiras, incluindo operações de débito e crédito. Este serviço valida cada transação para garantir a integridade dos dados e fornecer feedback em tempo real aos usuários.
- **Serviço de Consolidação**: Encabeça a consolidação dos saldos diários, proporcionando uma visão global e acurada da situação financeira do sistema. Essa consolidação é realizada de maneira otimizada para lidar com grandes volumes de dados, permitindo gerar relatórios periódicos essenciais para a tomada de decisões.
- **API Gateway**: Atua como ponto de entrada único, gerenciando a autenticação e roteamento das requisições aos serviços internos, garantindo maior segurança e eficiência. Ele também oferece controle de acesso detalhado e proteção contra ataques comuns, como DDoS.
- **Banco de Dados**: Em ambientes de desenvolvimento, é utilizado o H2 para facilitar testes e prototipagem; em ambientes de produção, adota-se o PostgreSQL ou MySQL, garantindo a persistência e a integridade dos dados, além de assegurar a alta disponibilidade através de estratégias de replicação e failover.
- **Message Broker**: A comunicação assíncrona entre microsserviços é realizada via RabbitMQ ou Apache Kafka, possibilitando escalabilidade e resiliência no processamento de mensagens. Isso garante que as operações sejam realizadas de forma desacoplada, aumentando a robustez do sistema contra falhas individuais.
- **Monitoramento e Logs**: O sistema emprega Prometheus e Grafana para monitoramento em tempo real e análise de métricas, além do ELK Stack para centralização e consulta de logs. Este conjunto de ferramentas permite identificar rapidamente problemas operacionais, facilitando a manutenção preditiva e corretiva.

### Fluxo de Dados

O fluxo de dados dentro do sistema é otimizado para garantir a consistência e integridade em cada etapa do processamento. Cada serviço é responsável por uma etapa específica do fluxo, e a comunicação entre eles é feita de forma assíncrona, garantindo que a arquitetura seja resiliente e os componentes sejam independentes, evitando gargalos que possam comprometer a performance.

## Configuração do Ambiente e Requisitos

Para garantir um ambiente de desenvolvimento adequado, certifique-se de que as seguintes ferramentas estejam instaladas e configuradas corretamente:

- **Java 17+**: Linguagem principal utilizada no desenvolvimento dos microsserviços. A versão Java 17 foi escolhida devido a suas melhorias em segurança e desempenho, além do suporte a longo prazo.
- **Maven 3.6+**: Gerenciador de dependências e build, essencial para a automatização do processo de compilação, testes e integração contínua.
- **Docker**: Utilizado para a execução de contêineres, incluindo bancos de dados e message brokers, possibilitando um ambiente padronizado e minimizando problemas de configuração em diferentes máquinas.
- **Git**: Ferramenta para controle de versão e colaboração, garantindo rastreabilidade e gestão eficiente das contribuições ao código.

Para clonar o repositório e começar a trabalhar no projeto, utilize os seguintes comandos:

```bash
git clone https://github.com/sua-conta/CASE-ACT.git
cd CASE-ACT
```

### Configuração do Banco de Dados

Para configurar o banco de dados, crie um arquivo `.env` na raiz do projeto e preencha as variáveis de ambiente necessárias. Isso permite que as credenciais sejam gerenciadas de forma segura e flexível entre diferentes ambientes (desenvolvimento, homologação e produção):

```properties
DATABASE_URL=jdbc:postgresql://localhost:5432/case_act
DATABASE_USERNAME=seu_usuario
DATABASE_PASSWORD=sua_senha
```

Além disso, certifique-se de que o banco de dados esteja em execução e corretamente configurado antes de iniciar a aplicação.

### Compilando e Executando o Projeto

- Para compilar e instalar as dependências do projeto, execute o comando a seguir, que garantirá que todas as bibliotecas necessárias estejam disponíveis:

```bash
mvn clean install
```

- Para iniciar a aplicação em ambiente de desenvolvimento, utilize:

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

Este comando iniciará a aplicação com as configurações específicas para o ambiente de desenvolvimento, incluindo banco de dados em memória e logs mais detalhados para facilitar a depuração.

## Endpoints Principais da API

### Lançamentos

- **POST /api/lancamentos**: Criação de um novo lançamento financeiro. Este endpoint realiza a validação dos dados fornecidos, garantindo que estejam em conformidade com as regras de negócio.
- **GET /api/lancamentos**: Listagem de todos os lançamentos registrados. Suporta parâmetros de filtragem para facilitar a consulta, como data e tipo de transação.
- **GET /api/lancamentos/{id}**: Consulta de um lançamento específico a partir do seu ID. Retorna detalhes completos da transação, incluindo metadados relevantes.
- **PUT /api/lancamentos/{id}**: Atualização de um lançamento existente. Permite a modificação dos campos, desde que respeitadas as regras de integridade e validação.
- **DELETE /api/lancamentos/{id}**: Exclusão de um lançamento pelo ID. Realiza verificações para evitar a remoção de transações críticas.

### Consolidação

- **GET /api/consolidacao**: Consolidação dos dados financeiros diários, fornecendo uma visão holística dos saldos. Este endpoint é otimizado para garantir baixa latência, mesmo quando há um grande volume de dados a ser processado.
- **GET /api/relatorios**: Geração de relatórios financeiros em formatos PDF e CSV, facilitando a análise e auditoria. Relatórios são customizáveis, permitindo a seleção de períodos específicos e tipos de transações.

## Monitoramento e Observabilidade

- **Prometheus**: Ferramenta para coleta de métricas detalhadas, como tempos de resposta e utilização de recursos. As métricas coletadas são essenciais para a identificação precoce de problemas de desempenho.
- **Grafana**: Utilizado para a visualização das métricas coletadas, bem como a criação de dashboards que ajudam na tomada de decisão e gestão operacional. Possui alertas configuráveis para situações críticas.
- **ELK Stack**: Solução integrada para centralização, análise e consulta de logs, garantindo auditoria e rastreabilidade das operações. O ELK Stack facilita a detecção de anomalias e a investigação de problemas em produção.

## Contribuindo para o Projeto

### Diretrizes de Contribuição

Estamos comprometidos com a melhoria contínua da qualidade do código e da segurança do sistema. Para garantir contribuições efetivas, siga as seguintes diretrizes ao colaborar com o CASE-ACT Digital:

- **Fork do Repositório**: Crie uma cópia do repositório na sua conta do GitHub e, em seguida, clone para a sua máquina local. Essa prática permite que suas alterações sejam isoladas e revisadas antes de serem incorporadas ao projeto principal.
- **Criação de Branches**: Use `git checkout -b minha-contribuicao` para criar um branch específico para suas modificações, garantindo um fluxo de trabalho organizado e evitando conflitos com o branch principal.
- **Commits Pequenos e Descritivos**: Realize commits com mensagens claras e objetivas, que descrevam detalhadamente as alterações realizadas. Isso facilita o processo de revisão e auditoria do histórico do código.

### Pull Requests

- Todos os Pull Requests devem ser submetidos ao branch `main`. Certifique-se de atualizar seu branch com as últimas mudanças antes de criar o PR.
- Inclua descrições completas e detalhadas no PR, e garanta que todos os testes estejam passando antes de submetê-lo. Descreva o problema que está sendo resolvido e a abordagem utilizada.

### Padrões de Código

- **Java**: Siga as convenções de codificação da Oracle para Java, evitando duplicação de código e maximizando a legibilidade. Use Javadoc para documentar classes e métodos importantes.
- **Estrutura do Projeto**: Mantenha uma estrutura lógica e modular para o código, organizando-o em pacotes como `controller`, `service` e `repository`, facilitando a manutenção e a escalabilidade.

### Testes

- **Testes Unitários**: Valide as regras de negócio essenciais, como a lógica de débito e crédito, garantindo que cada função do sistema cumpra seu propósito isoladamente.
- **Testes de Integração**: Assegure-se de que todos os componentes interagem corretamente, incluindo microsserviços, API Gateway e message broker. Esses testes garantem que o sistema funcione como um todo.
- **Testes de Segurança**: Realize verificações rigorosas para identificar vulnerabilidades e conduza testes de penetração para garantir a resiliência do sistema contra possíveis ataques.

Para mais detalhes sobre as práticas de contribuição, consulte o arquivo `CONTRIBUTING.md`.

## Licença

Este projeto está licenciado sob a Licença MIT. Para mais detalhes, consulte o arquivo `LICENSE`. A Licença MIT permite ampla liberdade de uso e modificação, garantindo ao mesmo tempo a proteção dos direitos dos autores do software.

## Agradecimentos

Agradecemos a todos os colaboradores cujo empenho contribui para tornar este projeto mais robusto, escalável e eficiente. Estamos sempre abertos a novas contribuições e sugestões de melhoria, e apreciamos profundamente seu tempo e dedicação! A colaboração é essencial para o sucesso deste projeto, e valorizamos o engajamento da comunidade em tornar o CASE-ACT Digital uma referência em soluções financeiras modernas e escaláveis.

---

Este documento visa proporcionar uma visão abrangente e detalhada do projeto, facilitando tanto o uso quanto a manutenção e evolução da solução CASE-ACT Digital. Se precisar de mais informações ou desejar ajustes em alguma seção específica, não hesite em entrar em contato. A documentação está em constante evolução, e estamos comprometidos em mantê-la clara e útil para todos os envolvidos.

