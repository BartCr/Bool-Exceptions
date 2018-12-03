package ventouris;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ventouris.exception.CustomException;
import ventouris.util.Locator;

import static ventouris.util.Locator.locate;

class BrokenManagerTest {

    private BrokenManager brokenManager;

    @BeforeEach
    void setUp() {
        Locator.setRunningInTest(true);
        brokenManager = locate(BrokenManager.class);
    }

    @AfterEach
    void tearDown() {
        Locator.setRunningInTest(false);
    }

    @Test
    void doSomething_with_null_Input() {
        try {
            brokenManager.doSomething(null);
            Assertions.fail(CustomException.class + " expected");
        } catch (CustomException ignore) {
            // TEST OK: exception expected
        }
    }

    @Test
    void doSomething_with_null_Input_and_moreInput() {
        try {
            brokenManager.doSomething(null, null);
            Assertions.fail(IllegalArgumentException.class + " expected");
        } catch (IllegalArgumentException ignore) {
            // TEST OK: exception expected
        }
    }
}