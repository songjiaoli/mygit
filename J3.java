interface Animal{ 
          void shout();
}
class Cat implements Animal{
     public void shout (){
    System.out.println("����");
   }
void sleep() {
     System.out.println("è˯��");
}
}
public class J3 {
   public static void main (String[] args){
   Cat cat=new Cat();
   animalShout(cat);
}
public static void animalShout (Animal animal){
Cat cat=(Cat) animal;
cat.shout();
cat.sleep();
}}