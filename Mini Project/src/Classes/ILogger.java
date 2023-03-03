package Classes;

import java.io.IOException;

public interface ILogger {
	
	enum LogLevel{
		INFO,
		ERROR
	}
	
	public void log (LogLevel level, String msg);
		
	public void Info (String msg);
	
	public void Error (String msg);
		
}
