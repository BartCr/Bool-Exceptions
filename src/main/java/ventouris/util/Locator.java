package ventouris.util;

import ventouris.BrokenManager;
import ventouris.impl.BrokenManagerBean;

public class Locator {

    @SuppressWarnings("unchecked")
    public static <T> T locate(Class<T> aClass) {
        if (BrokenManager.class.equals(aClass)) {
            return (T) new BrokenManagerBean();
        }
        throw new IllegalArgumentException("Unknown class: " + aClass);
    }
}
