package pt.rafael.domain.dto

import kotlinx.serialization.Serializable
import pt.rafael.domain.CarImage
import java.time.Instant

@Serializable
data class VehicleDto(
    val id: String? = null,
    val brand: String,
    val model: String,
    val version: String,
    val images: List<CarImageDTO>,
    val price: Double,
    val doors: Int,
    val year: Int,
    val month: Int,
    val kilometer: Int,
    val miles: Double,
    val fuel: String, //TODO enum
    val segment: List<String>, //TODO enum,
    val transmission: String,
    val usage: String,
    val color: String,
    val description: String,
    val isDeleted: Boolean,
    val isReserved: Boolean,
    val isSold: Boolean,
    val createdAt: String? = Instant.now().toString(),
    val updatedAt: String? = Instant.now().toString()
)
