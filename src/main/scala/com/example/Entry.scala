package com.example

import org.joda.time.DateTime

/**
 * Created by m8vn3m on 17/3/16.
 */

case class Entry(timestamp: DateTime, x: Double, y: Double, floor: Int, uid: String) {
  def distance(other: Entry): Double = {
    math.sqrt(math.pow(other.x-x,2)+math.pow(other.y-y,2))
  }

  def timeDiff(other: Entry): Long = {
    math.abs(other.timestamp.getMillis - other.timestamp.getMillis)
  }
}

case class Meet(e1: Entry, e2: Entry)
