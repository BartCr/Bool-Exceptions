package ventouris.util;

import java.lang.reflect.Method;

public class ServiceCall {

    private static final Object[] NO_ARGS = new Object[0];

    private Object[] args;
    private Object implementation;
    private Method method;
    private Object service;

    public ServiceCall(Object service, Object implementation, Method method, Object[] args) {
        this.service = service;
        this.implementation = implementation;
        this.method = method;
        this.args = (args == null) ? NO_ARGS : args;
    }

    public Object[] getArgs() {
        return args;
    }

    Object getImplementation() {
        return implementation;
    }

    public Method getMethod() {
        return method;
    }

    public Object getService() {
        return service;
    }

}
