import com.mongodb.client.MongoCollection
import com.mongodb.client.result.InsertOneResult
import junit.framework.TestCase.assertEquals
import org.junit.Ignore
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import pt.rafael.domain.Vehicle
import pt.rafael.service.VehicleService
import java.time.Instant

class VehicleServiceTest {

    private val vehicleCollection = mock<MongoCollection<Vehicle>>()
    private val service = VehicleService()
    private val insertOneResult = mock<InsertOneResult>()

    @Test
    fun `CreateVehicle should insert a new vehicle and return an Id`() {
        val vehicle = buildVehicle()

        whenever(vehicleCollection.insertOne(any<Vehicle>())).thenReturn(insertOneResult)

        val result = service.createVehicle(vehicle)

        assertEquals(vehicle.id, result)
    }

    @Test
    @Ignore
    fun `FetchVehicleById should retrieve a vehicle`() {
        //TODO
    }

    @Test
    @Ignore
    fun `FetchAllVehicles should retrieve all vehicles`() {
        //TODO
    }

    @Test
    @Ignore
    fun `DeleteVehicleById should delete a vehicles by Id`() {
        //TODO
    }

    @Test
    @Ignore
    fun `UpdateVehicleById should update a vehicle info`() {
        //TODO
    }

    private fun buildVehicle(): Vehicle {
        return Vehicle(
            id = null,
            brand = "mercedes",
            model = "e",
            version = "250",
            images = emptyList(),
            price = 1.0,
            doors = 1,
            year = 2000,
            month = 1,
            kilometer = 1,
            miles = 1.0,
            fuel = "gas",
            segment = emptyList(),
            transmission = "auto",
            usage = "usage",
            color = "color",
            description = "",
            isDeleted = false,
            isReserved = false,
            isSold = false,
            createdAt = Instant.ofEpochMilli(1000).toString(),
            updatedAt = Instant.ofEpochMilli(1001).toString()
        )
    }
}
