package factory;
import user.*;
import ����.*;

public class LiantongFactory implements Factory{
	//������ͨ��˾
	public User produceuser() {
		return new Liantong();
	}
}
