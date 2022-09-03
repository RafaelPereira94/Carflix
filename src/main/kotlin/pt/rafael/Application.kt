package pt.rafael

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import pt.rafael.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0",
    watchPaths = listOf("classes", "resources")) {
        configureHTTP()
        configureMonitoring()
        configureSerialization()
        configureRouting()
    }.start(wait = true)
}
