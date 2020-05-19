package com.bookmanager.ws.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.URL;

public class BookDetailRequestModel {
	@NotNull(message="o campo título deve ser preenchido")
	@Size(min=3, max=255)
	private String title;
	@NotNull(message="o campo autor deve ser preenchido")
	@Size(min=3, max=255)
	private String author;
	@URL
	private String imageUrl;
	@NotNull(message="o campo isbn deve ser preenchido")
	@ISBN(message="isbn inválido")
	private String isbn;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
}
