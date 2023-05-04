package pt.rafael.extensions

import org.litote.kmongo.id.StringId
import pt.rafael.domain.CarImage
import pt.rafael.domain.Vehicle
import pt.rafael.domain.dto.CarImageDTO
import pt.rafael.domain.dto.VehicleDto

fun Vehicle.toDto(): VehicleDto =
    VehicleDto(
        id = this.id.toString(),
        brand,
        model,
        version,
        images.map { it.toCarImageDTO() },
        price,
        doors,
        year,
        month,
        kilometer,
        miles,
        fuel,
        segment,
        transmission,
        usage,
        color,
        description,
        isDeleted,
        isReserved,
        isSold,
        createdAt,
        updatedAt
    )

fun VehicleDto.toVehicle(): Vehicle =
    Vehicle(
        id = StringId(this.id ?: ""),
        brand = this.brand,
        model = this.model,
        version = this.version,
        images = this.images.map { it.toCarImage() },
        price = this.price,
        doors = this.doors,
        year = this.year,
        month = this.month,
        kilometer = this.kilometer,
        miles = this.miles,
        fuel = this.fuel,
        segment = this.segment,
        transmission = this.transmission,
        usage = this.usage,
        color = this.color,
        description = this.description,
        isDeleted = this.isDeleted,
        isReserved = this.isReserved,
        isSold = this.isSold,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt
    )

fun CarImageDTO.toCarImage(): CarImage =
    CarImage(
        carId = this.carId,
        imageLabel = this.imageLabel,
        imageData = this.imageData
    )

fun CarImage.toCarImageDTO(): CarImageDTO =
    CarImageDTO(
        carId,
        imageLabel,
        imageData
    )