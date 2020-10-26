package HW4_Exceptions;

import java.util.Scanner;
import java.math.BigDecimal;

public class Program {

    public static void main(String[] argv){
        // Initialization
        //-------------------------------------------
        PinValidatorFactory validatorFactory = new PinValidatorFactory();
        TerminalServer server = new TerminalServer(validatorFactory);
        fillServerWithSomeData(server);

        // Init user terminal
        //-------------------------------------------
        UserInfo userInfo = new UserInfoImpl();
        Terminal terminal = new TerminalImpl(server, userInfo);

        // Usage
        //-------------------------------------------
        Scanner scanner = new Scanner(System.in);

        while (true) {
            terminal.getInfo();
            String input = scanner.nextLine();
            try{
                terminal.processUserInput(input);
            } catch (Exception e){
                System.out.println("Caught smth!");
            }

        }

    }

    private static void fillServerWithSomeData(TerminalServer aServer){
        //Account 1;
        String someId1 = "1";
        Long id1 = 1L;
        String pin1 = "0000";
        BigDecimal money1 = new BigDecimal(0);
        aServer.createAccount(someId1, id1, pin1, money1);

        //Account 2;
        String someId2 = "2";
        Long id2 = 2L;
        String pin2 = "1234";
        BigDecimal money2 = new BigDecimal(500);
        aServer.createAccount(someId2, id2, pin2, money2);

        //Account 3;
        try{
            aServer.createAccount(someId1, id2, pin2, money2);
        }
        catch (IllegalArgumentException iae){
            System.out.println("Caught!");
        }
    }

}
