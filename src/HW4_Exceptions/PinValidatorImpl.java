package HW4_Exceptions;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;

public class PinValidatorImpl implements PinValidator {
    private static final int maxAttempts = 3;
    private static final Duration lockTimeDelta = Duration.ofSeconds(5L);
    private static final Duration validatorRefreshTimeDelta = Duration.ofSeconds(30L);
    private static final Clock clock = Clock.systemDefaultZone();

    private int attemptsLeft = maxAttempts;
    private String pin = "";

    private Instant unlockTime = clock.instant();
    private Instant lastBadAttemptTime = clock.instant();

    @Override
    public void setPin(String aPin){
        pin = aPin;
    }

    @Override
    public int checkPIN(String aPin) throws AccountIsLockedException {
        Instant currentTick = clock.instant();
        boolean accountLocked = currentTick.compareTo(unlockTime) < 0;

        boolean needToRefreshAttempts = (lastBadAttemptTime.plus(validatorRefreshTimeDelta).compareTo(currentTick) <= 0);
        if (needToRefreshAttempts){
            attemptsLeft = maxAttempts;
        }

        //System.out.println("Locked:"+accountLocked + ";\tattemptsLeft:"+attemptsLeft);
        //System.out.println("needToRefreshAttempts:"+needToRefreshAttempts + ";\tlastBadAttemptTime:"+lastBadAttemptTime + ";\tcurrentTick:"+currentTick);

        if (accountLocked) {
            throw new AccountIsLockedException(unlockTime);
        }
        else {
            if (aPin.equals(pin)){
                attemptsLeft = maxAttempts;
                unlockTime = clock.instant();
                return 0;
            } else {
                attemptsLeft -= 1;
                lastBadAttemptTime = clock.instant();
                if (attemptsLeft == 0){
                    attemptsLeft = maxAttempts;
                    unlockTime = currentTick.plus(lockTimeDelta);
                    throw new AccountIsLockedException(unlockTime);
                }
                return 1;
            }
        }
    }

    @Override
    public Instant getUnlockTime() {
        return unlockTime;
    }


}
