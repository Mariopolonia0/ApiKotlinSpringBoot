package com.duramas.duramasApi.web

import com.duramas.duramasApi.business.IBookBusiness
import com.duramas.duramasApi.exception.BusinessException
import com.duramas.duramasApi.exception.NotFoundException
import com.duramas.duramasApi.model.Book
import com.duramas.duramasApi.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(Constants.URL_BASE_BOOKS)
class BookRestController {

    @Autowired
    val bookBusiness: IBookBusiness? = null

    @GetMapping("")
    fun list(): ResponseEntity<List<Book>> {
        return try {
            ResponseEntity(bookBusiness!!.list(), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") bookId: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity(bookBusiness!!.load(bookId), HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("")
    fun insert(@RequestBody book: Book): ResponseEntity<Any> {
        return try {
            bookBusiness!!.save(book)
            val responseHeader = HttpHeaders()
            responseHeader.set("location", Constants.URL_BASE_BOOKS + "/" + book.bookId)
            ResponseEntity(responseHeader, HttpStatus.CREATED)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping("")
    fun update(@RequestBody book: Book): ResponseEntity<Any> {
        return try {
            bookBusiness!!.save(book)
            ResponseEntity(HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/id")
    fun delete(@PathVariable("id") bookId: Long): ResponseEntity<Any> {
        return try {
            bookBusiness!!.remove(bookId)
            ResponseEntity(HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}