package Ex;
import java.util.*;
public class Exam2 {
public static void main (String[] args) {
	LinkedList link=new LinkedList();
	link.add("stu1");
	link.add("stu2");
	link.add("stu3");
	link.add("stu4");
	System.out.println(link.toString());
	link.add(3,"Student");
	link.addFirst("First");
	System.out.println(link);
	System.out.println(link.getFirst());
    link.remove(3);
    link.removeFirst();
    System.out.println(link);
}

}
