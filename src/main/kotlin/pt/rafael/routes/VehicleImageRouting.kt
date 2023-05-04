package pt.rafael.routes

import io.ktor.server.routing.*

object VehicleImageRouting {

    fun Routing.uploadCarImages() {
        post("/vehicle/:vehicleId/images") {

        }
    }
}