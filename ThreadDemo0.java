public class ThreadDemo {
	public static void main(String[] args) throws InterruptedException {
			
//		TestThread t = new TestThread();
//		t.setDaemon(true);
//		t.start();//线程启动方法
//		t.getName();//获取线程名称
//		t.getPriority();//获取线程的优先级
//		t.destroy();//线程销毁
//		t.interrupt();//线程中断
//		t.isAlive();//线程是否存活
//		t.isDaemon();//线程置于后台
//		t.join();//线程强制进行
		
		
		//线程1运行
		TestThread t = new TestThread();
		t.start();
		
		//线程休眠
		Thread.sleep(500);
		//main主线程运行
		t.loop();
	}
	
	public synchronized void loop() {
		synchronized(this) {
			System.out.println(Thread.currentThread().getName()+"----->刚刚进入loop方法！");
			for(int i=0; i < 10; i++) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"测试方法！");		
			}
			System.out.println(Thread.currentThread().getName()+"----->刚刚离开loop方法！");
		}
	}
	public void run() {
		loop();
	}

}
