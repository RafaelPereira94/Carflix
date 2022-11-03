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
            val vehicle = request.toVehicle();

            vehicleService.createVehicle(vehicle) ?.let {
                call.respond(HttpStatusCode.Created, it.toString())
            } ?: call.respond(HttpStatusCode.BadRequest, ErrorResponse.BAD_REQUEST_RESPONSE)
        }
    }
}
