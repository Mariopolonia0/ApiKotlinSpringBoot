package com.duramas.duramasApi.business

import com.duramas.duramasApi.dao.BookRepository
import com.duramas.duramasApi.exception.BusinessException
import com.duramas.duramasApi.exception.NotFoundException
import com.duramas.duramasApi.model.Book
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional
import kotlin.jvm.Throws

@Service
class BookBusiness : IBookBusiness {

    @Autowired
    val bookRepository: BookRepository? = null

    @Throws(BusinessException::class)
    override fun list(): List<Book> {
        try {
            return bookRepository!!.findAll()
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class,NotFoundException::class)
    override fun load(bookId: Long): Book {
        val optional: Optional<Book>

        try {
            optional = bookRepository!!.findById(bookId)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }

        if (!optional.isPresent) {
            throw NotFoundException("No se encotro el libro con Id $bookId")
        }

        return optional.get()
    }

    @Throws(BusinessException::class)
    override fun save(book: Book): Book {
        try {
            return bookRepository!!.save(book)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class,NotFoundException::class)
    override fun remove(bookId: Long) {
        val optional: Optional<Book>

        try {
            optional = bookRepository!!.findById(bookId)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }

        if (!optional.isPresent) {
            throw NotFoundException("No se encotro el libro con Id $bookId")
        } else {
            try {
                bookRepository!!.deleteById(bookId)
            } catch (e: Exception) {
                throw BusinessException(e.message)
            }
        }
    }
}