# elasticsearch-scala-base

Exemplo funcional mínimo de integração com Elasticsearch em Scala (usando o Java High Level REST Client).

**Este é um exemplo de framework principal para search, indexing e observability em plataformas de alto volume.**

**Português (resumo):**
Suporta serviços de "Elasticsearch" para busca, indexação e observabilidade em plataformas de alto volume. Exemplo funcional de ingestão de dados "legados" e consulta – perfeito para projetos de modernização onde você precisa adicionar busca moderna sobre sistemas antigos. Fácil de estender com streams Flink/Kafka (veja flink-kafka-scala-base), busca semântica com IA, migrações bulk, etc.

**English:**

Minimal, functional Elasticsearch integration example in Scala (using the Java High Level REST Client).

**This is a core framework example for search, indexing, and observability in high-volume platforms.**

## Why this base?
- Directly supports services: "Elasticsearch" for search, indexing and observability in high-volume platforms.
- Functional example of ingesting "legacy" data and querying it – perfect for modernization projects where you need to add modern search on top of old systems.
- Easy to extend with Flink/Kafka streams (see flink-kafka-scala-base), AI semantic search, bulk migrations, etc.

## Quick Start (Functional)

1. Start Elasticsearch:
   ```bash
   docker-compose up -d
   ```

2. Run the example:
   ```bash
   sbt run
   ```

It will index a sample legacy order and search for shipped ones.

## Running the tests

**Português:**

```bash
sbt test
```

O teste unitário básico (ScalaTest) cobre a construção do documento de "legacy order". Não requer Elasticsearch rodando (usa função pura extraída para testabilidade).

**English:**

```bash
sbt test
```

The basic unit test (ScalaTest) covers building the legacy order document. It does not require a running Elasticsearch instance (uses an extracted pure function for testability).

Note: The full example in `sbt run` needs `docker-compose up -d` for a live ES.

## Extend for Real Use

- Replace the hardcoded doc with data from legacy DB (JDBC, Play Anorm, etc.).
- Use BulkProcessor for high volume.
- Add Kafka consumer to index events in real time.
- Integrate with AI: generate embeddings for semantic search.
- Add security, TLS, multiple indices for different legacy sources.

## Portfolio Mapping

This project demonstrates practical experience with Elasticsearch in enterprise environments for search and observability layers on top of legacy and modern backends.

See the full set of base projects and services:
https://ivamartins.github.io/code-solutions-site/

Company: https://www.linkedin.com/company/code-solutions-it/

Clone this, adapt the client config and mappings to your domain, and you have a solid, production-oriented starting point for search features in modernization or new platforms.
