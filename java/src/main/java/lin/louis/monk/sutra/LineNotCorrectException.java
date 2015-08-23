package lin.louis.monk.sutra;

/**
 * @author Oodrive
 * @author llin
 * @created 23/08/15 17:10
 */
public class LineNotCorrectException extends Exception {
    private static final long serialVersionUID = 3608477688732529802L;

    public LineNotCorrectException(String message) {
        super(message);
    }

    public LineNotCorrectException(String message, Throwable t) {
        super(message, t);
    }
}
