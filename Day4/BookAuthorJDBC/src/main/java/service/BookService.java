package service;

import bean.Author;
import bean.Book;
import dao.AuthorDao;
import dao.BookDao;
import dao.IAuthorDao;
import dao.IBookDao;

import java.util.List;

public class BookService implements IBookService{
    private IBookDao bookDao=new BookDao();
    private IAuthorDao authorDao=new AuthorDao();
    @Override
    public String addBookWithAuthor(Book book, Author author){
        int authorId=(int)(Math.random()*1000);
        int isbn=(int)(Math.random()*10000);
        author.setAuthorId(authorId);
        book.setISBN(isbn);
        String aResult=authorDao.saveAuthor(author);
        if(!aResult.equals("Author Created Successfully !")){
            return "Author Creation Failed !";
        }
        String bResult=bookDao.saveBook(book);
        if(!bResult.equals("Book Created Successfully !")){
            return "Book Creation Failed";
        }
        return bookDao.linkBookAuthor(isbn,authorId);
    }
    @Override
    public List<String> getBooksByAuthorName(String name){
        return bookDao.getBooksByAuthorName(name);
    }
    @Override
    public String updateBookPriceByAuthor(String name, double newPrice){
        return bookDao.updateBookPriceByAuthor(name, newPrice);
    }
}
