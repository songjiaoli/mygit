import customer.Customer;
import movie.Movie;
import rental.Rental;

public class ChongGouMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Movie movie1 = new Movie("�������" , 1);
		Movie movie2 = new Movie("��ѩ��Ե" , 2);
		Movie movie3 = new Movie("����ϲ��" , 0);
		
		Rental rental1 = new Rental(movie1 , 3);
		Rental rental2 = new Rental(movie2,4);
		Rental rental3 = new Rental(movie3,2);
		 
		Customer customer = new Customer("�˿�С��");
		
		customer.addRental(rental1);
		customer.addRental(rental2);
		customer.addRental(rental3);
		System.out.println("��ӡ����"+ customer.statement());
		
		
		
	}

}
