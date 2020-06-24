package com.bookmanager.ws.bookservice.impl;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.bookmanager.ws.bookservice.BookService;
import com.bookmanager.ws.ui.model.request.BookDetailRequestModel;
import com.bookmanager.ws.ui.model.response.Book;

@Service
public class BookServiceImpl implements BookService{
	
	HashMap<String, Book> books;
	
	public HashMap<String, Book> getBooks(int page, int limit, String sort){
		return books;
	}
	public Book getBook(String isbn) {
		return books.get(isbn);
	}
	
	@Override
	public Book createBook(BookDetailRequestModel bookDetail) {
		Book book = new Book();
		book.setTitle(bookDetail.getTitle());
		book.setAuthor(bookDetail.getAuthor());
		book.setImageUrl(bookDetail.getImageUrl());
		book.setIsbn(bookDetail.getIsbn());
		
		if(books == null) {
			books = new HashMap<>();
		}
		books.put(book.getIsbn(), book);
		
		return book;
	}

	public Book updateBook(String isbn, BookDetailRequestModel bookDetail) {
		
		Book book = books.get(isbn);
		book.setTitle(bookDetail.getTitle());
		book.setAuthor(bookDetail.getAuthor());
		book.setImageUrl(bookDetail.getImageUrl());
		book.setIsbn(bookDetail.getIsbn());
		return book;
	}
	public void deleteBook(String isbn) {
		books.remove(isbn);
	}
}
