package ventouris.impl;

import ventouris.BrokenManager;
import ventouris.exception.CustomException;
import ventouris.util.AdviceWeaver;

import java.lang.reflect.Proxy;

public class BrokenManagerBean implements BrokenManager {

    @Override
    public String doSomething(String input) throws CustomException {
        return getImplementation().doSomething(input);
    }

    @Override
    public String doSomething(String input, String moreInput) {
        return getImplementation().doSomething(input, moreInput);
    }

    private BrokenManagerImpl createImplementation() {
        return new BrokenManagerImpl();
    }



    // Super class methods
    private BrokenManager advisedImplementation;

    private BrokenManager getImplementation() {
        if (advisedImplementation == null) {
            createAdvisedImplementation();
        }
        return advisedImplementation;
    }
    private void createAdvisedImplementation() {
        advisedImplementation = (BrokenManager) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                                                                       new Class[]{BrokenManager.class},
                                                                       new AdviceWeaver(this, createImplementation()));
    }
}
