package com.m8vn3m

object FindMeetingsApp extends SearchByRoutes {

  def timethreshold = 60 * 1000
  def maxDistance = 3

  def main(args: Array[String]): Unit = {
    val path = args(0)
    val person1ID = args(1)
    val person2ID = args(2)

    val dataSource : DataSource = new CSVDataSource(path)
    val meetings = search(dataSource.fetch(),person1ID,person2ID)
    meetings.toList.sortBy(_.e1.timestamp.getMillis).map(println(_))

  }
}
