package lin.louis.monk;

import java.util.ArrayList;
import java.util.List;

import lin.louis.monk.sutra.Rule;
import lombok.Data;

/**
 * @author Oodrive
 * @author llin
 * @created 23/08/15 16:56
 */
@Data(staticConstructor = "of")
public class Sutra {
    private final String description;
    private final List<Rule> ruleList;

    public List<String> check(String line) {
        List<String> mistakes = new ArrayList<>();
        ruleList.stream()
                .forEach(rule -> {
                    if (!rule.checkLine(line)) {
                        mistakes.add(rule.getErrorMessage(line));
                    }
                });

        return mistakes;
    }
}
