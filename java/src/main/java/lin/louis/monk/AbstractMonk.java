package lin.louis.monk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Oodrive
 * @author llin
 * @created 23/08/15 17:47
 */
public abstract class AbstractMonk implements Monk {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractMonk.class);

    protected abstract String getVersion();
    protected abstract List<Sutra> getSutras();

    /**
     * {@inheritDoc}
     */
    @Override
    public PrayerResult pray(InputStream in) {
        PrayerResult result = new PrayerResult();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(in));
            String line;

            int lineNb = 1;
            while ((line = br.readLine()) != null) {
                if (startOfFile(line)) {
                    continue;
                }
                if (endOfFile(line)) {
                    // No need to parse the rest
                    break;
                }
                if (isVersion(line)) {
                    Optional<Mistake> mistake = isVersionCorrect(line);
                    mistake.ifPresent(result::addMistake);
                }

                try {
                    Optional<Mistake> mistake = doPray(lineNb, line);
                    mistake.ifPresent(result::addMistake);
                } catch (Exception e) {
                    LOGGER.error(e.getMessage(), e);
                    result.addMistake(Mistake.of(lineNb, String.format("Error in line '%s'. Error was: %s", line, e.getMessage())));
                }

                lineNb++;
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            result.addMistake(Mistake.of(e.getMessage()));
        } finally {
            IOUtils.closeQuietly(br);
        }

        return result;
    }

    private boolean startOfFile(String line) {
        // FIXME: Set real header
        return "#HEAD".equals(line);
    }

    private boolean endOfFile(String line) {
        return "#FIN".equals(line);
    }

    private boolean isVersion(String line) {
        return line.startsWith("#VER");
    }

    private Optional<Mistake> isVersionCorrect(String line) {
        if (getVersion().equals(line)) {
            return Optional.empty();
        }
        return Optional.of(Mistake.of(String.format("The version of the ACCOUNT_XXX.txt for FR should be %s", getVersion())));
    }

    private Optional<Mistake> doPray(int lineNb, String line) {
        Optional<Sutra> sutra = getSutra(lineNb);
        List<String> errorList = new ArrayList<>();

        if (sutra.isPresent()) {
            sutra.ifPresent(s -> {
                List<String> lineErrors = s.check(line);
                if (CollectionUtils.isNotEmpty(lineErrors)) {
                    errorList.addAll(lineErrors);
                }
            });

            if (CollectionUtils.isNotEmpty(errorList)) {
                return Optional.of(Mistake.of(lineNb, errorList));
            }
        } else {
            return Optional.of(Mistake.of(lineNb, String.format("No sutra found for line %d", lineNb)));
        }
        return Optional.empty();
    }

    private Optional<Sutra> getSutra(int lineNb) {
        return Optional.ofNullable(getSutras().get(lineNb));
    }
}
