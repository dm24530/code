
public class TicketWindow implements Runnable{

	 int tickets = 100;
		public void run(){
			while(true) {
			if(tickets > 0) {
				Thread th = Thread.currentThread();
				String th_name = th.getName();
				System.out.println(th_name + "������Ʊ" + tickets + "��Ʊ");
				tickets--;
			}
			else
				break;
		}
		}
}
