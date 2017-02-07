package eu.throup.triangles.cucumber;

import eu.throup.triangles.webapp.TriangleServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.net.URI;

public class TestServer {
    private final Server server;

    public TestServer(int port) {
        server = new Server(port);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new TriangleServlet()), "/*");
    }

    public static void main(String[] args) throws Exception {
        new TestServer(9988).start();
    }

    public void start() throws Exception {
        server.start();
        System.out.println("Listening on " + getURI());
    }

    public URI getURI() {
        return server.getURI();
    }

    public void stop() throws Exception {
        server.stop();
    }
}

