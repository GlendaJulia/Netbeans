package src;

public class Array {
    int vec[];
    
    public Array(int arr[]){
        vec=arr;
    }
    public int size(){
        return vec.length;
    }
    
    public String toString(){
        int i;
        String str="";
        for(i=0;i<vec.length-1;i++){
            str+= vec[i] +";";
        }
        str+= vec[i];
        return str;
    }
    public void setElementAt(int elem, int idx){
        vec[idx]=elem;
    }
    public int[] getArray(){
        return vec;
    }
}
