public class Barcode implements Comparable<Barcode>{
    // instance variables
    private String _zip;
    private int _checkDigit;

    // constructors
    //precondtion: _zip.length() = 5 and zip contains only digits.
    //postcondition: throws a runtime exception zip is not the correct length
    //               or zip contains a non digit
    //               _zip and _checkDigit are initialized.
    public Barcode(String zip) {
	for(int x = 0; x < zip.length(); x++){
	    if(zip.charAt(x) < '0' || zip.charAt(x) > '9'){
		throw new IllegalArgumentException("Given zip contains a non number");
	    }
	}
	_zip = zip;
	_checkDigit = checkSum(zip);
    }

    // postcondition: Creates a copy of a bar code.
    public Barcode clone(){
	Barcode a = new Barcode(_zip);
	return a;
    }


    // postcondition: computes and returns the check sum for _zip
    private static int checkSum(String _zip){
	int ans = 0;
	for(int x = 0; x < _zip.length(); x++){
	    ans += (_zip.charAt(x) - '0');
	}
	return ans % 10;
    }

    //postcondition: format zip + check digit + Barcode 
    //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      

    private static String toBarcode(String _zip){
	String zip = _zip + checkSum(_zip);
	String ans = "|";
	for(int x = 0; x < zip.length(); x++){
	    switch(zip.charAt(x)){
	    case '0' :
		ans = ans +"||:::";
		break;
	    case '1' :
		ans = ans +":::||";
		break;
	    case '2' :
		ans = ans +"::|:|";
		break;
	    case '3' :
		ans = ans +"::||:";
		break;
	    case '4' :
		ans = ans +":|::|";
		break;
	    case '5' :
		ans = ans +":|:|:";
		break;
	    case '6' :
		ans = ans +":||::";
		break;
	    case '7' :
		ans = ans +"|:::|";
		break;
	    case '8' :
		ans = ans +"|::|:";
		break;
	    case '9' :
		ans = ans +"|:|::";
		break;
	    default :
		throw new IllegalArgumentException("zip contains a non-digit");
	    }
	}ans = ans + "|";
	return ans;
    }

    public static String toZip(String code){
	if(code.length() != 32) throw new IllegalArgumentException("Incorrect string length, sould be 32 characters");
        if(code.charAt(0) != '|' || code.charAt(31) != '|'){
	    throw new IllegalArgumentException("Start and/or end bars missing");
	}
        String ans = "";
	for(int x = 6; x < code.length(); x+=5){
	    switch(code.substring(x-5,x)){
	    case "||:::" :
		ans = ans + "0";
		break;
	    case ":::||" :
		ans = ans + "1";
		break;
	    case "::|:|" :
		ans = ans + "2";
		break;
	    case "::||:" :
		ans = ans + "3";
		break;
	    case ":|::|" :
		ans = ans + "4";
		break;
	    case ":|:|:" :
		ans = ans + "5";
		break;
	    case ":||::" :
		ans = ans + "6";
		break;
	    case "|:::|" :
		ans = ans + "7";
		break;
	    case "|::|:" :
		ans = ans + "8";
		break;
	    case "|:|::" :
		ans = ans + "9";
		break;
	    default :
		throw new IllegalArgumentException("Invalid barcode (contains invalid character or set of charaters)");
	    }
	}
	if(checkSum(ans.substring(0,5)) != ans.charAt(5) - '0'){
	    throw new IllegalArgumentException("Invalid Checksum");
	}
	return ans.substring(0,5);
    }
    
    public String toString(){
	return _zip + _checkDigit + toBarcode(_zip);
    }


    // postcondition: compares the zip + checkdigit, in numerical order. 
    public int compareTo(Barcode other){
	return _zip.compareToIgnoreCase(other._zip);
    }

    public static void main(String[] args){
	System.out.println(toBarcode("01234"));
	System.out.println(checkSum("01234"));
	System.out.println(toZip(toBarcode("01234")));
    }
}
