package com.m8vn3m

object FindMeetingsApp extends SearchByRoutes {

  def timethreshold = 60 * 1000
  def maxDistance = 3

  def main(args: Array[String]): Unit = {
    val path = "./data/reduced.csv"
    val person1ID = "5a8ace07"
    val person2ID = "a7a5f9e5"

    val dataSource : DataSource = new CSVDataSource(path)
    val meetings = search(dataSource.fetch(),person1ID,person2ID)
    meetings.toList.sortBy(_.e1.timestamp.getMillis).map(println(_))

  }
}
