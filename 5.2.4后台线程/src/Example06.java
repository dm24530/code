
public class Example06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main�߳��Ǻ�̨����"+Thread.currentThread().isDaemon());
		DamonThread dt = new DamonThread();         //����һ��DamonThread����dt
		Thread t= new Thread(dt,"��̨�߳�");         //�����߳�t����dt��Դ
		System.out.println("t�߳�Ĭ���Ǻ�̨�߳���"+t.isDaemon());        //�ж��Ƿ�Ϊ��̨�߳�
		t.setDaemon(true);           //��t����Ϊ��̨�߳�
		t.start();              //����star�ķ��������߳�t
		for(int i=0;i<10;i++) {
			System.out.println(i);
		}
		
	}

}
