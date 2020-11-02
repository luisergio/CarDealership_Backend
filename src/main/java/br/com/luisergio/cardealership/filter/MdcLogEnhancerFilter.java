package br.com.luisergio.cardealership.filter;

import br.com.luisergio.cardealership.utils.LogConstants;
import lombok.SneakyThrows;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

@Component
public class MdcLogEnhancerFilter extends GenericFilter {

    private static final long serialVersionUID = 1L;

    @Override
    @SneakyThrows
    public void doFilter(ServletRequest request, ServletResponse servletResponse, FilterChain filterChain) {
        MDC.clear();
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        MDC.put(LogConstants.MDC_SESSION_ID, httpRequest.getHeader(LogConstants.MDC_SESSION_ID));
        MDC.put(LogConstants.MDC_REQUEST_ID, httpRequest.getHeader(LogConstants.MDC_REQUEST_ID));
        MDC.put(LogConstants.MDC_REQUEST_URL, httpRequest.getRequestURI());
        MDC.put(LogConstants.MDC_REQUEST_METHOD, httpRequest.getMethod());
    }
}
