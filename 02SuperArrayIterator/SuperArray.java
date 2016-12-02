public class SuperArray implements Iterable<String>{
    private String[] data;
    private int size;
  
    //0
    //constructor make an empty superArray should make size 0, 
    //but the data capacity 10.
    public SuperArray(){
	String[] arr = new String[10];
	data = arr;
	size = 0;
    }
    public SuperArray(int x){
	if(x < 0) {
	    throw new IllegalArgumentException("Cannot construct an array with a negative size");
	}
	String[] arr = new String[x];
	data = arr;
	size = 0;
    }

    public int size(){
	return size;
    }

    public void trimToSize(){
	String[] temp = new String[size];
	for(int x = 0; x < size; x++){
	    temp[x] = data[x];
	}data = temp;
    }
    
    //1
    /**add the value n to the next available slot in the superArray.
     *this will change the size. This function should always work
     *And will resize the SuperArray if needed.*/
    public boolean add(String n){
	if(data.length == size) this.grow();
	data[size] = n;
	size++;
	return true;
    }

    //2
    /**Resize the data, by making a new array, then copying over elements, use this as your data.
     */

    private void grow(){
	String[] temp = new String[size + 1];
	for(int x = 0; x < data.length; x++){
	    temp[x] = data[x];
	}data = temp;
    }

    //3
    /**format the super array like this :   [ 1, 3, 6, 8, 23, 99, -4, 5] 
     *commas between... square bracket start/end and no comma at end.*/
    public String toString(){
	if(size == 0) return "empty array";
	String temp = "[ "+ data[0];
	for(int x = 1; x < size; x++){
	    temp = temp + ", " + data[x];
	}temp = temp + "]";
	return temp;
    }

    //4
    /**format the super array like this :   [ 1, 8, 23, 99, -4, 5, _, _, _, _]   
     *(capacity is 10, but only 6 are used)
     *commas between... square bracket start/end and no comma at end.
     *unused slots should be printed as _ (underscores) */
    public String toStringDebug(){
	String temp = "[ ";
	for(int x = 0; x < size; x++){
	    temp = temp + ", " + data[x];
	}
	for(int x = size; x < data.length; x++){
	    temp = temp + "_, ";
	}
	temp = temp + "]";
	return temp;
    }
    
    // returns the element at the specified index
    public String get(int index){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	return data[index];
    }

    // Removes all of the elements from this list.
    public void clear(){
	size = 0;
    }

    // Returns true if this list contains no elements.
    public boolean isEmpty(){
	return size == 0;
    }

    // Replaces the element at the specified position in this list with the specified element. Returns the value of the
    // element replaced. 
    public String set(int index, String element){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException("Cannot set to a negative index or a index >= size");
	}
	String x = data[index];
	data[index] = element;
	return x;
    }

    // Inserts the specified element at the specified position in this list. Shifts the element currently at that
    // position (if any) and any subsequent elements to the right (adds one to their indices).
    public void add(int index, String element){
       	if(index < 0 || index > size){
	    throw new IndexOutOfBoundsException(index + this.size() +"");
	}	
	if (size == index){
	    if(data.length == size) this.grow();
	    data[size] = element;
	    size ++;
	}
	else{
	    String[] temp = new String[size + 1];
	    int y = 0;
	    for(int x = 0; x < this.size(); x++){
		if(index == y){
		    temp[y] = element;
		    x -= 1;
		}else {
		    temp[y] = data[x];
		}
		y++;
	    }size += 1;
	    data = temp;}
    }

    //Removes the element at the specified position in this list. Shifts any subsequent elements to the left
    //(subtracts one from their indices). The value returned is the value of the element removed.
    public String remove(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	String[] temp = new String[size + 1];
	int y = 0;
	String ans = "";
	for(int x = 0; x < data.length; x++){
	    if(index == y){
		ans = data[x];
		x += 1;
	    }
	    temp[y] = data[x];
	    y++;
	}data = temp;
	size -= 1;
	return ans;
    }
    
    //Returns an array containing all of the elements in this list in proper sequence (from first to last element).
    public String[] toArray(){
	String[] temp = new String[size];
	for(int x = 0; x < temp.length; x++){
	    temp[x] = data[x];
	}return temp;
    }
    
    //Returns the index of the first occurrence of the specified element in this list, or -1 if this list does
    //not contain the element.
    public int indexOf(String i){
	for(int x = 0; x < data.length; x++){
	    if(i.equals(data[x])) return x;
	}return -1;
    }

    //Returns the index of the last occurrence of the specified element in this list, or -1 if this list does
    //not contain the element.
    public int lastIndexOf(String i){
	for(int x = data.length - 1; x > 0; x -= 1){
	    if(i.equals(data[x])) return x;
	}return -1;
    }

    public SuperArrayIterator iterator(){
	return new SuperArrayIterator(this);
    }
    

	
    public static void main(String[] args){
	SuperArray x = new SuperArray(10);
	x.add("then");
	x.add(0,"a");
	x.add("b");
	x.add("c");
	x.add("d");
	x.add("e");
	x.add("f");
	x.add("g");
	x.add("h");
	x.add("i");
	x.add("j");
	x.add("k");
	x.add("l");
	System.out.println(x.get(0));
	System.out.println(x.isEmpty());
	System.out.println(x.set(5,"z"));
	System.out.println(x);
	x.add(5, "y");
	System.out.println(x);
	System.out.println(x.remove(5));
	System.out.println(x);
	System.out.println(x.toArray());
	System.out.println(x.indexOf("a"));
	System.out.println(x.lastIndexOf("f"));
	
    }
}
