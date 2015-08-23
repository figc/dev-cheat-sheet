package lin.louis.monk.fr;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lin.louis.monk.AbstractMonk;
import lin.louis.monk.Mistake;
import lin.louis.monk.Sutra;
import lin.louis.monk.sutra.AcceptedValuesRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.google.common.collect.Lists.newArrayList;
import static lin.louis.monk.Sutra.of;

/**
 * @author Oodrive
 * @author llin
 * @created 23/08/15 17:02
 */
@Service
public class FrenchMonk extends AbstractMonk {
    private static final List<Sutra> SUTRAS = new ArrayList<>();
    public static final String VERSION = "#VER13";

    static {
        SUTRAS.add(null); // First element of the list set to null in order to begin index at 1

        SUTRAS.add(of("The header of the file", newArrayList(AcceptedValuesRule.one("#HEAD"))));
        SUTRAS.add(of("The version of the file", newArrayList(AcceptedValuesRule.one("#VER13"))));
        // TODO
        SUTRAS.add(of("The footer of the file", newArrayList(AcceptedValuesRule.one("#FIN"))));
    }

    @Override
    protected String getVersion() {
        return VERSION;
    }

    @Override
    public List<Sutra> getSutras() {
        return SUTRAS;
    }
}
