package HW4_Exceptions;

import java.math.BigDecimal;

public class AccountNotEnoughMoneyException extends Exception{
    private BigDecimal money = new BigDecimal(0);
    public AccountNotEnoughMoneyException(BigDecimal aMoney){
        money = aMoney;
        System.out.println("in AccountNotEnoughMoneyException: " + "account has only " + money);
    }
    public BigDecimal getMoney(){
        return money;
    }
}
