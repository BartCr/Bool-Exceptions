package ventouris.util;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

public class AdviceWeaver implements InvocationHandler {

    private static final List<Class<? extends Advice>> advices = Collections.singletonList(BreakExceptionsAdvice.class);

    private final Object advisedService;
    private final Object serviceImplementation;

    public AdviceWeaver(Object advisedService, Object implementation) {
        this.advisedService = advisedService;
        serviceImplementation = implementation;
    }

    public Object invoke(Object proxy, Method serviceMethod, Object[] args) throws Throwable {
        ServiceCall call = new ServiceCall(advisedService, serviceImplementation, serviceMethod, args);

        return chainAdvices().advise(call);
    }

    private Advice chainAdvices() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Advice chain = new InvocationAdvice();

        for (Class<? extends Advice> adviceClass : advices) {
            Advice advice = adviceClass.getDeclaredConstructor().newInstance();
            chain = advice.chain(chain);

        }
        return chain;
    }
}