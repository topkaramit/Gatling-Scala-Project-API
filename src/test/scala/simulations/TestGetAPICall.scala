package simulations

import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class TestGetAPICall extends Simulation {

  // HTTP configuration
  val httpVal = http
    .baseUrl("https://restful-api.dev")
    .header("Accept", "application/json")
    .header("Content-Type", "application/json")

  // Scenario - API method
  val scngetapi = scenario("get-json-example")
    .exec(
      http("get-json-example")
        .get("/objects?id=3&id=5&id=10") // ✅ specify GET endpoint
        .check(status is 200)
    )

  // Setup
  setUp(
    scngetapi.inject(atOnceUsers(1000))
  ).protocols(httpVal)
}
