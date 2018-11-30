package atomicity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StackTest {

    @Test
    void atomicity() {
        Stack<String> stack = new Stack<>();

        assertThatThrownBy(stack::pop);
        assertThatThrownBy(stack::pop);

        stack.push("test");
    }
}