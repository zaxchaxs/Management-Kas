/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.util.ArrayList;

/**
 *
 * @author Fadli
 */

public class DatabaseResultResponse {
    public int status;
    public String message;
    public ArrayList data;
    
    public DatabaseResultResponse(int status, String message, ArrayList data){
        this.status = status;
        this.message = message;
        this.data = data;
    }
    
};