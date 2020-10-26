package HW4_Exceptions;

import java.time.Instant;

public class AccountIsLockedException extends Exception{
    private Instant timeEndLocking;
    public AccountIsLockedException(Instant aTimeEndLocking){
        timeEndLocking = aTimeEndLocking;
        System.out.println("in AccountIsLockedException: " + "Account will become unlocked at " + timeEndLocking);
    }

    public Instant getTimeEndLocking(){
        return timeEndLocking;
    }
}
