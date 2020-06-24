package com.bookmanager.ws.bookservice;

import java.util.HashMap;

import com.bookmanager.ws.ui.model.request.BookDetailRequestModel;
import com.bookmanager.ws.ui.model.response.Book;

public interface BookService {

	HashMap<String, Book> getBooks(int page, int limit, String sort);
	Book getBook(String isbn);
	Book createBook(BookDetailRequestModel bookDetail);
	Book updateBook(String isbn, BookDetailRequestModel bookDetail);
	void deleteBook(String isbn);
	
}
