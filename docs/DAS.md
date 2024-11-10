<<<<<<< HEAD
# Documento de Arquitetura de Soluções (DAS)

## 1. Introdução
**Objetivo Geral do Projeto**  
Este projeto visa desenvolver uma solução arquitetural para o sistema de controle de lançamentos e consolidação financeira, garantindo escalabilidade, segurança e confiabilidade.

**Importância dos Domínios Funcionais e Capacidades de Negócio**  
Os domínios funcionais e suas capacidades de negócio foram definidos para garantir que a solução atenda plenamente aos objetivos do sistema.

## 2. Mapeamento de Domínios Funcionais e Capacidades de Negócio
- **Domínio de Lançamentos**: Processamento e consulta de lançamentos financeiros.
  - **Capacidades**:
    - Processar lançamentos (débitos e créditos)
    - Consultar lançamentos

- **Domínio de Consolidação e Relatórios**: Consolidação de saldos e geração de relatórios.
  - **Capacidades**:
    - Consolidar saldos diários
    - Gerar relatórios financeiros

## 3. Arquitetura Alvo
A arquitetura é baseada em uma estrutura de microsserviços, onde cada domínio funcional possui seus próprios serviços independentes.

### Diagrama de Contêineres
![Diagram de Contêineres](link-para-o-diagrama.png)  <!-- Atualize com o link real quando o diagrama estiver pronto -->

### Diagrama de Sequência
![Diagram de Sequência](link-para-o-diagrama.png)  <!-- Atualize com o link real quando o diagrama estiver pronto -->

## 4. Justificativa das Decisões de Ferramentas e Tecnologias
- **Java com Spring Boot** para desenvolvimento de serviços.
- **API Gateway** para gerenciamento de autenticação e roteamento.
- **Message Broker** (RabbitMQ/Kafka) para comunicação assíncrona entre serviços.
- **PostgreSQL/MySQL** como banco de dados relacional.

## 5. Monitoramento e Observabilidade
Ferramentas como **Prometheus** e **Grafana** serão usadas para monitorar e exibir métricas dos serviços.

=======
# Documento de Arquitetura de Soluções (DAS)

## 1. Introdução
**Objetivo Geral do Projeto**  
Este projeto visa desenvolver uma solução arquitetural para o sistema de controle de lançamentos e consolidação financeira, garantindo escalabilidade, segurança e confiabilidade.

**Importância dos Domínios Funcionais e Capacidades de Negócio**  
Os domínios funcionais e suas capacidades de negócio foram definidos para garantir que a solução atenda plenamente aos objetivos do sistema.

## 2. Mapeamento de Domínios Funcionais e Capacidades de Negócio
- **Domínio de Lançamentos**: Processamento e consulta de lançamentos financeiros.
  - **Capacidades**:
    - Processar lançamentos (débitos e créditos)
    - Consultar lançamentos

- **Domínio de Consolidação e Relatórios**: Consolidação de saldos e geração de relatórios.
  - **Capacidades**:
    - Consolidar saldos diários
    - Gerar relatórios financeiros

## 3. Arquitetura Alvo
A arquitetura é baseada em uma estrutura de microsserviços, onde cada domínio funcional possui seus próprios serviços independentes.

### Diagrama de Contêineres
![Diagram de Contêineres](link-para-o-diagrama.png)  <!-- Atualize com o link real quando o diagrama estiver pronto -->

### Diagrama de Sequência
![Diagram de Sequência](link-para-o-diagrama.png)  <!-- Atualize com o link real quando o diagrama estiver pronto -->

## 4. Justificativa das Decisões de Ferramentas e Tecnologias
- **Java com Spring Boot** para desenvolvimento de serviços.
- **API Gateway** para gerenciamento de autenticação e roteamento.
- **Message Broker** (RabbitMQ/Kafka) para comunicação assíncrona entre serviços.
- **PostgreSQL/MySQL** como banco de dados relacional.

## 5. Monitoramento e Observabilidade
Ferramentas como **Prometheus** e **Grafana** serão usadas para monitorar e exibir métricas dos serviços.

>>>>>>> 653b777e8d34c40979935d3634c482ecced465c4
