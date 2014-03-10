/**
 * Used to write log entries to a log textfile
 */

package dejan.arqtest3.log;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LogWriter {
    private static final String LOGFILE_NAME = "systemlog.txt";
    private static final String DATETIME_FORMAT = "yyyy/MM/dd HH:mm:ss";
    private FileWriter fileWriter;
    private SimpleDateFormat sdf;
    private Date date = new Date();
    
    @PostConstruct
    public void init()
    {
        System.err.println("LogWriter PostConstruct! "+this);
        
        sdf = new SimpleDateFormat(DATETIME_FORMAT);
        try {
            fileWriter = new FileWriter(LOGFILE_NAME);
            System.err.println("LogWriter created filewriter!");
        } catch(IOException e) {
            System.err.println("LogWriter logfile creation error!");
            e.printStackTrace();
        }
    }
    
    /**
     * Performs cleanup before destruction of bean.
     */
    @PreDestroy
    public void atPreDestroy()
    {
        System.err.println("LogWriter PreDestroy!");
        if(fileWriter != null) {
            
            try {
                fileWriter.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void LogWriter() {
        System.err.println("LogWriter Constructor! "+this);
        
    }
    /**
     * Writes log entry to text file. Adds date and time to beginning of the string
     * which is supplied as argument.
     * @param entry String that is to be logged.
     */
    void writeEntry(String entry) 
    {
        long epoch = Calendar.getInstance().getTimeInMillis();
        String dateStr = sdf.format(new Date());
        try {
            fileWriter.write("TIME: " + dateStr + " METHOD CALL: " + entry + System.lineSeparator());
            fileWriter.flush();
            System.err.println("LogWriter writing logfile!");
        } catch(IOException e) {
            System.err.println("LogWriter logfile write error!");
            e.printStackTrace();
        }
        
    }

}