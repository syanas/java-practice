package HW4_Exceptions;

public class UserInfoImpl implements UserInfo {

    @Override
    public void getInfo(TerminalStates aState, String aMsg){
        switch (aState){
            case MainMenu:{
                System.out.println("Enter your cardId:");
                break;
            }
            case PinValidation:{
                System.out.println("Enter your PIN code:");
                break;
            }
            case PinValidationError:{
                System.out.println("Wrong PIN code.");
                System.out.println("Enter your command:");
                System.out.println("1 - 'retry and enter PIN code';");
                System.out.println("2 - 'main menu';");
                break;
            }
            case ChoosingTask:{
                System.out.println("Enter your command:");
                System.out.println("1 - 'check account';");
                System.out.println("2 - 'put money';");
                System.out.println("3 - 'get money';");
                System.out.println("4 - 'main menu';");
                System.out.println("5 - 'exit';");
                break;
            }
            case CheckAccountStatusTask:
                System.out.println("Money: " + aMsg);
                break;
            case PutMoneyTask:
            case GetMoneyTask:{
                System.out.println("Enter amount of money:");
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + aState);
        }

    }

    @Override
    public void getErrorInfo(ErrorTerminalStates aState, String aMsg){
        switch (aState){
            case AccountAccessError:{
                System.out.println("Your cardId is not registered in system. Please, visit our office.");
                break;
            }
            case AccountIsLockedException:{
                System.out.println("Your account is locked. It will be unlocked at " + aMsg);
                break;
            }
            case AccountNotEnoughMoneyException:{
                System.out.println("You have got only " + aMsg);
                break;
            }
            case AccountWrongMoneyValueException:{
                System.out.println("Amount of money should be multiple of " + aMsg);
                break;
            }
        }

    }
}
