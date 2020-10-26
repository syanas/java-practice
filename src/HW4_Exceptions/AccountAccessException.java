package HW4_Exceptions;

public class AccountAccessException extends Exception{
    public AccountAccessException(String exceptionMsg){
        System.out.println("in AccountAccessException: " + exceptionMsg);
    }
}
