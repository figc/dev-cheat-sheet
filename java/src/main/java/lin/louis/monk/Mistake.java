package lin.louis.monk;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * That's when a monk misses a prayer...
 * <a href="http://i.imgur.com/yotLNh3.jpg">Shame! Shame! Shame!!!</a>
 *
 *
 * @author Oodrive
 * @author llin
 * @created 23/08/15 16:59
 */
@Data
public class Mistake {
    private int lineNb;
    private List<String> messages = new ArrayList<>();

    public static Mistake of(int lineNb, List<String> messages) {
        Mistake mistake = new Mistake();
        mistake.messages = messages;
        return mistake;
    }

    public static Mistake of(int lineNb, String message) {
        Mistake mistake = new Mistake();
        mistake.messages.add(message);
        return mistake;
    }

    public static Mistake of(String message) {
        Mistake mistake = new Mistake();
        mistake.messages.add(message);
        return mistake;
    }
}
