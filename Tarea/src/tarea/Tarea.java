
package tarea;

public class Tarea {
    public int ObtenString(boolean a, boolean b, boolean c){
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
