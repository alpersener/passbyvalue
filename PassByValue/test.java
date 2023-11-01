package PassByValue;

public class test {
    public static void main(String[] args) {
        int x=5;
        increase(x);
        System.out.println(x);
    }
    public static void increase(int x){
        x++;
        System.out.println(x);
    }
}
