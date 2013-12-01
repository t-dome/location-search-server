package de.goeuro.devtest.http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Rolf Schuster
 */
@WebServlet(value = "/v1/suggest/position/en/name/*")
public class SuggestLocation extends HttpServlet {

    private static final String FIXED_RESULT = "{\n" +
            "  \"results\" : [ {\n" +
            "    \"_type\" : \"Position\",\n" +
            "    \"_id\" : 410978,\n" +
            "    \"name\" : \"Potsdam, USA\",\n" +
            "    \"type\" : \"location\",\n" +
            "    \"geo_position\" : {\n" +
            "        \"latitude\" : 44.66978,\n" +
            "        \"longitude\" : -74.98131\n" +
            "      }\n" +
            "  }, {\n" +
            "    \"_type\" : \"Position\",\n" +
            "    \"_id\" : 377078,\n" +
            "    \"name\" : \"Potsdam, Deutschland\",\n" +
            "    \"type\" : \"location\",\n" +
            "    \"geo_position\" : {\n" +
            "        \"latitude\" : 52.39886,\n" +
            "        \"longitude\" : 13.06566\n" +
            "      }" +
            "   } ]\n" +
            "}";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchParam = getFirstPathParam(request);
        if (searchParam != null) {
            response.getWriter().write(FIXED_RESULT);
        } else {
            // error - no search string provided in URL
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private String getFirstPathParam(HttpServletRequest request) {
        String pathInfo = request.getPathInfo();
        if (pathInfo != null) {
            String[] pathParams = pathInfo.split("/");
            if (pathParams != null && pathParams.length >= 2) {
                return pathParams[1];
            }
        }

        // no parameter was specified
        return null;
    }
}
