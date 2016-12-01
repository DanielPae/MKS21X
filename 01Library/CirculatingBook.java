public class CirculatingBook extends LibraryBook{
    private String currentHolder, dueDate;

    //constructor
    public CirculatingBook(String newAuthor, String newTitle, String newISBN, String newCallNumber){
	setAuthor(newAuthor);
	setTitle(newTitle);
	setISBN(newISBN);
	setCallNumber(newCallNumber);
    }

    //getters and setters
    public String getCurrentHolder(){
	return currentHolder;
    }

    public String getDueDate(){
	return dueDate;
    }

    public void setCurrentHolder(String holder){
	currentHolder = holder;
    }

    public void setDueDate(String due){
	dueDate = due;
    }

    //Filling in abstract methods
    public void checkout(String patron, String due){
	currentHolder = patron;
	dueDate = due;
    }

    public void returned(){
	currentHolder = null;
	dueDate = null;
    }

    public String circulationStatus(){
	if(currentHolder != null){
	    return "Book has been checkedout by " + currentHolder +", and it is due back " + dueDate;
	}else{
	    return "book available on shelves";
	}
    }

    //updated toString for the current holder and due date
    public String toString(){
	if(currentHolder != null){
	    return super.toString() + ", current holder: " + currentHolder + ", due date: " + dueDate;
	}else{
	    return super.toString() + ", book avalilable on shelves";
	}
    }
}
