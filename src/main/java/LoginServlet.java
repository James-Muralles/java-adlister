import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//login page that posts the username and password. If username and password match the correct values it will redirect to the profile page

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.getWriter().println("<h1>Hello, World!</h1>");
        request.getRequestDispatcher("/login.jsp").forward(request, response);

    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {

        if(request.getParameter("username") != null && request.getParameter("password") != null) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (username.equals("admin") && password.equals("password")) {
                response.sendRedirect("http://localhost:8080/profile.jsp");
            }
        }

    }
}

