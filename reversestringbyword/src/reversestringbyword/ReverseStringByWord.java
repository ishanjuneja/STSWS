package reversestringbyword;

import java.util.regex.Pattern;

public class ReverseStringByWord {

	public static void main(String[] args) {
		System.out.println("enter string to be reversed");
		Pattern pattern;
		
		pattern=Pattern.compile(" ");
		String temp[] = pattern.split("i am ishan juneja");
		String result="";
		for (int i = 0; i < temp.length; i++) {
            if (i == temp.length - 1)
                result = temp[i] + result;
            else
                result = " " + temp[i] + result;
        }
        System.out.println(result);
    }
	}


