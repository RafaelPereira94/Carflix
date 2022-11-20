package pt.rafael.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import pt.rafael.routes.VehicleRouting.createVehicleRoute
import pt.rafael.routes.VehicleRouting.deleteVehicleRoutes
import pt.rafael.routes.VehicleRouting.fetchAllVehiclesRoutes
import pt.rafael.routes.VehicleRouting.fetchVehicleRoutes
import pt.rafael.routes.VehicleRouting.updateVehicleByIdRoutes

fun Application.configureRouting() {
    routing {
        createVehicleRoute()
        fetchVehicleRoutes()
        fetchAllVehiclesRoutes()
        deleteVehicleRoutes()
        updateVehicleByIdRoutes()
    }
}
