package ValidateISBN;

public class ValidateISBN {
    public boolean checkISBN(String isbn) {
        int total = 0;
        int passedISBNLength = isbn.length();

        if(passedISBNLength == 10 || passedISBNLength == 13) {
            for(int i = 0; i < passedISBNLength; i++) {
                if(!Character.isDigit(isbn.charAt(i)) && i != 9) {
                    throw new NumberFormatException("ISBN numbers should be digits");
                }
                if(passedISBNLength == 10){
                    if(i == 9 && !Character.isDigit(isbn.charAt(i))){
                        total += 10;
                    } else {
                        total += Character.getNumericValue(isbn.charAt(i)) * (10 - i);
                    }
                } else {
                    if(i % 2 == 0){
                        total += Character.getNumericValue(isbn.charAt(i));
                    } else {
                        total += Character.getNumericValue(isbn.charAt(i)) * 3;
                    }
                }
            }
        } else {
            throw new NumberFormatException("ISBN number should be either 10 or 13 characters long");
        }

        if(passedISBNLength == 10){
            if(total % 11 == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            if(total % 10 == 0){
                return true;
            } else {
                return false;
            }
        }
    }
}
