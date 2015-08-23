package lin.louis.monk.sutra;

/**
 * @author Oodrive
 * @author llin
 * @created 23/08/15 17:09
 */
public interface Rule {
    boolean checkLine(String line);

    String getErrorMessage(String line);
}
