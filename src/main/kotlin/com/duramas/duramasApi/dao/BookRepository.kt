package com.duramas.duramasApi.dao

import com.duramas.duramasApi.model.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository :JpaRepository<Book, Long> {

}