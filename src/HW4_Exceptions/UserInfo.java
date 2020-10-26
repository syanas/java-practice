package HW4_Exceptions;

public interface UserInfo {
    void getInfo(TerminalStates aState, String aMsg);

    void getErrorInfo(ErrorTerminalStates aState, String aMsg);
}
