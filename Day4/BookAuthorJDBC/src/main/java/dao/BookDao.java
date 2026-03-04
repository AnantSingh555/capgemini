package dao;

import bean.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao implements IBookDao {
    private static Connection con;
    static{
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "Anant@123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String saveBook(Book book){
        try{
            PreparedStatement ps= con.prepareStatement("insert into book values (?,?,?)");
            ps.setInt(1, book.getISBN());
            ps.setString(2, book.getTitle());
            ps.setDouble(3, book.getPrice());
            int rows=ps.executeUpdate();
            if(rows>0){
                return "Book Created Successfully !";
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return "Book Not Created !";
    }
    @Override
    public String linkBookAuthor(int bookId, int authorId){
        try{
            PreparedStatement ps=con.prepareStatement("insert into book_author values(?,?)");
            ps.setInt(1, bookId);
            ps.setInt(2, authorId);
            int rows = ps.executeUpdate();
            if(rows>0){
                return "Book linked to author !";
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return "Link failed !";
    }
    @Override
    public List<String> getBooksByAuthorName(String name){
        List<String> list=new ArrayList<>();
        try{
            PreparedStatement ps= con.prepareStatement("select b.title from book b join book_author ba on b.ISBN=ba.bookId join author a on a.authorId=ba.authorId where a.firstName=?");
            ps.setString(1, name);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                list.add(rs.getString("title"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public String updateBookPriceByAuthor(String name, Double newPrice){
        try{
            PreparedStatement ps=con.prepareStatement("update book b join book_author ba on b.ISBN=ba.bookId join author a on a.authorId=ba.authorId set b.price=? where a.firstName=?");
            ps.setDouble(1, newPrice);
            ps.setString(2, name);
            int rows=ps.executeUpdate();
            if(rows>0){
                return "Price Updated Successfully !";
            } else{
                return "Author not found!";
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return "Update failed !";
    }

}
