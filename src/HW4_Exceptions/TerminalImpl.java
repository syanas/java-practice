package HW4_Exceptions;

import java.math.BigDecimal;

public class TerminalImpl implements Terminal{
    private final TerminalServer server;
    private final UserInfo userInfo;

    private PinValidator currentPinValidator;
    private String currentUserId = "";
    private TerminalStates state = TerminalStates.MainMenu;

    TerminalImpl(
            TerminalServer aServer,
            UserInfo aUserInfo
    ){
        this.server = aServer;
        this.userInfo = aUserInfo;
    }

    private void connectToAccount(String aSomeId) {
        try {
            if (server.accountExists(aSomeId)){
                this.currentUserId = aSomeId;
                state = TerminalStates.PinValidation;
            }
            else throw new AccountAccessException("Account doesn`t exist.");
        } catch (AccountAccessException e) {
            //e.printStackTrace();
            userInfo.getErrorInfo(ErrorTerminalStates.AccountAccessError, e.getMessage());
            state = TerminalStates.MainMenu;
        }

    }

    private void checkPIN(String aPin) {
        try {
            int res = 0;
            res = server.checkPIN(currentUserId, aPin);
            if (res == 0)
                state = TerminalStates.ChoosingTask;
            if (res == 1)
                state = TerminalStates.PinValidationError;
        } catch (AccountIsLockedException e) {
            //e.printStackTrace();
            userInfo.getErrorInfo(ErrorTerminalStates.AccountIsLockedException, e.getTimeEndLocking().toString());
            state = TerminalStates.MainMenu;
        }
    }

    private void checkAccountStatus() {
        BigDecimal money =  server.checkAccountStatus(this.currentUserId);
        this.getInfo(money.toString());
        state = TerminalStates.ChoosingTask;
    }

    private void getMoney(BigDecimal aMoney) {
        try{
            server.getMoney(this.currentUserId, aMoney );
            state = TerminalStates.ChoosingTask;
        }
        catch (AccountNotEnoughMoneyException e){
            //e.printStackTrace();
            userInfo.getErrorInfo(ErrorTerminalStates.AccountNotEnoughMoneyException, e.getMoney().toString());
            state = TerminalStates.MainMenu;
        }
        catch (AccountWrongMoneyValueException e){
            //e.printStackTrace();
            userInfo.getErrorInfo(ErrorTerminalStates.AccountWrongMoneyValueException, e.getRoundingValue().toString());
            state = TerminalStates.MainMenu;
        }

    }

    private void putMoney(BigDecimal aMoney) {
        try {
            server.putMoney(this.currentUserId, aMoney );
            state = TerminalStates.ChoosingTask;
        } catch (AccountWrongMoneyValueException e) {
            //e.printStackTrace();
            userInfo.getErrorInfo(ErrorTerminalStates.AccountWrongMoneyValueException,  e.getRoundingValue().toString());
            state = TerminalStates.MainMenu;
        }

    }

    private void processTasks(String aInput){
        switch (aInput){
            case "1":
                this.state = TerminalStates.CheckAccountStatusTask;
                this.checkAccountStatus();
                break;
            case "2":
                this.state = TerminalStates.PutMoneyTask;
                break;
            case "3":
                this.state = TerminalStates.GetMoneyTask;
                break;
            case "4":
                this.state = TerminalStates.MainMenu;
                break;
            case "5":
                this.state = TerminalStates.Exit;
                break;
            default:
                this.state = TerminalStates.MainMenu;
                break;
        }
    }

    private void chooseTaskAfterPinValidationError(String aInput){
        switch (aInput){
            case "1":
                this.state = TerminalStates.PinValidation;
                break;
            case "2":
            default:
                this.state = TerminalStates.MainMenu;
                break;
        }
    }

    @Override
    public void getInfo(){
        userInfo.getInfo(this.state, "");
    }

    public void getInfo(String aMsg){
        userInfo.getInfo(this.state, aMsg);
    }

    @Override
    public void processUserInput(String aInput){
        switch (this.state){
            case MainMenu:{
                this.connectToAccount(aInput);
                break;
            }
            case PinValidation:
                this.checkPIN(aInput);
                break;
            case PinValidationError: {
                this.chooseTaskAfterPinValidationError(aInput);
                break;
            }
            case ChoosingTask:{
                this.processTasks(aInput);
                break;
            }
            case PutMoneyTask:{
                this.putMoney(BigDecimal.valueOf(Long.parseLong(aInput)));
                break;
            }
            case GetMoneyTask:{
                this.getMoney(BigDecimal.valueOf(Long.parseLong(aInput)));
                break;
            }
            case Exit:{}
            default:
                throw new IllegalStateException("Unexpected value: " + state);
        }



    }
}
