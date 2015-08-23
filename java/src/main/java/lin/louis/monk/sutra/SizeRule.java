package lin.louis.monk.sutra;

import lombok.Data;

/**
 * @author Oodrive
 * @author llin
 * @created 23/08/15 17:09
 */
@Data(staticConstructor = "of")
public class SizeRule implements Rule {
    private final int size;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkLine(String line) {
        return size >= line.length();
    }

    @Override
    public String getErrorMessage(String line) {
        return String.format("The number of characters for the line '%s' exceed %d", line, size);
    }
}
