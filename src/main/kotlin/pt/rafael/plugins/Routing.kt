package pt.rafael.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import pt.rafael.routes.VehicleRouting.createVehicleRoute
import pt.rafael.routes.VehicleRouting.fetchVehicleRoutes

fun Application.configureRouting() {
    routing {
        createVehicleRoute()
        fetchVehicleRoutes()
    }
}
