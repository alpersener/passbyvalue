Pass By Value and Pass By Reference
===================================
Pass by Value
=============

Pass by value kavramında metot bir değer verilerek çağırılır.Bu nedenle pass by value denmektedir.Orijinal parametreyi etkilemez.Method parametresi bir nesne olsa dahi referansı kopyalanarak method içerisine aktarılır.Bu sayede method içerisindeki objeyi istediğimiz gibi manipüle edebiliriz.

*   **Java'da bir metodun parametresine değer olarak geçilen herhangi bir şey, orijinal değeri değiştirmez.**

*   **Bir metodun parametresine nesne referansı olarak geçildiğinde, nesnenin kendisi değil, referansın kopyası geçirilir. Yani, referansın kopyası aynı nesneyi işaret ettiği için bu durum "pass-by-reference" gibi bir davranışı andırır. Ancak unutulmaması gereken şey, referansın kopyası geçtiği için bu referansın üzerinde yapılan değişiklikler nesnenin içeriğini etkiler, ancak referansın kendisi değişmez.**

*   **Yani aslında bir ev anahtarı olduğunu düşünürsek anahatarın bir yedek kopyasını alıyorum kopya ile odaya girilebilir orijinal anahtar ile de odaya girilebilir kopya ile giren kişi evde değişiklik yapsa orjinal anahtarla giren kişi de bu değişikliği görecektir.**

*   **Ek olarak yeni bir anahtar çıkarttığımda ise o anahtar kapıyı açmaz başka kapıyı açar(başka nesne yaratırsak referansı başka yere gider.)**
```
    public class Operation4 {
        public static void main(String[] args) {
            Book book=new Book();
            book.setPage(150);
            increasePage(book);
            increasePageWithNewObject(book);
            System.out.println(book.getPage());
    
    
        }
        private static void increasePage(Book book){
            book.setPage(book.getPage()+100);
        }
    
        private static void increasePageWithNewObject(Book book){
          book=new Book();
          book.setPage(112);
    
        }
    
    
    }
    class Book{
    
        private int page;
    
      public int getPage(){
          return page;
      }
      public void setPage(int page){
          this.page=page;
      }
```

![photo](https://github.com/alpersener/passbyvalue/blob/main/photo.png)

*   Burada increasePageWithNewObject yeni bir obje oluşturduğu için ilk nesne ile bağlantısı kesilir bu nedenle 250 döner.**(increasePageWithNewObject)**

*   **increasePage** methodunda parametre olarak book geçilyior ve yeni nesne yaratılmıyor böylece ana book nesnesinin referansı kopyalanıyor **(pass by reference gibi gözüküyor ama değil.)**

*   Özet olarak, nesneler metotlara parametre olarak geçildiğinde nesnelerin adresleri kopyalanır. Dolayısıyla heap’te aynı nesneyi gösterirler ve bu nesnelerin herhangi bir tanesinde değişiklik yapıldığında her iki referans de bu durumdan etkilenecektir. Fakat nesnelerin kendileri bu durumdan etkilenmezler.

*   eğer “**private static int page**” olarak değiştirilseydi output:112 olurdu.Sebebi ise şudur static olarak tanımlarsak bu page tüm book nesneleri için ortak olmuş olur.Ortak olduğu için yapılan değişiklikler hepsini etkilemiş olacaktır.

*   Örneğin koda statik olmayan author eklenirse output değişikliğine bakalım.

```
    public class Operation4 {
        public static void main(String[] args) {
            Book myBook=new Book();
            myBook.setPage(150);
           increasePage(myBook);
            increasePageWithNewObject(myBook);
            System.out.println(myBook.getPage());
            System.out.println(myBook.getAuthor());
    
    
        }
        private static void increasePage(Book book){
    
            book.setPage(book.getPage()+100);
            book.setAuthor("AlperŞener");
        }
    
        private static void increasePageWithNewObject(Book book){
          book=new Book(); //->önemli kısım
          book.setPage(112);
          book.setAuthor("Alperstatic");
    
        }
    
    
    }
    
    class Book{
    
        private static int page; 
        private  String author;
    
        public String getAuthor() {
            return author;
        }
    
        public void setAuthor(String author) {
            this.author = author;
        }
    
        public int getPage(){
          return page;
      }
      public void setPage(int page){
          this.page=page;
      }
```

*   Burada page static verildi yani istesek nesne oluşsun ister oluşmasın herhangi bir methodda yapılan değişiklik book nesnesindeki page kısmını değiştirecektir.

*   Author statik değil bu nedenle bize “AlperŞener” yazdıracaktır biz bunu static yaparsak “Alperstatic” yazacaktır.

*   Ek olarak static olarak belirtmesek bile increasePageWithBook methodunda nesne oluşturmadan aynı şekilde yazsaydık yine “Alperstatic” yazardı eğer nesneyi oluşturup yazsaydık yeni bir nesne yaratılacağı için ve o yaratılan nesne book nesnesiyle aynı refereansı tutmayacağı için o methodda yapılan author değişkenliği olmayacaktı “AlperŞener” yazacaktır.

```
    public class Operation3 {
        int data=50;
        void change(int data){
            data+=100;
        }
    
        public static void main(String[] args) {
            Operation op=new Operation();
            System.out.println("before change:"+op.data);
            op.change(100);
            System.out.println("after change:"+op.data);
        }
    }
```

*   Burada data’nın kendi değeri değişmez çünkü parametre olarak geçtiğimiz için data değişkenini kendisi bir kopya oluşturacak ve method içerisinde çalışacak ardından da method kullanımı bittiği için kendini silecektir.

```
    public class test {
    
        int data=50;
    
    
        void change(int data){
            data+=50;
        }
    
        public static void main(String[] args) {
            test obj=new test();
            System.out.println(obj.data);
            obj.change(50);
            System.out.println(obj.data);
            int x=1;
            increase(x);
            System.out.println(x);
    
        }
        public static void increase(int x){
            x++;
            System.out.println(x);
        }
    
    }
```

*   data değeri değişmeyecek ek olarak x 2 olacak ancak global olarak verilen x=1 olarak kalacaktır.

Pass By Reference
=================

Pass by reference kavramında method asıl parametrenin bir alias’ı ya da referansı kullanılarak çağırılır Java bu durumu desteklememektedir.

    void changeValue(int &x) {
        x = 10; // Fonksiyon içinde x değeri değişirse, orijinal argüman da değişir
    }
    
    int main() {
        int num = 5;
        changeValue(num);
        // num artık 10 olarak değişir
    }
