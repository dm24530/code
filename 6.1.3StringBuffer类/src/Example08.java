
public class Example08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1�����----------");
		add();
		System.out.println("2��ɾ��-----------");
		remove();
		System.out.println("3���޸�-----------");
		alter();
	}
	public static void add() {
		StringBuffer sb=new StringBuffer();    //����һ���ַ���������
		sb.append("abcdefg");                 //��ĩβ����ַ�
		System.out.println("append��ӽ����"+sb);
		sb.insert(2,"123");                  //��ָ��λ������ַ�
		System.out.println("insert��ӵĽ����"+sb);
	}
	public static void remove() {
		StringBuffer sb=new StringBuffer("abcdefg");
		sb.delete(1, 5);           //ָ��λ��ɾ��
		System.out.println("ɾ��ָ��λ�õĽ����"+sb);
		sb.deleteCharAt(2);    
		System.out.println("ָ��λ��ɾ����Ľ����"+sb);
		sb.delete(0, sb.length());
		System.out.println("��ջ������Ľ����"+sb);
	}
	public static void alter() {
		StringBuffer sb =new StringBuffer("abcdefg");
		sb.setCharAt(1, 'p');
		System.out.println("�޸�ָ��λ���ַ������"+sb);
		sb.replace(1, 3, "qq");
		System.out.println("�滻ָ��λ���ַ����Ľ����"+sb);
		System.out.println("�ַ�����ת�����"+sb.reverse());
	}

}
