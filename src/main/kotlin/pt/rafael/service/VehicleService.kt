package pt.rafael.service

import com.mongodb.client.MongoCollection
import io.github.cdimascio.dotenv.Dotenv
import org.bson.types.ObjectId
import org.litote.kmongo.*
import org.litote.kmongo.id.toId
import pt.rafael.domain.Vehicle

class VehicleService {
    //Add loggers.

    private val dotenv: Dotenv = Dotenv.configure().filename(".env").load()
    private val client = KMongo.createClient(dotenv.get("CONNECTION_STRING"))
    private val database = client.getDatabase("Carflix")
    private val vehicleCollection: MongoCollection<Vehicle> = database.getCollection<Vehicle>()

    fun createVehicle(vehicle: Vehicle): Id<Vehicle>? {
        vehicleCollection.insertOne(vehicle)
        return vehicle.id
    }

    fun fetchVehicleById(id: String): Vehicle? {
        val bsonId: Id<Vehicle> = ObjectId(id).toId()
        return vehicleCollection.findOne(Vehicle::id eq bsonId)
    }

    fun fetchAllVehicles(): List<Vehicle?> {
        val vehicleList = mutableListOf<Vehicle>()
        vehicleCollection.find().forEach { v -> vehicleList.add(v) }
        return vehicleList
    }

    fun deleteVehicleById(id: String): Boolean {
        val deleteResult = vehicleCollection.deleteOneById(ObjectId(id))
        return deleteResult.deletedCount == 1L
    }

    fun updateVehicleById(id: String, request: Vehicle): Boolean =
        fetchVehicleById(id)
            ?.let {
                val updateVehicle = vehicleCollection.replaceOne(request)
                updateVehicle.modifiedCount == 1L
            } ?: false
}