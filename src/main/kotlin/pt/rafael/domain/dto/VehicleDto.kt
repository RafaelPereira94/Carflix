package pt.rafael.domain.dto

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class VehicleDto(
    val id: String? = null,
    val brand: String,
    val model: String,
    val version: String,
    val images: List<String>,
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
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)
