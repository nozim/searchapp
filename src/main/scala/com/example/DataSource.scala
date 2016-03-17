package com.example

import org.joda.time.DateTime

/**
 * Created by m8vn3m on 17/3/16.
 */

trait DataSource {
  def fetch(): Iterable[Entry]
}

class CSVDataSource(filePath: String) extends DataSource {
  override def fetch(): Iterable[Entry] = {
    val source = io.Source.fromFile(filePath)

    source.getLines().drop(1).map(line => {
      val cols: Array[String] = line.split(",").map(_.trim)
      val timestamp = DateTime.parse(cols(0))
      Entry(timestamp, cols(1).toDouble, cols(2).toDouble, cols(3).toInt, cols(4))
    }).toIterable
  }
}
