package loop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeirdLoopTest {

    @Test
    void concat() {
        WeirdLoop weirdLoop = new WeirdLoop();
        Assertions.assertThat(weirdLoop.concat("Hello", "Exceptions")).isEqualTo("Hello Exceptions ");
    }
}