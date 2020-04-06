package app.request;

// This class handles Africa's Talking POST Request


public class USSDRequest {

    private static String sessionId = "";
    private static String serviceCode = "";
    private static String phoneNumber = "";
    private static String text = "";

    public static void setSessionId(String SessionId) {
        sessionId = SessionId;
    }

    public static void setServiceCode(String ServiceCode) {
        serviceCode = ServiceCode;
    }

    public static void setPhoneNumber(String PhoneNumber) {
        phoneNumber = PhoneNumber;
    }

    public static void setText(String Text) {
        text = Text;
    }

    private static String getSessionId() {
        return sessionId;
    }

    private static String getServiceCode() {
        return serviceCode;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static String getText() {
        return text;
    }

    public static String string() {
        return String.format("%s %s %s %s", getServiceCode(), getSessionId(), getPhoneNumber(), getText());
    }
}
