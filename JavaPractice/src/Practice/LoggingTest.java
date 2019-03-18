package Practice;

import java.util.logging.*;

public class LoggingTest {
	public static void main(String[] args) {
		//The basic example of set up a logging environment
		// 1. Create a logger
		Logger logger = Logger.getLogger("mylogger");
		logger.setLevel(Level.ALL);
		// 2. Create a handler
		Handler handler = new ConsoleHandler();
		handler.setLevel(Level.ALL);
		// 3. Define formatter and filter
		Formatter formatter = new Formatter() {
			@Override
			public String format(LogRecord record) {
				return record.getLevel() + ":" + record.getMessage() + "\n";
			}
		};
		// 4. Add formatter and filter to handler
		handler.setFormatter(formatter);
		// 5. Add handler to logger
		logger.addHandler(handler);
		// 6. Use logger
		logger.info("Test Message.");
	}
}
