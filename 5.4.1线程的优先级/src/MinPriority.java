//定义类MinPriority实现Runnable接口
public class MinPriority implements Runnable{
	public void run() {
		
	for(int i=0;i<10;i++) {
		System.out.println(Thread.currentThread().getName()+"正在输入:"+i);
	}
}
}