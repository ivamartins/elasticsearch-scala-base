package com.codesolutions.es

import org.elasticsearch.client.{RequestOptions, RestHighLevelClient, RestClient}
import org.elasticsearch.client.RestClientBuilder
import org.elasticsearch.action.index.IndexRequest
import org.elasticsearch.action.search.SearchRequest
import org.elasticsearch.index.query.QueryBuilders
import org.elasticsearch.search.builder.SearchSourceBuilder
import org.apache.http.HttpHost
import java.util

/**
 * Elasticsearch Integration Base - Functional Portfolio Example
 *
 * Demonstrates indexing and searching on Elasticsearch, typical for high-volume
 * platforms, observability, and search features in legacy modernization.
 *
 * Ties to:
 * - Services: "Elasticsearch" for search, indexing and observability in high-volume platforms.
 * - Experience: Used in large scale systems for log/search, product search, etc.
 *
 * This is a minimal, functional base you can extend with:
 * - Bulk indexing from legacy DBs
 * - Real-time sync with Kafka/Flink (see flink-kafka-scala-base)
 * - AI semantic search (embeddings + vector)
 * - Legacy data migration pipelines
 *
 * Run: sbt run
 * Requires Elasticsearch running (use docker-compose or local).
 *
 * PT: Base funcional para integração com Elasticsearch em Scala.
 * Demonstra indexação e busca, típica para plataformas de alto volume, observability e features de busca em modernização de legados.
 * Estenda com bulk indexing de DBs legados, sync real-time com Kafka/Flink, busca semântica com IA, pipelines de migração de dados legados.
 * Rode com sbt run após subir ES via docker-compose.
 */
object EsIntegrationExample {
  def main(args: Array[String]): Unit = {
    val client: RestHighLevelClient = new RestHighLevelClient(
      RestClient.builder(new HttpHost("localhost", 9200, "http"))
    )

    try {
      // Index a sample "legacy" document (e.g. from old Play/Java system)
      val doc = new util.HashMap[String, AnyRef]()
      doc.put("id", "order-123")
      doc.put("customer", "ACME Ltd")
      doc.put("amount", Double.box(1250.75))
      doc.put("status", "shipped")
      doc.put("legacySource", "old-play-ecommerce-v1")
      doc.put("timestamp", Long.box(System.currentTimeMillis()))

      val indexRequest = new IndexRequest("legacy-orders")
        .id("order-123")
        .source(doc)

      val indexResponse = client.index(indexRequest, RequestOptions.DEFAULT)
      println(s"Indexed document: ${indexResponse.getResult}")

      // Search example
      val searchRequest = new SearchRequest("legacy-orders")
      val sourceBuilder = new SearchSourceBuilder()
      sourceBuilder.query(QueryBuilders.matchQuery("status", "shipped"))
      searchRequest.source(sourceBuilder)

      val searchResponse = client.search(searchRequest, RequestOptions.DEFAULT)
      println(s"Found ${searchResponse.getHits.getTotalHits.value} documents")

      searchResponse.getHits.getHits.foreach { hit =>
        println(s"Hit: ${hit.getSourceAsString}")
      }

    } finally {
      client.close()
    }
  }
}
