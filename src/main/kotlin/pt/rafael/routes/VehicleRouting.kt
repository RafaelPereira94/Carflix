package pt.rafael.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import pt.rafael.domain.dto.VehicleDto
import pt.rafael.service.VehicleService
import pt.rafael.extensions.*
import pt.rafael.responses.ErrorResponse

object VehicleRouting {

    private val vehicleService = VehicleService()

    fun Routing.createVehicleRoute() {
        post("/vehicle") {
            val request: VehicleDto = call.receive<VehicleDto>()
            val vehicle = request.toVehicle()

            vehicleService.createVehicle(vehicle)?.let {
                call.respond(HttpStatusCode.Created, it.toString())
            } ?: call.respond(HttpStatusCode.BadRequest, ErrorResponse.BAD_REQUEST_RESPONSE)
        }
    }

    fun Routing.fetchAllVehiclesRoutes() {
        get("/vehicle") {
            vehicleService.fetchAllVehicles()
                .let { vehicles ->
                    call.respond(HttpStatusCode.OK, vehicles.map { it?.toDto() })
                }
        }
    }

    fun Routing.fetchVehicleRoutes() {
        get("/vehicle/{id}") {
            val id = call.parameters["id"].toString()

            vehicleService.fetchVehicleById(id)?.let { foundVehicle ->
                call.respond(foundVehicle.toDto())
            } ?: call.respond(HttpStatusCode.NotFound, ErrorResponse.VEHICLE_NOT_FOUND_RESPONSE)
        }
    }

    fun Routing.deleteVehicleRoutes() {
        delete("/vehicle/{id}") {
            val id = call.parameters["id"].toString()
            val wasDeleted = vehicleService.deleteVehicleById(id)

            if (wasDeleted) {
                call.respond(HttpStatusCode.NoContent)
            } else {
                call.respond(HttpStatusCode.NotFound, ErrorResponse.VEHICLE_NOT_FOUND_RESPONSE)
            }
        }
    }

    fun Routing.updateVehicleByIdRoutes() {
        put("/vehicle/{id}") {
            val id = call.parameters["id"].toString()
            val vehicleInfo = call.receive<VehicleDto>()
            val wasUpdated  = vehicleService.updateVehicleById(id, vehicleInfo.toVehicle())

            if(wasUpdated) {
                call.respond(HttpStatusCode.NoContent)
            } else {
                call.respond(HttpStatusCode.BadRequest, ErrorResponse.BAD_REQUEST_RESPONSE)
            }
        }
    }
}
