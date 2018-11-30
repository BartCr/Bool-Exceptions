package ventouris;

import ventouris.exception.CustomException;

import java.util.ArrayList;
import java.util.List;

import static ventouris.util.Locator.locate;

public class MyCoolService {

    public List<String> doWork(List<String> work) {
        BrokenManager brokenManager = locate(BrokenManager.class);

        List<String> errors = new ArrayList<>();
        work.forEach(w -> {
            try {
                brokenManager.doSomething(w);
            } catch (CustomException e) {
                errors.add(w);
            }
        });
        return errors;
    }
}
