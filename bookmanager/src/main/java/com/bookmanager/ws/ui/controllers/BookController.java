package com.bookmanager.ws.ui.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public String getBook(@PathVariable String isbn) {
		return "retornar o livro específico com o isbn = "+isbn;
	}
	@PostMapping
	public String createBook() {
		return "Criar um novo livro";
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
