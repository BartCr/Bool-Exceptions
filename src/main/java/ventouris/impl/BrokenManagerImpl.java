package ventouris.impl;

import ventouris.BrokenManager;
import ventouris.exception.CustomException;

public class BrokenManagerImpl implements BrokenManager {

    @Override
    public String doSomething(String input) throws CustomException {
        if (input == null) {
            throw new CustomException("Input was null");
        }
        return "Handled " + input;
    }

    @Override
    public String doSomething(String input, String moreInput) {
        if (input == null) {
            throw new IllegalArgumentException("Input was null");
        }
        return "Handled " + input + " and " + moreInput;
    }

}
