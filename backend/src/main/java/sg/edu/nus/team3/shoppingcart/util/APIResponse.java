package sg.edu.nus.team3.shoppingcart.util;

import java.util.HashMap;

/**
 * @author Jared Chua, Dion Yao
 */

public class APIResponse {
    private String message;

    public APIResponse() {
        this.message = "Something went wrong.";
    }

    public APIResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /*
     * public HashMap<String, String> getResponse() {
     * HashMap<String, String> response = new HashMap<>();
     * response.put("status", this.messageHead);
     * response.put("message", this.message);
     * return response;
     * }
     */

}
