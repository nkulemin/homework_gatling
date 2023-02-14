package perf

import io.gatling.core.Predef._

object Feeders {
  val users = csv("users.csv").circular

  val depart = csv("depart.csv").random

  val arrive = csv("arrive.csv").random
}