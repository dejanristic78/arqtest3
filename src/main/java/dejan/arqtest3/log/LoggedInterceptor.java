/**
 * Interceptor used for logging
 */

package dejan.arqtest3.log;

import java.io.Serializable;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Logged
@Interceptor
public class LoggedInterceptor implements Serializable {
    
    @Inject
    LogWriter logWriter;
    
    public LoggedInterceptor() {
        System.err.println("LoggedInterceptor Construct!");
    }
    /**
     * Creates a string with information of the intercepted method. The string
     * contains information about the methods class, method name and method parameters.
     * Forwards the string to LogWriter.writeEntry()
     * @param invocationContext
     * @return invocationContext.proceed()
     * @throws Exception 
     */
    @AroundInvoke
    public Object logMethodEntry(InvocationContext invocationContext) throws Exception {
        String entry = invocationContext.getMethod().getDeclaringClass().getName()
                + "." + invocationContext.getMethod().getName()
                + "( ";
        for(Object o : invocationContext.getParameters() ) {
            entry = entry + o + ", ";
        }
        entry = entry.substring(0, entry.length()-2);
        entry = entry + " )";
        
        logWriter.writeEntry(entry);
        return invocationContext.proceed();
    }
}