package ventouris;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class MyCoolServiceTest {

    @Test
    void doTest() {
        MyCoolService myCoolService = new MyCoolService();

        List<String> result = myCoolService.doWork(Arrays.asList("a", "b", null, "c"));

        Assertions.assertThat(result)
                  .hasSize(1)
                  .containsOnlyNulls();
    }

}