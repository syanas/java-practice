package HW4_Exceptions;

public class PinValidatorFactory {
    public PinValidatorImpl getValidator(String aPIN){
        PinValidatorImpl pinVal = new PinValidatorImpl();
        pinVal.setPin(aPIN);
        return pinVal;
    }
}
