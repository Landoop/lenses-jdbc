package io.lenses.jdbc4.mappers

import io.lenses.jdbc4.row.ListRow
import io.lenses.jdbc4.row.Row

/**
 * <P>The table type is:
 *  <OL>
 *  <LI><B>TABLE_TYPE</B> String {@code =>} table type.  Typical types are "TABLE",
 *                  "VIEW", "SYSTEM TABLE", "GLOBAL TEMPORARY",
 *                  "LOCAL TEMPORARY", "ALIAS", "SYNONYM".
 *  </OL>
 */
object ShowTableTypesMapper : (Row) -> Row {
  override fun invoke(row: Row): Row = ListRow(listOf(row.getString(1)))
}