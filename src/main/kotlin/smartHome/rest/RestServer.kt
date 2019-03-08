package smartHome.rest

import io.javalin.Javalin


fun main(args: Array<String>) {
    val app = Javalin.create().start(8080)

    app.before("*") { ctx ->
        println("[${ctx.host()}] calling [${ctx.path()}]")
    }

    app.get("/") { ctx -> ctx.result("Hello World") }

    app.post("/device/*") { ctx ->
        val body = ctx.body()
        if (body == "0" || body == "1") {
            ctx.result("Testing: ${ctx.body()}")
        } else {
            ctx.status(500)
            ctx.result("Must be 1 or 0")
        }
    }
    app.get("/device/*") { ctx ->
        ctx.result("1")
    }


}