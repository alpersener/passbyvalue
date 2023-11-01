package PassByValue;

public class Operation3 {
    int data=50;


    public void increase(int data){
        data+=50;
        System.out.println("method için data:"+data);
    }


    public static void main(String[] args) {
        Operation3 op3=new Operation3();
        System.out.println(op3.data);
        op3.increase(50);
        System.out.println(op3.data);





    }




}
