package com.example

import java.text.SimpleDateFormat

import org.joda.time.DateTime

case class Entry(timestamp: DateTime, x: Double, y: Double, floor: Int, uid: String) {
  def distance(other: Entry): Double = {
    math.sqrt(math.pow(other.x-x,2)+math.pow(other.y-y,2))
  }

  def timeDiff(other: Entry): Long = {
    math.abs(other.timestamp.getMillis - other.timestamp.getMillis)
  }
}

case class Meet(e1: Entry, e2: Entry)

object Hello {


  val timethreshold = 60 * 1000
  val maxDistance = 3

  def main(args: Array[String]): Unit = {
    val source = io.Source.fromFile("/Users/m8vn3m/Projects/teralytics/data/reduced.csv")
    val format = new SimpleDateFormat("yyyy-MM-DD")

    val es: Iterator[Entry] = source.getLines().drop(1).map(line => {
      val cols: Array[String] = line.split(",").map(_.trim)
      val timestamp = DateTime.parse(cols(0))
      Entry(timestamp, cols(1).toDouble, cols(2).toDouble, cols(3).toInt, cols(4))
    })


    val individualRoutes = es.toList.groupBy(_.uid)

    val ids = individualRoutes.keys
    println(ids.size)
    val c = "5a8ace07"
    val o = "a7a5f9e5"
    //ids.take(150).toList.combinations(2).toList.map { case Seq(c,o) =>
      findMeetings(individualRoutes, c,o)
    //}

  }

  def findMeetings(individualRoutes: Map[String, List[Entry]], c: String, o:String) = {
    val meetings = individualRoutes.get(c).get.flatMap(entry => {
      individualRoutes.get(o).get.filter((other: Entry) =>
        other.floor == entry.floor
          && entry.distance(other) < maxDistance
          && entry.timeDiff(other) < timethreshold
      ).map(c => {
        Meet(c, entry)
      })
    })
    meetings.sortBy(_.e1.timestamp.getMillis).map(println(_))
  }
}
