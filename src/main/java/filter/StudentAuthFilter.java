package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/jsp/student/*")
public class StudentAuthFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest)req).getSession(false);
        if (session != null && "student".equals(session.getAttribute("role"))){
            chain.doFilter(req , res);
        }
        else {
            ((HttpServletResponse)res).sendRedirect("jsp/unauthorized.jsp");
        }
    }
}
