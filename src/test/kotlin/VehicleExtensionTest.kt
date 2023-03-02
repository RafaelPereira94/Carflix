import org.junit.Test
import org.litote.kmongo.id.StringId
import pt.rafael.domain.Vehicle
import pt.rafael.domain.dto.VehicleDto
import pt.rafael.extensions.toDto
import pt.rafael.extensions.toVehicle
import java.time.Instant
import kotlin.test.assertEquals

class VehicleExtensionTest {

    @Test
    fun testVehicleToDto() {
        val vehicle = buildVehicle()
        val actualDto = vehicle.toDto()
        val expectedDto = buildVehicleDto()

        assertEquals(expectedDto, actualDto)
    }

    @Test
    fun testVehicleDtoToVehicle() {
        val vehicleDto = buildVehicleDto()
        val actual = vehicleDto.toVehicle()
        val expectedVehicle = buildVehicle()

        assertEquals(expectedVehicle, actual)
    }

    private fun buildVehicleDto(): VehicleDto {
        return VehicleDto(
            id = "1",
            brand = "",
            model = "",
            version = "",
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

    private fun buildVehicle(): Vehicle {
        return Vehicle(
            id = StringId("1"),
            brand = "",
            model = "",
            version = "",
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
