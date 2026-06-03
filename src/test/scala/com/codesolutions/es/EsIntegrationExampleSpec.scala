package com.codesolutions.es

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class EsIntegrationExampleSpec extends AnyFunSuite with Matchers {

  test("buildLegacyOrderDoc should create map with correct fields") {
    val doc = EsIntegrationExample.buildLegacyOrderDoc("order-999", "Test Corp", 42.0, "pending", "old-system")

    doc.get("id") shouldBe "order-999"
    doc.get("customer") shouldBe "Test Corp"
    doc.get("amount") shouldBe 42.0
    doc.get("status") shouldBe "pending"
    doc.get("legacySource") shouldBe "old-system"
    doc.containsKey("timestamp") shouldBe true
  }
}
