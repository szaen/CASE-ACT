```mermaid
graph TB
    subgraph External ["Camada de Acesso"]
        Client(Cliente/Usuário)
        Gateway[API Gateway]
        Auth[Serviço de Autenticação]
    end

    subgraph FinancialDomain ["Domínio Financeiro"]
        LB1[Load Balancer - Lançamentos]
        LancamentosService[Serviço de Lançamentos]
        DB_Lancamentos[(Database Lançamentos)]
        note1[Processa débitos e créditos<br/>independente do serviço<br/>de consolidação]
    end

    subgraph ReportingDomain ["Domínio de Relatórios"]
        LB2[Load Balancer - Consolidação]
        ConsolidadoService[Serviço de Consolidado]
        DB_Consolidado[(Database Consolidado)]
        Cache[(Cache Layer)]
        note2[Processa 50 req/s<br/>Perda máx. 5%]
    end

    subgraph Integration ["Camada de Integração"]
        Queue[(Message Broker)]
        note3[Garante resiliência e<br/>desacoplamento entre domínios]
    end

    subgraph Observability ["Camada de Observabilidade"]
        Monitor[Monitoramento & Observabilidade]
        note4[Métricas, Logs e Traces<br/>para todos os componentes]
    end

    %% Connections
    Client --> Gateway
    Gateway --> Auth
    Gateway --> LB1
    Gateway --> LB2
    LB1 --> LancamentosService
    LB2 --> ConsolidadoService
    LancamentosService --> DB_Lancamentos
    LancamentosService -- Eventos Assíncronos --> Queue
    Queue -- Processamento Resiliente --> ConsolidadoService
    ConsolidadoService --> DB_Consolidado
    ConsolidadoService --> Cache
    LancamentosService -.-> Monitor
    ConsolidadoService -.-> Monitor
    DB_Lancamentos -.-> Monitor
    DB_Consolidado -.-> Monitor
    Queue -.-> Monitor

    %% Styles
    classDef service fill:#68a063,stroke:#333,stroke-width:2px;
    classDef database fill:#3498db,stroke:#333,stroke-width:2px;
    classDef cache fill:#e74c3c,stroke:#333,stroke-width:2px;
    classDef lb fill:#f1c40f,stroke:#333,stroke-width:2px;
    classDef monitor fill:#8e44ad,stroke:#333,stroke-width:2px;
    classDef note fill:#fff,stroke:#333,stroke-width:1px,stroke-dasharray: 5 5;
    classDef domain fill:#f5f5f5,stroke:#666,stroke-width:2px;

    class LancamentosService,ConsolidadoService service;
    class DB_Lancamentos,DB_Consolidado database;
    class Cache cache;
    class LB1,LB2 lb;
    class Monitor monitor;
    class note1,note2,note3,note4 note;
    class FinancialDomain,ReportingDomain,Integration,Observability,External domain;
