package factory;
import user.*;
import ����.*;
public class DianxinFactory implements Factory{
	//�������Ź�˾
	public User produceuser() {
		return new Dianxin();
	}
}
