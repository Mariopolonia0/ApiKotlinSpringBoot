package com.duramas.duramasApi.web

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HolaRestController {

    @RequestMapping("/")
    fun bienvenida(): String = "Ya si mario"
}