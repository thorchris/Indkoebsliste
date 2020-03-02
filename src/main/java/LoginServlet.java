import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();

        String brugernavn = request.getParameter("brugernavn");
        String kodeord = request.getParameter("kodeord");

        if(servletContext.getAttribute("brugerMap") == null) {
            Map<String, String> brugerMap = new HashMap<>();

            brugerMap.put("test", "test");

            servletContext.setAttribute("brugerMap", brugerMap);
        }

        if(!((Map<String, String>)  servletContext.getAttribute("brugerMap") ).containsKey(brugernavn) ) {
            //TODO gå til loginside
            request.setAttribute("besked", "Brugernavn findes ikke, opret ny bruger her");
            request.getRequestDispatcher("WEB-INF/OpretBruger.jsp").forward(request, response);
        }

        if(( (Map<String, String>)  servletContext.getAttribute("brugerMap") ).get(brugernavn).equalsIgnoreCase(kodeord)) {
            // TODO gå til huskelisten
            request.getRequestDispatcher("WEB-INF/HuskeListe.jsp").forward(request,response);
        }

        // TODO gå til login indexside
        request.setAttribute("besked", "Dit kodeord var forkert, prøv igen");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
