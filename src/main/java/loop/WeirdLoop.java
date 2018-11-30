package loop;

public class WeirdLoop {

    public String concat(String... args) {
        String result = "";
        try {
            int i =0;
            while (true)
                result += args[i++] + " ";
        } catch (ArrayIndexOutOfBoundsException ignore) {
        }
        return result;
    }
}
