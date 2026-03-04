package dao;

import bean.Book;
import java.util.List;

public interface IBookDao {
    String saveBook(Book book);
    String linkBookAuthor(int bookId, int authorId);
    List<String> getBooksByAuthorName(String name);
    String updateBookPriceByAuthor(String name, Double price);
}
