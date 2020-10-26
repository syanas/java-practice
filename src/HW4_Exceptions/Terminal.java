package HW4_Exceptions;

public interface Terminal {
    void getInfo();
    void processUserInput(String aInput);

}

//    //0) Получение аккаунта
//    //   Проверка корректности ввода пина
//    void connectToAccount(String aSomeId) throws AccountAccessException;
//    void validatePin(String aPin);
//
//    //1) Проверить состояние счета
//    Double checkAccountStatus();
//
//    //2) Снять / положить деньги
//    Boolean getMoney();
//    void putMoney();
//
////