package lin.louis.monk;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Oodrive
 * @author llin
 * @created 23/08/15 16:58
 */
@Data
@Accessors(chain = true)
public class PrayerResult {
    private List<Mistake> mistakeList = new ArrayList<>();

    public PrayerResult addMistake(Mistake error) {
        mistakeList.add(error);
        return this;
    }
}
