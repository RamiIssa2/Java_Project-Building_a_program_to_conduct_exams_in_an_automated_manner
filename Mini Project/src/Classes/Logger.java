package Classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

public class Logger implements ILogger {

    private File Logs;;
	
    public Logger(File Logs) {
	this.Logs = Logs;
    }
	
    @Override
    public void log (LogLevel level, String msg){
    	switch (level) {
    	case INFO:
    		Info(msg);
    		break;
    	case ERROR:
    		Error(msg);
    		break;
    	}
    }
	
    public String time() {
    	Date date = new Date();
    	SimpleDateFormat d= new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
    	String s = d.format(date);
    	return s;
    }
	
    @Override
    public void Info (String msg){
    	BufferedWriter bw = null;
        try {
            if (!Logs.exists()){
                Logs.createNewFile();
            }
            bw = new BufferedWriter(new FileWriter(Logs, true));
            bw.write("[INFO, " + time() + "]: " + msg + "\n\n");
            bw.close();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
    @Override
    public void Error (String msg){
	BufferedWriter bw = null;
        try {
            if (!Logs.exists()){
                Logs.createNewFile();
            }
            bw = new BufferedWriter(new FileWriter(Logs, true));
            bw.write("[ERROR, " + time() + "]: " + msg + "\n\n");
            bw.close();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
}
