package HW4_Exceptions;

import java.math.BigDecimal;

public class AccountWrongMoneyValueException extends Exception {
    private BigDecimal roundingValue = new BigDecimal(0);
    public AccountWrongMoneyValueException(BigDecimal aRoundingValue){
        roundingValue = aRoundingValue;
        System.out.println("in AccountWrongMoneyValueException: " + "value should be divisible by " + roundingValue);
    }
    public BigDecimal getRoundingValue(){
        return roundingValue;
    }
}
