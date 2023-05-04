package pt.rafael.domain

data class CarImage(val carId: String, val imageLabel: String, val imageData: ByteArray) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CarImage

        if (carId != other.carId) return false
        if (imageLabel != other.imageLabel) return false
        return imageData.contentEquals(other.imageData)
    }

    override fun hashCode(): Int {
        var result = carId.hashCode()
        result = 31 * result + imageLabel.hashCode()
        result = 31 * result + imageData.contentHashCode()
        return result
    }
}