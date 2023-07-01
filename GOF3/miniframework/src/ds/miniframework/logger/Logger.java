package ds.miniframework.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Logger {
    private static final String LOG_FILE = "miniframework.log";
    private static Logger instance;
    private Map<PrintWriter, LogLevelEnum> writersMap;

    private Logger() {
        writersMap = new HashMap<>();
        try {
            writersMap.put(new PrintWriter(System.out), LogLevelEnum.INFO);
            writersMap.put(new PrintWriter(new FileWriter(LOG_FILE, Charset.forName("UTF8"), false)), LogLevelEnum.INFO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    /**
     * @return the writersMap
     */
    public Map<PrintWriter, LogLevelEnum> getWritersMap() {
        return writersMap;
    }

    /**
     * @param writersMap the writersMap to set
     */
    public void setWritersMap(Map<PrintWriter, LogLevelEnum> writersMap) {
        this.writersMap = writersMap;
    }

    public void log(LogLevelEnum level, String message) {
        for (Entry<PrintWriter, LogLevelEnum> entry : writersMap.entrySet()) {
            if (level.ordinal() >= entry.getValue().ordinal()) {
                entry.getKey().println(formatLogMessage(level, message));
                entry.getKey().flush();
            }
        }
    }

    private String formatLogMessage(LogLevelEnum level, String message) {
        LocalDateTime now = LocalDateTime.now();
        return "[" + now.toString() + "] [" + level.toString() + "] " + message;
    }

    public void close() {
        for (Entry<PrintWriter, LogLevelEnum> entry : writersMap.entrySet()) {
            entry.getKey().close();
        }
    }
}
