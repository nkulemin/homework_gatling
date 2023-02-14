package perf

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import perf.Actions._

object CommonScenario{
  def apply(): ScenarioBuilder = new CommonScenario().mainScenario
}

class CommonScenario {

  val open = group("open") {
    exec(webtours)
      .exec(welcomePl)
      .exec(navPl)
  }

  val login = group("login"){
    exec(loginPl)
      .exec(navPll)
      .exec(loginPll)
  }

  val buyTicket = group("buyTicket") {
    exec(welcomePll)
      .exec(navPlll)
      .exec(reservationsPl)
      .exec(reservationsPll)
      .exec(reservationsPlll)
      .exec(reservationsPllll)
  }

  val itinerary = group("itinerary") {
    exec(welcomePlll)
      .exec(navPllll)
      .exec(itineraryPl)
  }

  val signOff = group("signOff") {
    exec(welcomePllll)
      .exec(navPlllll)
      .exec(homeHtml)
  }

  val mainScenario = scenario("mainScenario")
    .feed(Feeders.users)
    .exec(open)
    .exec(login)
    .feed(Feeders.depart)
    .feed(Feeders.arrive)
    .exec(buyTicket)
    .exec(itinerary)
    .exec(signOff)
}