package Exceptions.Seminar_03;

import java.text.ParseException;

public class ParsePersonException extends ParseException{
    public ParsePersonException(String  message, int index) {
        super(message, index);
    }
}
