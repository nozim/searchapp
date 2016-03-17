package com.m8vn3m

/**
 * Created by m8vn3m on 17/3/16.
 */
trait SearchAlgorithm {
  def maxDistance: Double
  def timethreshold: Double

  def search(es: Iterable[Entry], person1: String, person2:String): Iterable[Meet]
}

trait SearchByRoutes extends SearchAlgorithm {

  //Shamelessly took from here http://stackoverflow.com/questions/9160001/how-to-profile-methods-in-scala
  def time[R](block: => R): R = {
    val t0 = System.nanoTime()
    val result = block    // call-by-name
    val t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0)/10e-9 + "sec")
    result
  }
  override def search(es: Iterable[Entry], person1: String, person2: String): Iterable[Meet] = {
    println("Preprocessing:")
    println("Grouping by routes...")
    val individualRoutes = es.toList.groupBy(_.uid)
    val route1 = individualRoutes.get(person1).get
    val route2 = individualRoutes.get(person2).get
    println("Search...")

    time {
      route1.flatMap(entry => {
        route2.filter((other: Entry) =>
          other.floor == entry.floor
            && entry.distance(other) < maxDistance
            && entry.timeDiff(other) < timethreshold
        ).map(c => {
          Meet(c, entry)
        })
      })
    }
  }
}
