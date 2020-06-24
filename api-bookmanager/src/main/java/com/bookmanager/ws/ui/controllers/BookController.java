package com.bookmanager.ws.ui.controllers;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookmanager.ws.bookservice.BookService;
import com.bookmanager.ws.bookservice.impl.BookServiceImpl;
import com.bookmanager.ws.ui.model.request.BookDetailRequestModel;
import com.bookmanager.ws.ui.model.response.Book;

@RestController
@RequestMapping("/books")// http://localhost:8080/books
public class BookController {
	
	
	@Autowired
	BookService bookService;
	
	@GetMapping
	public ResponseEntity<?> getBooks(@RequestParam(value="page", defaultValue = "1") int page, 
			@RequestParam(value="limit", defaultValue = "50") int limit, 
			@RequestParam(value="sort", defaultValue = "desc", required = false) String sort) {
		return new ResponseEntity<>(bookService.getBooks(page, limit, sort), HttpStatus.OK);
		//return "retornar a coleção livros com page = "+page+" e limit = "+limit+" e sort = "+sort;
	}
	
	@GetMapping(path="/{isbn}")
	public ResponseEntity<Book> getBook(@PathVariable String isbn) {
		
		
			return new ResponseEntity<Book>(bookService.getBook(isbn), HttpStatus.OK);
		
		
		
	}
	@PostMapping
	public ResponseEntity<Book> createBook(@Valid @RequestBody BookDetailRequestModel bookDetail) {
		
		Book book = bookService.createBook(bookDetail);
		
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	@PutMapping(path="/{isbn}")
	public ResponseEntity<Book> updateBook(@PathVariable String isbn, @Valid @RequestBody BookDetailRequestModel bookDetail) {
		
		
		
		return new ResponseEntity<Book>(bookService.updateBook(isbn, bookDetail), HttpStatus.OK);
	}
	@DeleteMapping(path="/{isbn}")
	public ResponseEntity<Void> deleteBook(@PathVariable String isbn) {
		bookService.deleteBook(isbn);
		return ResponseEntity.noContent().build();
	}
}
