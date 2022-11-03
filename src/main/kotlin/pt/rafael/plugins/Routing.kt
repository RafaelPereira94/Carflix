package pt.rafael.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import pt.rafael.routes.VehicleRouting.createVehicleRoute

fun Application.configureRouting() {
    routing {
        createVehicleRoute()
    }
}
