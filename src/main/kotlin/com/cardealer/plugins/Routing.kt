package com.cardealer.plugins

import com.cardealer.routes.getCarByBrand
import com.cardealer.routes.getCars
import com.cardealer.routes.index
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        index()
        getCars()
        getCarByBrand()
        // Static plugin. Try to access `/static/index.html`
        static {
            resources("static")
        }
    }
}