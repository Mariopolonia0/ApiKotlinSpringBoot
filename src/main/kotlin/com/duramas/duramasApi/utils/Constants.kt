package com.duramas.duramasApi.utils

class Constants {
    companion object {
        private const val URL_API_BASE = "/api"
        private const val URL_API_VERSION = "/v1"
        private const val URL_BASE = URL_API_BASE + URL_API_VERSION
        //BASE API ENDPOINT PARA BOOKS
        const val   URL_BASE_BOOKS = "$URL_BASE/books"
    }
}