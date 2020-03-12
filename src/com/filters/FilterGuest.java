package com.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "FilterGuest")
public class FilterGuest implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;


        HttpSession session = req.getSession(false);

        if(session != null) {
            if (session.getAttribute("current_user") != null) {
                res.sendRedirect("home");
            }
            else chain.doFilter(request, response);
        } else chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
