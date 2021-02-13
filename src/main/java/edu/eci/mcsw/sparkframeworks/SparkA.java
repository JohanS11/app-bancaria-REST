package edu.eci.mcsw.sparkframeworks;

import edu.eci.mcsw.servers.Request;
import edu.eci.mcsw.servers.Response;

import java.util.function.BiFunction;


/**
 * The type Spark a.
 */
public class SparkA {


    /**
     * The constant handler.
     */
    public static Handler handler = new Handler();

    /**
     * Get.
     *
     * @param path the path
     * @param f    the f
     */
    public static void get (String path, BiFunction<Request, Response,String> f){
        handler.getEndPoints().put("GET" + path, f);

    }

    /**
     * Post.
     *
     * @param path the path
     * @param f    the f
     */
    public static void post (String path, BiFunction<Request, Response,String> f){
        handler.getEndPoints().put("POST"+path,f);
    }

    /**
     * Exec response.
     *
     * @param request the request
     * @return the response
     */
    public static Response exec(Request request){
        return handler.execute(request);
    }

    /**
     * Set static resources path.
     *
     * @param path the path
     */
    public static void setStaticResourcesPath(String path){

    }
}
