package ventouris.util;

import java.lang.reflect.InvocationTargetException;

public class InvocationAdvice extends Advice {

    @Override
    public Object advise(ServiceCall call) throws Throwable {
        try {
            return call.getMethod().invoke(call.getImplementation(), call.getArgs());
        } catch (InvocationTargetException ex) {
            throw ex.getCause();
        } catch (Exception ex) {
            throw new RuntimeException("Could not invoke service method " + call.getMethod().getName(), ex);
        }
    }
}
