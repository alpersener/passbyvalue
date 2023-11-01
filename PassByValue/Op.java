package PassByValue;

public class Op {
    public static void main(String[] args) {
        int a=100;
        System.out.println(a);
        int b=a;
        System.out.println(b);
        b=200;
        System.out.println(b);
        System.out.println("---------------------");
        Computer computer=new Computer();
        computer.name="HP";
        computer.modelYear="2019";
        computer.price=156.5;
        System.out.println(computer.name);
        System.out.println(computer.modelYear);
        System.out.println(computer.price);
        System.out.println("---------------------");
        Computer computer2;
        computer2=computer;
        System.out.println(computer2.name);
        System.out.println(computer2.modelYear);
        System.out.println(computer2.price);
        System.out.println("---------------------");
        computer2.name="Lenovo";
        computer2.modelYear="2023";
        computer2.price=28.600;
        System.out.println(computer.name);
        System.out.println(computer.modelYear);
        System.out.println(computer.price);
        System.out.println("---------------------");
        System.out.println(computer2.name);
        System.out.println(computer2.modelYear);
        System.out.println(computer2.price);
     





    }

}

 class Computer{
    String name;
    String modelYear;
    double price;

}
