package generics;

public class ItselfReturner {
    public static <T> String convertToString(T meinObject) {
        return meinObject.toString();
    }
}
