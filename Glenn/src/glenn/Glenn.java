/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glenn;

/**
 *
 * @author USER
 */
public class Glenn {

    public int Glenn(boolean a, boolean b, boolean c){
        int ret = 0;
        
        if (a && b){
            ret = 1;
        }
        else if (c){
            ret = 2;
        }
        return ret;
    }
    
}
