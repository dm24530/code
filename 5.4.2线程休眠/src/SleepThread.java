//����SleepThread��ʵ��Runnable�ӿ�
public class SleepThread implements Runnable{
	public void run() {
		for(int i=1;i<=10;i++) {
			if(i==3) {
				try {
					Thread.sleep(2000);    //��ǰ�߳�����2��
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("�߳�һ�������룺"+i);  
			try {
				Thread.sleep(500);   //��ǰ�߳�����500����
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
