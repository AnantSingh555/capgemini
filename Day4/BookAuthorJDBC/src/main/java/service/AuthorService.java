package service;

import bean.Author;
import dao.AuthorDao;
import dao.IAuthorDao;

public class AuthorService implements IAuthorService{
    private IAuthorDao dao= new AuthorDao();
    @Override
    public String addAuthor(Author author){
        int id=(int)(Math.random()*1000);
        author.setAuthorId(id);
        return dao.saveAuthor(author);
    }
}
