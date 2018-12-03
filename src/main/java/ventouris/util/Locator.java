package ventouris.util;

import ventouris.BrokenManager;
import ventouris.impl.BrokenManagerBean;
import ventouris.impl.BrokenManagerImpl;

public class Locator {

    private static boolean isRunningInTest = false;

    public static void setRunningInTest(boolean isRunningInTest) {
        Locator.isRunningInTest = isRunningInTest;
    }

    @SuppressWarnings("unchecked")
    public static <T> T locate(Class<T> aClass) {
        if (BrokenManager.class.equals(aClass)) {
            if (isRunningInTest) return (T) new BrokenManagerImpl();
            return (T) new BrokenManagerBean();
        }
        throw new IllegalArgumentException("Unknown class: " + aClass);
    }
}
