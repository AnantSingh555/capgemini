package dao;

import bean.Author;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorDao implements IAuthorDao{
    private static Connection con;
    static{
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "pass");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String saveAuthor(Author author){
        try{
            PreparedStatement ps=con.prepareStatement("insert into author values (?,?,?,?,?)");
            ps.setInt(1, author.getAuthorId());
            ps.setString(2, author.getFirstName());
            ps.setString(3, author.getMiddleName());
            ps.setString(4, author.getLastName());
            ps.setString(5, author.getPhoneNo());
            int rows=ps.executeUpdate();
            if(rows>0){
                return "Author Created Successfully !";
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return "Author not created !";
    }
}

