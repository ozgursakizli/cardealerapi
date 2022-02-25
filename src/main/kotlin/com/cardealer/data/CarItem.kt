package com.cardealer.data

@kotlinx.serialization.Serializable
data class CarItem(
    val brand: String,
    val model: String,
    val imageUrl: String
)