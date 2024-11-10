```mermaid
graph TD
    subgraph "Frontend"
        UI[Interface do Usuário]
    end

    subgraph "Gateway Layer"
        AG[API Gateway]
        Auth[Serviço de Autenticação]
    end

    subgraph "Services Layer"
        LS[Serviço de Lançamentos]
        CS[Serviço de Consolidação]
    end

    subgraph "Message Layer"
        MB[Message Broker]
    end

    subgraph "Data Layer"
        DB1[(Banco de Lançamentos)]
        DB2[(Banco Consolidado)]
    end

    subgraph "Monitoring"
        P[Prometheus]
        G[Grafana]
    end

    UI --> AG
    AG --> Auth
    AG --> LS
    AG --> CS
    LS --> MB
    LS --> DB1
    MB --> CS
    CS --> DB2
    LS --> P
    CS --> P
    P --> G
    ```
