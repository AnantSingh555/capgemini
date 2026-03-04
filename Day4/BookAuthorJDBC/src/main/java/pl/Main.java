package pl;

import bean.Author;
import bean.Book;
import service.BookService;
import service.IBookService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        IBookService service=new BookService();
        boolean running=true;
        while(running){
            System.out.println("\n ---- Book Author JDBC Application ----");
            System.out.println("1. Add Book With Author");
            System.out.println("2. Show Books by Author Name");
            System.out.println("3. Update Book Price by Author Name");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int ch=sc.nextInt();
            sc.nextLine();
            switch(ch){
                case 1:
                    System.out.print("Enter author's first name: ");
                    String firstName=sc.nextLine();

                    System.out.print("Enter author's middle name: ");
                    String middleName=sc.nextLine();

                    System.out.print("Enter author's last name: ");
                    String lastName=sc.nextLine();

                    System.out.print("Enter author's phone no.: ");
                    String phone= sc.nextLine();

                    Author author=new Author(firstName, middleName, lastName, phone);

                    System.out.print("Enter book's title: ");
                    String title=sc.nextLine();

                    System.out.print("Enter book's price: ");
                    double price=sc.nextDouble();

                    Book book=new Book(title, price);

                    String result=service.addBookWithAuthor(book, author);
                    System.out.println(result);
                    break;
                case 2:
                    System.out.print("Enter author's first name: ");
                    String name=sc.nextLine();

                    List<String> books= service.getBooksByAuthorName(name);
                    if(books.isEmpty()){
                        System.out.println("No Books Found !");
                    }else{
                        System.out.println("\nBooks written by "+ name+ " : ");
                        for(String b: books){
                            System.out.println(b);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter author's first name: ");
                    String authorName=sc.nextLine();

                    System.out.print("Enter new Price: ");
                    double newPrice=sc.nextDouble();

                    String updateResult= service.updateBookPriceByAuthor(authorName, newPrice);
                    System.out.println(updateResult);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice !");
            }


        }
        sc.close();
    }
}
