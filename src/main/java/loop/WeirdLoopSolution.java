package loop;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WeirdLoopSolution {

    public String concat(String... args) {
        return Arrays.stream(args).collect(Collectors.joining(" ", "", " "));
    }
}
