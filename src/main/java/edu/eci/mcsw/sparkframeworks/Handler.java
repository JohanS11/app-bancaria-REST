package edu.eci.mcsw.sparkframeworks;



import edu.eci.mcsw.servers.Request;
import edu.eci.mcsw.servers.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * The type Handler.
 */
public class Handler {
    /**
     * The End points.
     */
    Map<String, BiFunction<Request, Response,String>> endPoints;

    /**
     * Instantiates a new Handler.
     */
    public Handler(){
        this.endPoints = new HashMap<String, BiFunction<Request,Response,String>>();
    }

    /**
     * Execute response.
     *
     * @param request the request
     * @return the response
     */
    public Response execute(Request request){
        String endPoint = request.getType() +request.getPath();
        if(endPoints.containsKey(endPoint)){
            Response response = new Response();
            response.setBody(endPoints.get(endPoint).apply(request,response));
            return response;
        }else{
            return null;
        }
    }

    /**
     * Gets end points.
     *
     * @return the end points
     */
    public Map<String, BiFunction<Request, Response, String>> getEndPoints() {
        return endPoints;
    }


}
