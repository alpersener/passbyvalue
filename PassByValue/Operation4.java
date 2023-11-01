package PassByValue;

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
      book=new Book();
      book.setPage(112);
      book.setAuthor("Alperstatik");

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



}