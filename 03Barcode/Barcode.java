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
      _zip = zip;
      _checkDigit = checkSum() % 10;
  }

// postcondition: Creates a copy of a bar code.
  public Barcode clone(){
      Barcode a = new Barcode(_zip);
      return a;
  }


// postcondition: computes and returns the check sum for _zip
  private int checkSum(){
      int ans = 0;
      for(int x = 0; x < _zip.length(); x++){
	  ans += (_zip.charAt(x) - '0');
      }
      return ans;
  }

//postcondition: format zip + check digit + Barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      

  private String toBarcode(){
      String ans = "|";
      for(int x = 0; x < _zip.length(); x++){
	  switch(_zip.charAt(x)){
	  case '0' :
	      ans = ans +"||:::";
	  case '1' :
	      ans = ans +":::||";
	  case '2' :
	      ans = ans +"::|:|";
	  case '3' :
	      ans = ans +"::||:";
	  case '4' :
	      ans = ans +":|::|";
	  case '5' :
	      ans = ans +":|:|:";
	  case '6' :
	      ans = ans +":||::";
	  case '7' :
	      ans = ans +"|:::|";
	  case '8' :
	      ans = ans +"|::|:";
	  case '9' :
	      ans = ans +"|:|::";
	  }
      }ans = ans + "|";
      return ans;
  }
  public String toString(){
      return _zip + _checkDigit + toBarcode();
}


// postcondition: compares the zip + checkdigit, in numerical order. 
  // public int compareTo(Barcode other){}
    
}
