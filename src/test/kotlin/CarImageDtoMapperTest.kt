import org.junit.Assert.assertEquals
import org.junit.Test
import pt.rafael.domain.CarImage
import pt.rafael.domain.dto.CarImageDTO
import pt.rafael.extensions.toCarImage
import pt.rafael.extensions.toCarImageDTO

class CarImageDtoMapperTest {

    private val carImageDto = CarImageDTO(
        carId = "123",
        imageLabel = "front",
        imageData = byteArrayOf(1, 2, 3, 4)
    )

    private val carImage = CarImage(
        carId = "123",
        imageLabel = "front",
        imageData = byteArrayOf(1, 2, 3, 4)
    )

    @Test
    fun `should map CarImageDTO to CarImage`() {
        val result = carImageDto.toCarImage()
        assertEquals(result, carImage)
    }

    @Test
    fun `should map CarImage to CarImageDTO`() {
        val result = carImage.toCarImageDTO()
        assertEquals(result, carImageDto)
    }

}