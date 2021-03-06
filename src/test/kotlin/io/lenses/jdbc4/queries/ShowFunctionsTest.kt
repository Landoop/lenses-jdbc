package io.lenses.jdbc4.queries

import io.kotlintest.matchers.collections.shouldContain
import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec
import io.lenses.jdbc4.LensesDriver
import io.lenses.jdbc4.ProducerSetup
import io.lenses.jdbc4.resultset.toList

class ShowFunctionsTest : FunSpec(), ProducerSetup {
  init {

    LensesDriver()

    val conn = conn()

    test("SHOW FUNCTIONS schema") {
      val stmt = conn.createStatement()
      val rs = stmt.executeQuery("SHOW FUNCTIONS")
      rs.metaData.columnCount shouldBe 3
      List(3) { rs.metaData.getColumnLabel(it + 1) } shouldBe listOf("name", "description", "return_type")
    }

    test("SHOW FUNCTIONS data") {
      val stmt = conn.createStatement()
      val rs = stmt.executeQuery("SHOW FUNCTIONS").toList()
      rs.shouldContain(listOf("exists", "Returns true if the given field is present in the payload or false otherwise.", "boolean"))
    }
  }
}