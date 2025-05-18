class Xyz{
    Xyz(){
        System.out.println("XYZ");
        
    }
    
    public int sum(int a,int b){
        return a+b;
    }
}

public class constructor {
    public static void main(String args[]){
        Xyz a = new Xyz();
        Xyz b = new Xyz();
        System.out.println(a.sum(0, 0));
    }    
}
