public class Output implements Runnable{
	private Storage st;
	Output(Storage st){
		this.st=st;
	}
	public void run(){
		while(true){
			st.get();
		}
	}
}
public class Storage {
	private int [] cells=new int[10];
	private int inPos ,outPos;
	private int count;
	public synchronized void put (int num){
		try{
			while(count==cells.length){
				this.wait();
			}
			cells[inPos]=num;
			System.out.println("��cells["+inPos+"]�з�������---"+cells[inPos]);
			inPos++;
			if(inPos==cells.length)
				inPos=0;
			count++;
			this.notify();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public synchronized void get(){
		try{
			while(count==0){
				this.wait();
			}
			int data=cells[outPos];
			System.out.println("��cells["+inPos+"]��ȡ������---"+data);
			cells[outPos]=0;
			outPos++;
			if(outPos==cells.length)
				outPos=0;
			count--;
			this.notify();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
public class Input implements Runnable{
	private Storage st;
	private int num;
	Input(Storage st){
		this.st=st;
	}
	public void run(){
		while(true){
			st.put(num++);
		}
	}

}
public class Example {

	public static void main(String[] args) {
		Storage st =new Storage ();
		Input input =new Input(st);
		Output output=new Output(st);
		new Thread(input).start();
		new Thread(output).start();
	}

}
