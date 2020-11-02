package br.com.luisergio.cardealership.utils;

import br.com.luisergio.cardealership.CarDealershipApplication;
import br.com.luisergio.cardealership.dto.enumeration.EventLogs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

/**
 * The type Logger service.
 */
@Service
public class LoggerService {

    private static final Logger log = LoggerFactory.getLogger(CarDealershipApplication.class);

    /**
     * Log.
     *
     * @param message the message
     */
    public void log(String message){
        log.info(message, this.retrieveValuesFromMDC());
    }

    /**
     * Log.
     *
     * @param eventLogs the event logs
     */
    public void log(EventLogs eventLogs){
        log.info(eventLogs.getCode(), this.retrieveValuesFromMDC());
    }

    /**
     * Log error.
     *
     * @param eventLogs the event logs
     * @param exception the exception
     */
    public void logError(EventLogs eventLogs, Exception exception){
        log.error(eventLogs.getCode(), this.retrieveValuesFromMDC(), exception);
    }

    private Object[] retrieveValuesFromMDC() {
        Object[] propertiesFromRequest = new Object[]{
                MDC.get(LogConstants.MDC_SESSION_ID),
                MDC.get(LogConstants.MDC_REQUEST_ID),
                MDC.get(LogConstants.MDC_REQUEST_URL),
                MDC.get(LogConstants.MDC_REQUEST_METHOD)};
        return propertiesFromRequest;
    }

}
