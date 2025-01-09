abstract class Book {
    String title;
    String Author;
    Boolean isAvailable;
    Boolean isprinted;

    Book(String title, String Author, Boolean isAvailable,Boolean isprinted) {
        this.title = title;
        this.Author = Author;
        this.isAvailable = isAvailable;
        this.isprinted = isprinted;
    }

    abstract void getDetails();

    abstract void displayBookDetails(Book book);

    
}

class PrintedBook extends Book {

    PrintedBook(String title, String Author, Boolean isAvailable,Boolean isprinted) {
        super(title, Author, isAvailable,isprinted);

    }

    void getDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + Author);
    }

    
    void displayBookDetails(Book book){
        System.out.println("The title of this book is : "+book.title);
        System.out.println("The Author of the book is : "+book.Author);
        System.out.println("It is a printed book");
    }
}

class EBook extends Book {

    EBook(String title, String Author,Boolean isprinted) {
        super(title, Author, true,isprinted);

    }

    void getDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + Author);
    }

    void displayBookDetails(Book book){
        System.out.println("The title of this book is : "+book.title);
        System.out.println("The Author of the book is : "+book.Author);
        System.out.println("It is a ebook book");
    }
}

interface User {
    void borrowBook(Book book,Boolean isprinted);

    void returnBook(Book book,Boolean isprinted);

    void getBrrowedBooks();
}

class Student implements User {
    String name;
    int roll;

    Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }

    Book[] borrowedbooks = new Book[3];

    public void borrowBook(Book book,Boolean isprinted) {
        if (book.isAvailable) {

            for (int i = 0; i < borrowedbooks.length; i++) {
                if (borrowedbooks[i] == null) {

                    borrowedbooks[i] = book;

                     if(isprinted){
                        book.isAvailable = false;
                     }

                    System.out.println("Book Brrowed Successfully");

                    return;
                }
            }

            System.out.println("You already brrowed 3 books");
        }

        else{
            System.out.println("Book is not available");
        }
    }


    public void returnBook(Book book,Boolean isprinted){
        if(!book.isAvailable){
            for(int i=0; i<borrowedbooks.length; i++){
                if(borrowedbooks[i] == book){
                    borrowedbooks[i] = null;
                    book.isAvailable = true;
                    System.out.println("You return a book successfully");
                    return;
                }
            }
            System.out.println("You have not borrowed this book");
        }else{
            System.out.println("Book is already available and not borrowed by anyone");
        }
    }

    public void getBrrowedBooks(){
        for(int i=0; i<borrowedbooks.length; i++){
            if(borrowedbooks[i] != null){
                borrowedbooks[i].getDetails();
            }
        }
    }
}



class Faculty implements User{
    String name;
    int id;

    Faculty(String name,int id){
        this.name = name;
        this.id = id;
    }

    Book[] borrowedbooks = new Book[10];

    public void borrowBook(Book book,Boolean isprinted) {
        if (book.isAvailable) {

            for (int i = 0; i < borrowedbooks.length; i++) {
                if (borrowedbooks[i] == null) {

                    borrowedbooks[i] = book;

                    if(isprinted){
                        book.isAvailable = false;
                    }

                    System.out.println("Book Brrowed Successfully");

                    return;
                }
            }

            System.out.println("You already brrowed 5 books");
        }

        else{
            System.out.println("Book is not available");
        }
    }


    public void returnBook(Book book,Boolean isprinted){
        if(!book.isAvailable){
            for(int i=0; i<borrowedbooks.length; i++){
                if(borrowedbooks[i] == book){
                    borrowedbooks[i] = null;
                    book.isAvailable = true;
                    System.out.println("You return a book successfully");
                    return;
                }
            }
            System.out.println("You have not borrowed this book");
        }else{
            System.out.println("Book is already available and not borrowed by anyone");
        }
    }

    public void getBrrowedBooks(){
        for(int i=0; i<borrowedbooks.length; i++){
            if(borrowedbooks[i] != null){
                borrowedbooks[i].getDetails();
            }
        }
    }
}

public class Library {
    public static void main(String[] args) {

         PrintedBook book1 = new PrintedBook("Book1","A1",true,true);
         PrintedBook book2 = new PrintedBook("Book2","A2",true,true);
         PrintedBook book3 = new PrintedBook("Book3","A3",true,true);
         PrintedBook book4 = new PrintedBook("Book4","A4",true,true);
         PrintedBook book5 = new PrintedBook("Book5","A5",true,true);
         PrintedBook book6 = new PrintedBook("Book6","A6",true,true);
         PrintedBook book7 = new PrintedBook("Book7","A7",true,true);
         PrintedBook book8 = new PrintedBook("Book8","A8",true,true);
         PrintedBook book9 = new PrintedBook("Book9","A9",true,true);
         PrintedBook book10 = new PrintedBook("Book10","A10",true,true);


        
         
         EBook  ebook1 = new EBook("EBook1","E1",false);
         EBook  ebook2 = new EBook("EBook2","E2",false);
         EBook  ebook3 = new EBook("EBook3","E3",false);
         EBook  ebook4 = new EBook("EBook4","E4",false);
         EBook  ebook5 = new EBook("EBook5","E5",false);


         Student student1 = new Student("Mehedi", 10);
         Student student2 = new Student("Hasan",12);


         student1.borrowBook(book1,true);
         student1.borrowBook(book2,true);
         student1.borrowBook(book3,true);
         student1.borrowBook(book4,true);

         student2.borrowBook(book1,true);


         student1.returnBook(book1,true);

         student2.borrowBook(book1,true);

         student1.getBrrowedBooks();


         Faculty Faculty1 = new Faculty("David", 101);

         Faculty1.borrowBook(book5,true);
         Faculty1.borrowBook(book6,true);
         Faculty1.borrowBook(book7,true);
         Faculty1.borrowBook(book8,true);
         Faculty1.borrowBook(book9,true);
         Faculty1.borrowBook(book10,true);
         Faculty1.borrowBook(ebook1,false);
         Faculty1.borrowBook(ebook2,false);
         Faculty1.borrowBook(ebook3,false);
         Faculty1.borrowBook(ebook4,false);
         Faculty1.borrowBook(ebook5,false);

         Faculty1.getBrrowedBooks();


         book1.displayBookDetails(book1);

         ebook1.displayBookDetails(ebook1);
         

    }
}