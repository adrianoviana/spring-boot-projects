package com.bookmanager.ws.ui.controllers;

import javax.validation.Valid;

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

import com.bookmanager.ws.ui.model.request.BookDetailRequestModel;
import com.bookmanager.ws.ui.model.response.Book;

@RestController
@RequestMapping("/books")// http://localhost:8080/books
public class BookController {
	
	@GetMapping
	public String getBooks(@RequestParam(value="page", defaultValue = "1") int page, 
			@RequestParam(value="limit", defaultValue = "50") int limit, 
			@RequestParam(value="sort", defaultValue = "desc", required = false) String sort) {
		return "retornar a coleção livros com page = "+page+" e limit = "+limit+" e sort = "+sort;
	}
	
	@GetMapping(path="/{isbn}")
	public ResponseEntity<Book> getBook(@PathVariable String isbn) {
		
		Book book = new Book();
		book.setTitle("Clean Code");
		book.setAuthor("Robert C. Martin");
		book.setImageUrl("http://localhost/image");
		
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Book> createBook(@Valid @RequestBody BookDetailRequestModel bookDetail) {
		Book book = new Book();
		book.setTitle(bookDetail.getTitle());
		book.setAuthor(bookDetail.getAuthor());
		book.setImageUrl(bookDetail.getImageUrl());
		book.setIsbn(bookDetail.getIsbn());
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	@PutMapping
	public String updateBook() {
		return "Atualizar as informações de um determinado livro";
	}
	@DeleteMapping
	public String deleteBook() {
		return "deletar um livro cadastrado";
	}
}
