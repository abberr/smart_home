package smartHome.rest

import io.javalin.Javalin
import smartHome.services.*
import java.time.Instant
import java.time.format.DateTimeFormatter


fun main(args: Array<String>) {
    val app = Javalin.create().start(8080)

    app.before("*") { ctx ->
        println("${DateTimeFormatter.ISO_INSTANT.format(Instant.now())} - [${ctx.ip()}] calling [${ctx.path()}] with body [${ctx.body()}]")
    }

    app.get("/") { ctx -> ctx.result("Hello World") }

    app.post("/device/:id") { ctx ->
        val body = ctx.body()
        val deviceId = ctx.pathParam("id").toInt()
        if (body == "1") {
            deviceOn(deviceId)
        }
        else if (body == "0"){
            deviceOff(deviceId)
        }
        else {
            ctx.status(500)
            ctx.result("Must be 1 or 0")
        }
    }
    app.get("/device/*") { ctx ->
        ctx.result("1")
    }
}
