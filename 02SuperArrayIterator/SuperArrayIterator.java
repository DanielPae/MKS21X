import java.util.Iterator;
import java.util.NoSuchElementException;
public class SuperArrayIterator implements Iterator<String>{
    
    private int currentIndex;
    private SuperArray loopingThrough;
    
    public SuperArrayIterator(SuperArray sArray){
	currentIndex = 0;
	loopingThrough = sArray;
    }

    public boolean hasNext(){
	return currentIndex < loopingThrough.size();
    }

    public String next(){
	if(hasNext()){
	    currentIndex++;
	    return loopingThrough.get(currentIndex - 1);
	}else{
	    throw new NoSuchElementException();
	}
    }

    public void remove(){
	throw new UnsupportedOperationException();

    }
}
