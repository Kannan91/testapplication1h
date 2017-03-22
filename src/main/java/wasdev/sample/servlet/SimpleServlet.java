package wasdev.sample.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.io.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/callback")
public class SimpleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(); 
        PrintWriter out = response.getWriter();  
        response.setContentType("text/html");
        out.print("Hello World!");
        Enumeration<?> e = session.getAttributeNames();
	while (e.hasMoreElements())
	{
    String name = (String) e.nextElement();

    // Get the value of the attribute
    Object value = session.getAttribute(name);

    if (value instanceof Map) {
        for (Map.Entry<?, ?> entry : ((Map<?, ?>)value).entrySet()) {
            out.println(entry.getKey() + "=" + entry.getValue());
        }
    } else if (value instanceof List) {
        for (Object element : (List)value) {
            out.println(element);
        }
    }
}
    }

}
