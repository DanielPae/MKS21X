public class Book{
    private String author, title, ISBN;
    
    public Book(String authorName, String bookTitle, String SBN){
	author = authorName;
	title = bookTitle;
	ISBN = SBN;
    }
    //Getters
    public String getAuthor(){
	return author;
    }
    public String getTitle(){
	return title;
    }
    public String getISBN(){
	return ISBN;
    }

    //Setters
    public void setAuthor(String newString){
	author = newString;
    }
    public void setTitle(String newString){
	title = newString;
    }
    public void setISBN(String newString){
	ISBN = newString;
    }
    
    //To make printing easier
    public String toString(){
	return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN;
    }

    //to test this stuff
    /*public static void main(String[] args){
	Book a = new Book("Me", "Jibirish", "0001");
	System.out.println(a.getTitle());
    }
    */
}
