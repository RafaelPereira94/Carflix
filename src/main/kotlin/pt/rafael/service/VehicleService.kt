package pt.rafael.service

import io.github.cdimascio.dotenv.Dotenv
import org.bson.types.ObjectId
import org.litote.kmongo.*
import org.litote.kmongo.id.toId
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

    fun fetchVehicleById(id: String) : Vehicle? {
        val bsonId: Id<Vehicle> = ObjectId(id).toId()
        return vehicleCollection.findOne(Vehicle::id eq bsonId)
    }
}