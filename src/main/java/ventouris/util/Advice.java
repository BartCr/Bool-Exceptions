package ventouris.util;

public abstract class Advice {

    private Advice nextAdvice;

    protected abstract Object advise(ServiceCall call) throws Throwable;

    protected final Object yield(ServiceCall call) throws Throwable {
        return nextAdvice.advise(call);
    }

    final Advice chain(Advice nextInChain) {
        nextAdvice = nextInChain;

        return this;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();

    }
}