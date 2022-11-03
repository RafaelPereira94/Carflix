package pt.rafael.service

import io.github.cdimascio.dotenv.Dotenv
import org.litote.kmongo.*
import pt.rafael.domain.Vehicle

class VehicleService {
    private val dotenv: Dotenv = Dotenv.configure().filename(".env").load()
    private val client = KMongo.createClient(dotenv.get("CONNECTION_STRING"))
    private val database = client.getDatabase("Carflix")
    private val vehicleCollection = database.getCollection<Vehicle>()

    fun createVehicle(vehicle: Vehicle): Id<Vehicle>? {
        val insertedOne = vehicleCollection.insertOne(vehicle)
        return vehicle.id
    }
}