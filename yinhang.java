import java.util.*;
public class Yinhang{
	public static void main(String[] agrs){
		Scanner ss=new Scanner(System.in);
		System.out.println("��ӭʹ��ABC���У����������ֻ��ţ�");
		long x=ss.nextLong();
		System.out.println("�����������룺");
		int y=ss.nextInt();
		int z;
		if (lxx(x,y)){
			System.out.println("��ѡ����Ҫ������ҵ��1�����  2��ȡ��");
			z=ss.nextInt();
			if(z==1){
				lxx2();
			}else 
				lxx();
		}
	}
	public static boolean lxx(long x,int y){
		Scanner ss=new Scanner(System.in);
		long a=15202412579l;int b= 145773;boolean c=false;
		for (int i=1;i<4;i++){
			if(x==a&&y==b){
				c=true;
				 break;
			}else{
				//if(x!=a||y!=b){
				if(i<3){
					System.out.println("������������������������");
					x=ss.nextLong();
					y=ss.nextInt();
				}else {
					System.out.println("�������󣬷������������¿�ʼ");
				}
				//}
			}
		}
		return c;
	}
	public static void lxx(){
		Scanner ss=new Scanner(System.in);
		System.out.println("��������Ҫȡ���Ľ��");
		int x=ss.nextInt();
		int y =500000;
		for (int i=1;i<=3;i++ ){
			if (x%100==0&&x<y&&x>0){
				System.out.println("������㳮Ʊ");
				break;
			}else{		
				if(x%100==0&&x>y){
					if(i<3){
						System.out.println("���㣬����������");
						x=ss.nextInt();
				    }else
						System.out.println("�������󣬷������������¿�ʼ");						
				}else{
					if(i<3){
						System.out.println("���㣬����������");
						x=ss.nextInt();
					}else 
						System.out.println("����������");
				}	
			}
		}
	}
	public static void lxx2(){
		Scanner ss=new Scanner(System.in);
		System.out.println("��������Ҫ�洢�Ľ��");
		int x=ss.nextInt();
		int y =20000;
		for (int i=1;i<=3;i++ ){
			if (x%100==0&&x<=y&&x>0){
				System.out.println("���ڴ��룬���Ժ� ");
				break;
			}else{		
				if(x%100==0&&x>y){
					if(i<3){
					System.out.println("����������󣬵��δ洢���ܳ���2W������������");
					x=ss.nextInt();
				    }else
					System.out.println("�������󣬷������������¿�ʼ");									
				}else{
					if(i<3){
						System.out.println("��������������������");
						x=ss.nextInt();
					}
					else System.out.println("����������");
				}
			}
		}
	}				
}
