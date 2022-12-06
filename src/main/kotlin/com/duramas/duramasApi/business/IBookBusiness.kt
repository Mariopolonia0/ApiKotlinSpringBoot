package com.duramas.duramasApi.business

import com.duramas.duramasApi.model.Book


interface IBookBusiness {
    fun list(): List<Book>
    fun load(bookId: Long): Book
    fun save(book: Book): Book
    fun remove(bookId: Long)
}