package HW4_Exceptions;

import java.math.BigDecimal;
import java.util.HashMap;


public class TerminalServer {
    private final PinValidatorFactory pinValidatorFactory;
    HashMap<String, Account> accountStorage =  new HashMap<>();
    HashMap<String, PinValidator> accountValidators =  new HashMap<>();

    TerminalServer(PinValidatorFactory aPinValidatorFactory){
        pinValidatorFactory = aPinValidatorFactory;
    }

    public void createAccount(String aSomeId, Long aId, String aPin, BigDecimal aMoney){
        if(accountStorage.containsKey(aSomeId)){
            String message = "Invalid account id. This id already exists.";
            throw new IllegalArgumentException(message);
        } else {
            accountStorage.put(aSomeId, new Account(aId, aPin, aMoney));
            accountValidators.put(aSomeId, pinValidatorFactory.getValidator(aPin));
        }
    }

    public boolean accountExists(String aSomeId){
        return accountStorage.containsKey(aSomeId);
    }

    public String getPin(String aSomeId) {
        return accountStorage.get(aSomeId).getPin();
    }

    public BigDecimal checkAccountStatus(String aSomeId) {
        return accountStorage.get(aSomeId).checkStatus();
    }


    public void getMoney(String aSomeId, BigDecimal aValue) throws AccountNotEnoughMoneyException, AccountWrongMoneyValueException {
        accountStorage.get(aSomeId).getMoney(aValue);
    }

    public void putMoney(String aSomeId, BigDecimal aValue) throws AccountWrongMoneyValueException {
        accountStorage.get(aSomeId).putMoney(aValue);
    }

    public int checkPIN(String aSomeId, String aPin) throws AccountIsLockedException {
        return accountValidators.get(aSomeId).checkPIN(aPin);
    }
}
