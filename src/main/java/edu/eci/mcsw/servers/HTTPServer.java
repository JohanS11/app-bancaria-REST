package edu.eci.mcsw.servers;


import edu.eci.mcsw.sparkframeworks.SparkA;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * The type Http server.
 */
public class HTTPServer extends Thread{

    private int port = 36000;
    private String staticPath = "src/main/resources";
    private boolean running;

    /**
     * Instantiates a new Http server.
     */
    public HTTPServer() {
    }

    /**
     * Instantiates a new Http server.
     * With a specific port
     * @param port the port
     */
    public HTTPServer(int port) {
        this.port = port;
    }
    public void run() {
        try{
        ServerSocket serverSocket = null;
        try {
            System.out.println("Running on port" + port);
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Could not listen on port: " + port);
            System.exit(1);
        }
        running = true;
        while (running) {
            try {
                Socket clientSocket = null;
                try {
                    clientSocket = serverSocket.accept();
                } catch (IOException e) {
                    System.err.println("Accept failed.");
                    System.exit(1);
                }
                processRequest(clientSocket);
                clientSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
            serverSocket.close();
        } catch (IOException e){
            System.out.println("f");
        }
    }

    private void processRequest(Socket clientSocket) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;
        Request req = new Request();
        boolean requestLineReady = false;
        while ((inputLine = in.readLine()) != null) {
            if (!requestLineReady) {
                req.setType(inputLine.split(" ")[0]);
                req.setPath(inputLine.split(" ")[1]);
                requestLineReady = true;
            } else {
                String[] entry = (inputLine.split(":"));
                if (entry.length > 1) {
                    req.setHeader(entry[0], entry[1]);
                }
            }
            if (!in.ready() || inputLine.length()==0) {
                break;
            }
        }

        StringBuilder body = new StringBuilder();
        if (req.getType().equals("POST")) {
            int c = 0;
            int cl = Integer.parseInt(req.getHeadersMap().get("Content-Length").trim());
            for (int i = 0; i < cl; i++) {
                c = in.read();
                body.append((char) c);
            }
            req.setBody(body.toString());
        }
        if(!req.getType().equals("")){
            createResponse(req, new PrintStream(
                    clientSocket.getOutputStream(), true));
        }in.close();
    }
    private void createResponse(Request req, PrintStream out) {
        if (req.getPath().equals("/")){
            req.setPath("/index.html");
        }
        Response res = new Response();
        Response response = SparkA.exec(req);
        try {
            if (response != null){
                response.setDefaultStatus(req);
                out.print(response.getStatus() + "Content-type: " + response.getContentType() + "\r\n\r\n");
                out.print(response.getBody());
                out.close();
            }else{
                res.setDefaultStatus(req);
                if(req.getType().equals("GET")) {
                    getResource(res, req.getPath(), out);
                }
            }
            out.close();
        } catch (IOException e) {
            res.setStatus(Response.NOT_FOUND);
            out.close();
        }
        out.close();
    }
    private void getResource(Response res, String fileName, PrintStream out) throws IOException {
        File file = new File(staticPath + fileName);
        if(fileName.equals("/")){
            fileName = "index.html";
        }
        if (file.exists()) {
            String fd = staticPath + fileName;
            InputStream f = new FileInputStream(fd);
            out.print(res.getStatus() + "Content-type: " + res.getContentType() + "\r\n\r\n");
            byte[] a = new byte[4096];
            int n;
            while ((n = f.read(a)) > 0) {
                out.write(a, 0, n);
            }
        }else{
            out.print(Response.NOT_FOUND);
            out.close();
        }
        out.close();
    }

    /**
     * Sets static path.
     *
     * @param staticPath the static path
     */
    public void setStaticPath(String staticPath) {
        this.staticPath = staticPath;
    }

    /**
     * Gets port.
     *
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * Sets port.
     *
     * @param port the port
     */
    public void setPort(int port) {
        this.port = port;
    }
}