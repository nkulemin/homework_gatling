package perf

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Actions {

  //------------open------------

  val webtours = http("/webtours/")
    .get("/webtours/")
    .check(status is 200)

  val welcomePl = http("/cgi-bin/welcome.pl")
    .get("/cgi-bin/welcome.pl")
    .queryParam("signOff", "true")
    .check(status is 200)

  val navPl = http("/cgi-bin/nav.pl")
    .get("/cgi-bin/nav.pl")
    .queryParam("in", "home")
    .check(status is 200)
    .check(regex(pattern = """name="userSession" value="(.+)"""").saveAs("userSession"))

  //-------------login------------

  val loginPl = http("/cgi-bin/login.pl")
    .post("/cgi-bin/login.pl")
    .formParam("userSession", "${userSession}")
    .formParam("username", "${login}")
    .formParam("password", "${password}")
    .formParam("login.x", "0")
    .formParam("login.y", "0")
    .formParam("JSFormSubmit", "off")
    .check(status is 200)

  val navPll = http("/cgi-bin/nav.pl")
    .get("/cgi-bin/nav.pl")
    .queryParam("page", "menu")
    .queryParam("in", "home")
    .check(status is 200)

  val loginPll = http("/cgi-bin/login.pl")
    .get("/cgi-bin/login.pl")
    .queryParam("into", "true")
    .check(status is 200)

  //------------buyTicket----------

  val welcomePll = http("/cgi-bin/welcome.pl")
    .get("/cgi-bin/welcome.pl")
    .queryParam("page", "search")
    .check(status is 200)

  val navPlll = http("/cgi-bin/nav.pl")
    .get("/cgi-bin/nav.pl")
    .queryParam("page", "menu")
    .queryParam("in", "flights")
    .check(status is 200)

  val reservationsPl = http("/cgi-bin/reservations.pl")
    .get("/cgi-bin/reservations.pl")
    .queryParam("page", "welcome")
    .check(status is 200)
    .check(regex("""name="departDate" value="(.+)" size=""").saveAs("departDate"))
    .check(regex("""name="returnDate" value="(.+)" size=""").saveAs("returnDate"))

  val reservationsPll = http("/cgi-bin/reservations.pl")
    .post("/cgi-bin/reservations.pl")
    .formParam("advanceDiscount", "0")
    .formParam("depart", "${depart}")
    .formParam("departDate", "${departDate}")
    .formParam("arrive", "${arrive}")
    .formParam("returnDate", "${returnDate}")
    .formParam("numPassengers", "1")
    .formParam("seatPref", "None")
    .formParam("seatType", "Coach")
    .formParam("findFlights.x", "54")
    .formParam("findFlights.y", "10")
    .formParam(".cgifields", "roundtrip")
    .formParam(".cgifields", "seatType")
    .formParam(".cgifields", "seatPref")
    .check(status is 200)
    .check(regex(pattern = """name="outboundFlight" value="(\w+\;\w+\;\w+\/\w+\/\w+)"""").findAll.saveAs("outboundFlight"))

  val reservationsPlll = http("/cgi-bin/reservations.pl")
    .post("/cgi-bin/reservations.pl")
    .formParam("outboundFlight", "${outboundFlight.random()}")
    .formParam("numPassengers", "1")
    .formParam("advanceDiscount", "0")
    .formParam("seatType", "Coach")
    .formParam("seatPref", "None")
    .formParam("reserveFlights.x", "51")
    .formParam("reserveFlights.y", "5")
    .check(status is 200)

  val reservationsPllll = http("/cgi-bin/reservations.pl")
    .post("/cgi-bin/reservations.pl")
    .formParam("firstName", "Nikita")
    .formParam("lastName", "Kulemin")
    .formParam("address1", "Esenina")
    .formParam("address2", "Voronezh")
    .formParam("pass1", "Nikita Kulemin")
    .formParam("creditCard", "43632467272457")
    .formParam("expDate", "1212")
    .formParam("oldCCOption", "")
    .formParam("numPassengers", "1")
    .formParam("seatType", "Coach")
    .formParam("seatPref", "None")
    .formParam("outboundFlight", "${outboundFlight.random()}")
    .formParam("advanceDiscount", "0")
    .formParam("returnFlight", "")
    .formParam("JSFormSubmit", "off")
    .formParam("buyFlights.x", "53")
    .formParam("buyFlights.y", "12")
    .formParam(".cgifields","saveCC")
    .check(status is 200)

  //------------itinerary-------------

  val welcomePlll = http("/cgi-bin/welcome.pl")
    .get("/cgi-bin/welcome.pl")
    .queryParam("page", "itinerary")
    .check(status is 200)

  val navPllll = http("/cgi-bin/nav.pl")
    .get("/cgi-bin/welcome.pl")
    .queryParam("page", "menu")
    .queryParam("in", "itinerary")
    .check(status is 200)

  val itineraryPl = http("/cgi-bin/itinerary.pl")
    .get("/cgi-bin/itinerary.pl")
    .check(status is 200)

  //-------------signOff--------------

  val welcomePllll = http("/cgi-bin/welcome.pl")
    .get("/cgi-bin/welcome.pl")
    .queryParam("signOff", "1")
    .check(status is 200)

  val navPlllll = http("/cgi-bin/nav.pl")
    .get("/cgi-bin/welcome.pl")
    .queryParam("in", "home")
    .check(status is 200)

  val homeHtml = http("/WebTours/home.html")
    .get("/WebTours/home.html")
    .check(status is 200)
}



