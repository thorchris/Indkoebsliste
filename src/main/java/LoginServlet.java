import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();

        HttpSession session = request.getSession();

        String brugernavn = request.getParameter("brugernavn");
        String kodeord = request.getParameter("kodeord");

        if(servletContext.getAttribute("brugerMap") == null) {
            Map<String, String> brugerMap = new HashMap<>();

            brugerMap.put("test", "test");
            brugerMap.put("admin", "1234");


            servletContext.setAttribute("brugerMap", brugerMap);
        }

        if(((Set<String>)servletContext.getAttribute("aktiveBrugere")) == null){
            Set<String> aktiveBrugere = new HashSet<>();
            servletContext.setAttribute("aktiveBrugere", aktiveBrugere);
        }

        if(!(session.getAttribute("besked") == null)){
            request.getRequestDispatcher("WEB-INF/HuskeListe.jsp").forward(request,response);
        }

        if(!((Map<String, String>)  servletContext.getAttribute("brugerMap") ).containsKey(brugernavn) ) {

            request.setAttribute("besked", "Brugernavn findes ikke, opret ny bruger her");
            request.getRequestDispatcher("WEB-INF/OpretBruger.jsp").forward(request, response);
        }

        if(( (Map<String, String>)  servletContext.getAttribute("brugerMap") ).get(brugernavn).equalsIgnoreCase(kodeord)) {

            if(brugernavn.equalsIgnoreCase("admin")){
            // TODO gå til adminside
                request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request,response);
            }

            if(!((Set<String>)servletContext.getAttribute("aktiveBrugere")).contains(brugernavn)){
                ((Set<String>)servletContext.getAttribute("aktiveBrugere")).add(brugernavn);
                session.setAttribute("besked", "Du er logget ind med navnet " + brugernavn);
                session.setAttribute("navn", brugernavn);
                request.getRequestDispatcher("WEB-INF/HuskeListe.jsp").forward(request,response);
            }

        }

        // TODO gå til login indexside
        request.setAttribute("besked", "Der gik et eller andet galt, prøv igen");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
