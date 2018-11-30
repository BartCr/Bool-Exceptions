package ventouris;

import ventouris.exception.CustomException;

public interface BrokenManager {

    String doSomething(String input) throws CustomException;

    String doSomething(String input, String moreInput);

}
