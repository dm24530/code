
public class Example10 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//�����߳�
		Thread t = new Thread(new EmergencyThread(),"�߳�һ");
		t.start();   //�����߳�
		for(int i=1;i<6;i++) {
			System.out.println(Thread.currentThread().getName()+"���룺"+i);
			if(i==2) {
				t.join();   //����join()����
			}
			Thread.sleep(500);    //�߳�����500����
		}
	}

}
