package Exceptions.Seminar_03;

public class WrongCountParamsException extends RuntimeException{
    private int count;

    public WrongCountParamsException(String message, int count){
        super(message);
        this.count = count;
    }

    public int getCount(){
        return this.count;
    }
}
