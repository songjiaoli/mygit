package factory;
 
//简单工厂代码demo
public class J4 {
 
	interface Product{
		public void work() ;
	}
	
	static class Phone implements Product{
		public void work() {
			System.out.println("手机开始工作");
		}
	}
	static class Computer implements Product{
		public void work() {
			System.out.println("电脑开始工作");
		}
	}
	
	static class ProductFactory{
		public static Product getProduct(String name) {
			if("phone".equals(name)) {
				return new Phone();
			}else if("computer".equals(name)) {
				return new Computer();
			}else {
				return null;
			}
			
			
		}
	}
	public static void main(String[] args) {
		// 使用工厂模式 降低使用者与被使用者之间的耦合
		//Product phone = new Phone();
		// 将使用者与被使用者之间的依赖转移到使用者与工厂之间的依赖
		Product phone = ProductFactory.getProduct("phone");
		if(null!=phone) {
		phone.work();
		}
	}
}

