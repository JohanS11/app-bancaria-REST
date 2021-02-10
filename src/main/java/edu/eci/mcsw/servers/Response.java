package edu.eci.mcsw.servers;

/**
 * The type Response.
 */
public class Response {
    private String contentType;
    private String status;
    private String body;
    /**
     * The constant NOT_FOUND.
     */
    public static final String NOT_FOUND = "HTTP/1.0 404 Not Found \r\n" + "Content-type: text/html" + "\r\n\r\n"+ "404 File not found";
    /**
     * The constant OK.
     */
    public static final String OK = "HTTP/1.0 200 OK\r\n";

    /**
     * Instantiates a new Response.
     */
    public Response(){
        this.contentType = "text/plain";
        this.status = "";
        this.body = "";
    }

    /**
     * Get content type string.
     *
     * @return the string
     */
    public String getContentType(){
        return this.contentType;
    }

    /**
     * Set status.
     *
     * @param status the status
     */
    public void setStatus(String status){
        this.status = status;
    }

    /**
     * Get status string.
     *
     * @return the string
     */
    public String getStatus(){
        return this.status;
    }

    /**
     * Set content type.
     *
     * @param filename the filename
     */
    public void setContentType(String filename){
        if (filename.endsWith(".html") || filename.endsWith(".htm")){
            this.contentType =  "text/html";
        }
        if (filename.endsWith(".css")) {
            this.contentType = "text/css";
        }
        else if (filename.endsWith(".jpg") ||  filename.endsWith(".jpeg")){
            this.contentType = "image/jpeg";
        }
        else if (filename.endsWith(".gif")){
            this.contentType = "image/gif";
        }
        else if (filename.endsWith(".class")){
            this.contentType = "application/octet-stream";
        }
    }

    /**
     * Gets body.
     *
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets body.
     *
     * @param body the body
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Sets default status.
     *
     * @param req the req
     */
    public void setDefaultStatus(Request req) {
        this.setContentType(req.getPath());
        this.setStatus(Response.OK);
    }
}
