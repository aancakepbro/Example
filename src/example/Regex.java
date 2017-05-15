/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lainc
 */
public class Regex {
    
    static Map<String, String> dateRegex = new HashMap<>();
    static {
        dateRegex.put("yyyy/MM/dd", "((?:19|20)\\d\\d)/(0?[1-9]|1[012])/([12][0-9]|3[01]|0?[1-9])");
        dateRegex.put("yyyy-MM-dd", "((?:19|20)\\d\\d)-(0?[1-9]|1[012])-([12][0-9]|3[01]|0?[1-9])");
        dateRegex.put("yyyy-MM-dd HH:mm:ss", "((?:19|20)\\d\\d)-(0?[1-9]|1[012])-([12][0-9]|3[01]|0?[1-9]) (?:[01]\\d|2[0123]):(?:[012345]\\d):(?:[012345]\\d)");
        dateRegex.put("yyyy-MM-dd HH:mm", "((?:19|20)\\d\\d)-(0?[1-9]|1[012])-([12][0-9]|3[01]|0?[1-9]) (?:[01]\\d|2[0123]):(?:[012345]\\d)");

        
    }
    
    public static void main(String [] agrs){
            String format = "yyyy/MM/dd";
            String regex = dateRegex.get(format);
            System.out.println(regex);
            System.out.println("==============================================================="); 
            isValidRegex("2010/10/12", regex);
            isValidRegex("2010/10/12 ", regex);
            isValidRegex(" 2010/10/12", regex);
            isValidRegex("2010/10/12 10:10:00", regex);
            isValidRegex("2010/10/123", regex);
            isValidRegex("2010/00/12", regex);
            isValidRegex("2010-00-12", regex);
            isValidRegex("20-10-12", regex);
            System.out.println("===============================================================");
            
            format = "yyyy-MM-dd";
            regex = dateRegex.get(format);
            System.out.println(regex);
            System.out.println("===============================================================");
            isValidRegex("1901-10-12", regex);
            isValidRegex("2011-10-12", regex);
            isValidRegex("2010/00/12", regex);
            isValidRegex("201-10-12", regex);
            isValidRegex("2010-10-12 10:10:00", regex);
            isValidRegex("2010-00-12", regex);
            isValidRegex("20-10-12", regex);
            System.out.println("===============================================================");
            
            format = "yyyy-MM-dd HH:mm:ss";
            regex = dateRegex.get(format);
            System.out.println(regex);
            System.out.println("===============================================================");
            isValidRegex("1901-10-12 00:00:00", regex);
            isValidRegex("1901-10-12 00:00:60", regex);
            isValidRegex("1901-10-12 12:30:59", regex);
            isValidRegex("1901-10-12 23:59:59", regex);
            isValidRegex("1901-10-12 24:30:59", regex);
            isValidRegex("1901-10-12 0:30:59", regex);
            System.out.println("===============================================================");
            
            
            format = "yyyy-MM-dd HH:mm";
            regex = dateRegex.get(format);
            System.out.println(regex);
            System.out.println("===============================================================");
            isValidRegex("1901-10-12 00:00", regex);
            isValidRegex("1901-10-12 12:59", regex);
            isValidRegex("1901-10-12 00:60", regex);
            isValidRegex("1901-10-12  00:59", regex);
            isValidRegex("1901-10-12 00:59 ", regex);
            isValidRegex("1901-10-12 12:3", regex);
            isValidRegex("1901-10-12 3:59", regex);
            isValidRegex("1901-10-12 24:30:59", regex);
            isValidRegex("1901-10-12 0:30:59", regex);
            System.out.println("===============================================================");
                
    }
    
    public static boolean isValidRegex(String data, String regex){
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(data);
        System.out.println(data+"|"+regex+" "+matcher.matches());
        return matcher.matches();
    }
    
}
