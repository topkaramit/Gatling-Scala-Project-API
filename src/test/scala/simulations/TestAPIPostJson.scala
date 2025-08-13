import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.io.Source

class PostToRestfulApi extends Simulation {

  val jsonBody: String =
    Source.fromResource("SupportingFileData/PostCallJsonData.json").mkString

  val httpConf = http
    .baseUrl("https://restful-api.dev/")
    .header("Accept", "application/json")
    .header("Content-Type", "application/json")
    .header("User-Agent", "Mozilla/5.0 (Gatling Test)")

  val scn = scenario("Create Object")
    .exec(
      http("Create Object Request")
        .post("objects") // ✅ Must be exactly /objects
        .body(StringBody(jsonBody)).asJson
        .check(status.is(200)) // Or .is(201) if created
    )
    .pause(2)

  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)
}
