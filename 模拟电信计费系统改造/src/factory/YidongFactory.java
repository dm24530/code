package factory;
import user.*;
import ����.*;
public class YidongFactory implements Factory{
	//		�����ƶ���˾
	public User produceuser() {
		return new Yidong();
	}
}
