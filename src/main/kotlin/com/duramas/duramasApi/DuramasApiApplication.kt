package com.duramas.duramasApi


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.sql.DriverManager


@SpringBootApplication
class DuramasApiApplication

fun main(args: Array<String>) {
    runApplication<DuramasApiApplication>(*args)
}

//http://localhost:8080/