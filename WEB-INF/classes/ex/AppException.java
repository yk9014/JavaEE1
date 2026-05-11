package ex;

public class AppException extends Exception{
    public AppException(String mess, Throwable t){
        super(mess,t);
    }

}

