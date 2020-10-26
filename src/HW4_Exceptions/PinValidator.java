package HW4_Exceptions;

import java.time.Instant;

public interface PinValidator {
    void setPin(String aPIN);
    int checkPIN(String aPIN) throws AccountIsLockedException;
    Instant getUnlockTime();
}
