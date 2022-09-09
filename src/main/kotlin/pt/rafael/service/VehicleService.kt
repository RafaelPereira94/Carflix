package pt.rafael.service

import org.litote.kmongo.*
import pt.rafael.domain.Vehicle

class VehicleService {
    private val client = KMongo.createClient()
    private val database = client.getDatabase("Carflix")
    private val vehicleCollection = database.getCollection<Vehicle>()


}