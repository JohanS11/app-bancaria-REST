package edu.eci.mcsw.servers;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Request.
 */
public class Request {
    private String path;
    private String type;
    private String body;
    /**
     * The Headers map.
     */
    Map<String, String> headersMap;

    /**
     * Instantiates a new Request.
     */
    public Request() {
        this.path = "";
        this.type = "";
        this.headersMap = new HashMap<String, String>();
    }

    /**
     * Get path string.
     *
     * @return the string
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets path.
     *
     * @param path the path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Gets headers map.
     *
     * @return the headers map
     */
    public Map<String, String> getHeadersMap() {
        return headersMap;
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
     * Set header.
     *
     * @param key   the key
     * @param value the value
     */
    public void setHeader(String key,String value){
        headersMap.put(key,value);
    }
}
