package com.pluralsight.calcengine;

import org.w3c.dom.ls.LSOutput;

public class WorkingWithStrings {
    public static void main(String[] args) {
        String name = "Jim";
        String greeting = "Hello " + name;
        System.out.println(greeting);

        greeting += " good to see you!";
        System.out.println(greeting);

// The String variable message does not directly hold the value "I"
        //It holds what's known as a reference to the value - 10/02/23
        String message = "I";
        message += " Love";
        message += " Java";


        String s1 = "I love";
        s1 += " Java";
        String s2 = "I";
        s2 += " love Java";

        if(s1.equals(s2)) {
            System.out.println("These two strings are equivalent");
        }
        String s3 = s1.intern();
        String s4 = s2.intern();

        if(s3 == s4) {
            System.out.println("These two strings are equivalent");
        }
// Converting Non-String types to String
        int iVal = 100;
        String sVal = String.valueOf(iVal);

        int i = 2, j = 3;
        int result = i * j;

        String output = i + " * " + j + " = " + result;
        System.out.println(output);

        //StringBuilder class - 10/02/23
        String location = "Florida";
        int flightNumber = 175;
        String time = "9:00";

// Order matters!! Make sure to add any modifications to the end of the StringBuilder code block
        StringBuilder sb = new StringBuilder(40);
        sb.append("I flew to ");
        sb.append(location);
        sb.append(" on Flight #");
        sb.append(flightNumber);
        int pos = sb.indexOf(" on");
        sb.insert(pos, " at ");
        sb.insert(pos + 4, time);

        String message1 = sb.toString();
        System.out.println(message1);
    }

}
