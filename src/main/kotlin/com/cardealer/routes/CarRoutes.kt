package com.cardealer.routes

import com.cardealer.data.CarItem
import com.cardealer.routes.RouteConstants.BASE_URL
import com.cardealer.routes.RouteConstants.CARS_ROUTE
import com.cardealer.routes.RouteConstants.CAR_BY_BRAND_ROUTE
import com.cardealer.routes.RouteConstants.INDEX_ROUTE
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.index() {
    get(INDEX_ROUTE) {
        call.respondText("Hello from CarDealerApi", ContentType.Text.Html)
    }
}

fun Route.getCars() {
    get(CARS_ROUTE) {
        call.respond(
            HttpStatusCode.OK,
            carList
        )
    }
}

fun Route.getCarByBrand() {
    get(CAR_BY_BRAND_ROUTE) {
        val brandName = call.parameters["brand_name"]
        val position = when {
            brandName.equals("BMW", true) -> 0
            brandName.equals("AUDI", true) -> 1
            brandName.equals("MERCEDES", true) -> 2
            brandName.equals("JAGUAR", true) -> 3
            else -> -1
        }

        if (position == -1) {
            call.respond(
                HttpStatusCode.NotFound,
                "No car of $brandName brand was found"
            )
        } else {
            call.respond(
                HttpStatusCode.OK,
                carList[position]
            )
        }
    }
}

// static car list
val carList = listOf(
    CarItem("BMW", "3.20", "$BASE_URL/carbrandlogos/bmw-logo.png"),
    CarItem("AUDI", "A3", "$BASE_URL/carbrandlogos/audi-logo.png"),
    CarItem("MERCEDES", "C200", "$BASE_URL/carbrandlogos/mercedes-logo.png"),
    CarItem("JAGUAR", "XE", "$BASE_URL/carbrandlogos/jaguar-logo.png"),
)