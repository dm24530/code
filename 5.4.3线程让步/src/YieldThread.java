//����YieldThread��̳�Thread��
public class YieldThread extends Thread{
	//����һ���вεĹ��췽��
	public YieldThread(String name) {
		super(name);  //���ø���Ĺ��췽��
	}
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println(Thread.currentThread().getName()+"---"+i);
			if(i==3) {
				System.out.println("�߳��ò�:");
				Thread.yield();
			}
		}
	}
}
