package eu.throup.triangles.webapp;

import eu.throup.triangles.domain.Triangle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TriangleServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = parsedPageContent();
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(content);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double side1 = getParameter(request, "side1");
        double side2 = getParameter(request, "side2");
        double side3 = getParameter(request, "side3");

        String result = "";
        try {
            Triangle triangle = new Triangle(side1, side2, side3);

            result = "The triangle is ";
            switch (triangle.classify()) {
                case EQUILATERAL:
                    result += "equilateral.";
                    break;

                case ISOSCELES:
                    result += "isosceles.";
                    break;

                case SCALENE:
                    result += "scalene.";
                    break;
            }
        } catch (IllegalArgumentException e) {
            result = e.getMessage();
        }

        String content = parsedPageContent(side1, side2, side3, result);
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(content);
    }

    private double getParameter(HttpServletRequest request, String param) {
        try {
            return Double.parseDouble(request.getParameter(param));
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
    }

    private String parsedPageContent(double side1, double side2, double side3, String result) throws IOException {
        String content = getFileContent("templates/page.html");
        content = content.replace(":SIDE1:", String.valueOf(side1));
        content = content.replace(":SIDE2:", String.valueOf(side2));
        content = content.replace(":SIDE3:", String.valueOf(side3));
        content = content.replace(":RESULT:", result);
        return content;
    }

    private String parsedPageContent() throws IOException {
        return parsedPageContent(Double.NaN, Double.NaN, Double.NaN, "");
    }

    private String getFileContent(String filename) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(filename).getFile());
        return new String(Files.readAllBytes(Paths.get(file.getPath())));
    }
}
