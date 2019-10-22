public class ThreadDemo {
	public static void main(String[] args) throws InterruptedException {
			
//		TestThread t = new TestThread();
//		t.setDaemon(true);
//		t.start();//�߳���������
//		t.getName();//��ȡ�߳�����
//		t.getPriority();//��ȡ�̵߳����ȼ�
//		t.destroy();//�߳�����
//		t.interrupt();//�߳��ж�
//		t.isAlive();//�߳��Ƿ���
//		t.isDaemon();//�߳����ں�̨
//		t.join();//�߳�ǿ�ƽ���
		
		
		//�߳�1����
		TestThread t = new TestThread();
		t.start();
		
		//�߳�����
		Thread.sleep(500);
		//main���߳�����
		t.loop();
	}
	
	public synchronized void loop() {
		synchronized(this) {
			System.out.println(Thread.currentThread().getName()+"----->�ոս���loop������");
			for(int i=0; i < 10; i++) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"���Է�����");		
			}
			System.out.println(Thread.currentThread().getName()+"----->�ո��뿪loop������");
		}
	}
	public void run() {
		loop();
	}

}
