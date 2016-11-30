public class LibraryBook extends Book implements Comparable{
    private String callNumber;
    
    public LibraryBook(String authorn, String titlen, String ISBNN, String callNumbern){
	setAuthor(authorn);
	setTitle(titlen);
	setISBN(ISBNN);
	callNumber = callNumbern;
    }

    //getters and setters
    public String getCallNumber(){
	return callNumber;
    }
    public void setCallNumber(String newCallNumber){
	callNumber = newCallNumber;
    }

    //abstract methods
    abstract void checkout(String patron, String due);
    abstract void returned();
    abstract String circulationStatus();

    //To make comparable work.
    //compares by callNumber, returns >0 if this is greater than the given.
    //Returns 0 if equal
    //returns <0 if this is less than the given
    public int compareTo(LibraryBook comp){
	return comp.callNumber - callNumber;
    }

    public String toString(){
	return super.toString(this) + ", call number: " + callNumber;
    }
    
}
