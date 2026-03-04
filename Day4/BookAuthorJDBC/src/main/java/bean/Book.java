package bean;

public class Book {
    private int ISBN;
    private String title;
    private double price;

    public Book(){}

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "ISBN:" + ISBN +
                "/nTitle" + title +
                "/nPrice" + price;
    }
}
