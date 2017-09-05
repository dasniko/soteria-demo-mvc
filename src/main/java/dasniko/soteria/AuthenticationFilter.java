package dasniko.soteria;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
@WebFilter(urlPatterns = "/*")
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        boolean authenticated = httpRequest.getRemoteUser() != null;
        boolean loginRequest = requestURI.endsWith("/login");
        boolean registerRequest = requestURI.contains("/registration");
        boolean staticResource = requestURI.endsWith(".css");

        if (authenticated || loginRequest || registerRequest || staticResource) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect(httpRequest.getContextPath() + "/demo/login");
        }
    }

    @Override
    public void destroy() {
    }
}
