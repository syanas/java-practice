package HW4_Exceptions;

import java.math.BigDecimal;
import java.time.Instant;

public class Account {
    private final Long id;
    private final String pin;
    private BigDecimal money;
    private final BigDecimal roundingValue = new BigDecimal(100);


    Account(Long aId, String aPin, BigDecimal aMoney){
        id = aId;
        pin = aPin;
        money = aMoney;
    }

    String getPin(){
        return pin;
    }

    Long getId(){
        return id;
    }

    BigDecimal checkStatus(){
        return money;
    }

    void getMoney(BigDecimal aMoney) throws AccountNotEnoughMoneyException, AccountWrongMoneyValueException {
        if (money.compareTo(aMoney) == -1) throw new AccountNotEnoughMoneyException(money);
        if (aMoney.remainder(roundingValue).compareTo(BigDecimal.ZERO) != 0) throw new AccountWrongMoneyValueException(roundingValue);
        money = money.subtract(aMoney);
    }

    void putMoney(BigDecimal aMoney) throws AccountWrongMoneyValueException{
        if (aMoney.remainder(roundingValue).compareTo(BigDecimal.ZERO) != 0) throw new AccountWrongMoneyValueException(roundingValue);
        money = money.add(aMoney);
    }


}
