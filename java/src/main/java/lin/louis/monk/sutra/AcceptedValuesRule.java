package lin.louis.monk.sutra;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * @author Oodrive
 * @author llin
 * @created 23/08/15 17:15
 */
@Data
public class AcceptedValuesRule implements Rule {
    private List<String> values = new ArrayList<>();

    public static AcceptedValuesRule of(List<String> values) {
        AcceptedValuesRule rule = new AcceptedValuesRule();
        rule.values = values;
        return rule;
    }

    public static AcceptedValuesRule one(String value) {
        AcceptedValuesRule rule = new AcceptedValuesRule();
        rule.values.add(value);
        return rule;
    }

    @Override
    public boolean checkLine(String line) {
        return values.contains(line);
    }

    @Override
    public String getErrorMessage(String line) {
        return String.format("The line '%s' is not correct. Accepted values: %s", line, values);
    }
}
