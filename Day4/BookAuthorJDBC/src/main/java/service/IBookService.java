package service;

import bean.Author;
import bean.Book;

import java.util.List;

public interface IBookService {
    String addBookWithAuthor(Book book, Author author);
    List<String> getBooksByAuthorName(String name);
    String updateBookPriceByAuthor(String name, double newPrice);
}
