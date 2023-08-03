package Exceptions.Seminar_03;

public class WrongLengthStringException extends StringIndexOutOfBoundsException{
    private int length;

    public WrongLengthStringException(String message, int length){
        super(message);
        this.length = length;
    }

    public int getLength(){
        return this.length;
    }
}
