package ventouris.util;

import ventouris.exception.CustomException;

public class BreakExceptionsAdvice extends Advice {
    @Override
    protected Object advise(ServiceCall call) throws Throwable {
        Throwable exceptionThrownByMethod = null;
        Object returnedObject = null;
        try {
            returnedObject = yield(call);
        } catch (RuntimeException e) {
            exceptionThrownByMethod = new CustomException(e.getMessage(), e);
        }

        if (exceptionThrownByMethod != null) {
            throw exceptionThrownByMethod;
        }
        return returnedObject;
    }

}
