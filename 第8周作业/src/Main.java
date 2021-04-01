import car.*;
import carFactory.*;
import utility.*;
import ���߳�ģ����Լ��.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaxiBase taxiBase = new TaxiBase();
		TaxiRenter taxiRenter = new TaxiRenter(taxiBase);
		TaxiProvider taxiProvider = new TaxiProvider(taxiBase);
		new Thread(taxiRenter).start();
		new Thread(taxiProvider).start();
	}
	
}
