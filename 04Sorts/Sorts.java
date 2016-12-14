public class Sorts{
    
    public static String name(){
	return "06.Pae.Daniel";
    } 

    public static void selectionSort(int[] data){
	int toBeSwitched = 0;
	int indexToBeSwitched = 0;
	for(int start = 0; start < data.length - 1; start++){
	    toBeSwitched = data[start];
	    indexToBeSwitched = start;
	    for(int current = start + 1; current < data.length; current++){
		if(data[current] < toBeSwitched){
		    indexToBeSwitched = current;
		    toBeSwitched = data[current];
		}
	    }
	    toBeSwitched = data[start];
	    data[start] = data[indexToBeSwitched];
	    data[indexToBeSwitched] = toBeSwitched;
	}
    }

    public static void insertionSort(int[] data){
	int currentNum;
	for(int unsortedIndex = 1; unsortedIndex < data.length; unsortedIndex++){
	    currentNum = data[unsortedIndex];
	    for(int correctSpot = unsortedIndex; correctSpot >= 0; correctSpot--){
		if(correctSpot == 0 || currentNum >= data[correctSpot - 1]){
		    data[correctSpot] = currentNum;
		    correctSpot = -1;
		}else{
		    data[correctSpot] = data[correctSpot - 1];
		}
	    }
	}
    }

    public static void main(String[] args){
	int[] a = {9,8,7,6,5,4,3,2,1};
	insertionSort(a);
	for(int b : a){
	    System.out.println(b);
	}
    }
}
