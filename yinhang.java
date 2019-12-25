import java.util.*;
public class Yinhang{
	public static void main(String[] agrs){
		Scanner ss=new Scanner(System.in);
		System.out.println("欢迎使用ABC银行，请您输入手机号：");
		long x=ss.nextLong();
		System.out.println("请您输入密码：");
		int y=ss.nextInt();
		int z;
		if (lxx(x,y)){
			System.out.println("请选择您要继续的业务，1、存款  2、取款");
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
					System.out.println("密码口令输入错误，请重新输入");
					x=ss.nextLong();
					y=ss.nextInt();
				}else {
					System.out.println("输入有误，返回主界面重新开始");
				}
				//}
			}
		}
		return c;
	}
	public static void lxx(){
		Scanner ss=new Scanner(System.in);
		System.out.println("请您输入要取出的金额");
		int x=ss.nextInt();
		int y =500000;
		for (int i=1;i<=3;i++ ){
			if (x%100==0&&x<y&&x>0){
				System.out.println("请您清点钞票");
				break;
			}else{		
				if(x%100==0&&x>y){
					if(i<3){
						System.out.println("余额不足，请重新输入");
						x=ss.nextInt();
				    }else
						System.out.println("输入有误，返回主界面重新开始");						
				}else{
					if(i<3){
						System.out.println("余额不足，请重新输入");
						x=ss.nextInt();
					}else 
						System.out.println("输入金额有误");
				}	
			}
		}
	}
	public static void lxx2(){
		Scanner ss=new Scanner(System.in);
		System.out.println("请您输入要存储的金额");
		int x=ss.nextInt();
		int y =20000;
		for (int i=1;i<=3;i++ ){
			if (x%100==0&&x<=y&&x>0){
				System.out.println("正在存入，请稍后 ");
				break;
			}else{		
				if(x%100==0&&x>y){
					if(i<3){
					System.out.println("金额输入有误，单次存储不能超过2W，请重新输入");
					x=ss.nextInt();
				    }else
					System.out.println("输入有误，返回主界面重新开始");									
				}else{
					if(i<3){
						System.out.println("输入金额有误，请重新输入");
						x=ss.nextInt();
					}
					else System.out.println("输入金额有误");
				}
			}
		}
	}				
}
