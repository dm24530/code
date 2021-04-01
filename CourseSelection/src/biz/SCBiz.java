package biz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import java.util.Scanner;

import dao.CourseDao;
import dao.SCDao;
import dao.StudentDao;
import entity.Course;
import entity.SC;
import entity.Student;
import view.MainUI;

public class SCBiz {
	static StudentDao studentDao;
	static CourseDao coursedao;
	static SCDao scDao;
	private SC sc;
	private static Student student;
	private ArrayList<String> al;
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void judge(String studentNo){
		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);

			System.out.println("1-ѡ�Σ�2-��ѡ��3-��ѡ�γ�����鿴��0-����������");
			System.out.println("���������ѡ��");
			Scanner in = new Scanner(System.in);
			String s = in.nextLine();
			if("1".equals(s) || "2".equals(s)) {
			switch (s) {
			case "1": //ѡ�β���
			   selection(studentNo);
			   break;
			case "2": //��ѡ����
				exitRace(studentNo);
			}
		  }else if("3".equals(s)) {
			  File file = new File("sc1.txt"); 
			  getTxt(file,studentNo);
		  }else if("0".equals(s)) {
			  MainUI.show(studentNo); 
		  }
	}
	/*
	 * ѡ�β���
	 */
	public static void selection(String studentNo){
		//ѡ�ο�ʼ
		CourseDao courseDao = CourseDao.getInstance();
		StudentDao studentDao = StudentDao.getInstance();
		SCDao scDao = SCDao.getInstance();
		Map<String, Course> courses = courseDao.show();
		System.out.println("--------------���пγ���Ϣ------------------");
		for (Course course : courses.values()) {
			System.out.println("�γ̱��:"+course.getCourseNo()+",�γ�����:"+course.getCourseName()+",�γ�ѧ��:"+course.getCourseGrade());
		}
		Scanner in = new Scanner(System.in);
		System.out.println("��������ѡ�γ̱��");
	    String courseNo = in.next();
		Course entity = (Course)courseDao.getEntity(courseNo);
		if (entity == null){
			System.out.println("��ѡ�γ̲�����");
			MainUI.show(studentNo);
		}else{
			int s = Integer.parseInt(courseNo);
			SC sc = (SC) scDao.getEntity(studentNo);
			Student student = (Student) studentDao.getEntity(studentNo);

			String[] ke={"���������","���������ϵͳ","�����Ӧ��","��ѧ����","���Դ���","��ɢ��ѧ"};
			try{
				File file = new File("sc1.txt");                                  // ����һ��file���󣬲���������������ļ���·��
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				List list =new ArrayList();                                         //����һ�����ϴ��ÿһ�е��ַ���
				while(true){
				    String str=br.readLine();                                       //��ȡ�ļ����е�һ��
				    if(str==null) 
				    	break;                                            //�����ȡ���ǿգ�Ҳ�����ļ���ȡ���� ����ѭ��
				    int index=str.indexOf(student.getStudentName());                                       //�����е��Ƿ�Ϊ�û���Ϣ
				    if(index != -1){
				    	int index1=str.indexOf(ke[s-1]);                                  //�����Ƿ�����ѡ�γ� ����������ֵ>=0		        
				    	System.out.println(index1);
				    	if(index1>0){  
				    	    System.out.println("ѡ��ʧ�ܣ��ÿγ�" + ke[s-1] + "��ѡ!");                 //��������ͷ��أ�ѡ��ʧ��
				    	   // return;
				    	    SCBiz.selection(studentNo);
				        }
				        else{
				        	System.out.println(ke[s-1] + "ѡ�γɹ���");
				    	    str=str+","+ke[s-1];                                           //��������ѡ�γɹ�������ѡ�γ̼����ļ���                                               
				        }
				    }
				    list.add(str);                                                   //���޸�֮���str�ŵ����ϵ���
				}
			br.close();
			PrintWriter pw=new PrintWriter(file);                               //����һ����������Ѷ���д���ļ�
			for(int i=0;i<list.size();i++){
				String str =(String)list.get(i);                                //�Ӽ��ϵ���ȡ���ַ���
				pw.println(str);                                                //�Ѹ��ַ���д���ļ�����
				}
			pw.close();
			} catch (Exception e){
			       e.printStackTrace();
			   }
			judge(studentNo);
		}
	}

	/*
	 * ��ѡ����
	 */
	private static void exitRace(String studentNo) {
		//��ѡ��ʼ
				CourseDao courseDao = CourseDao.getInstance();
				StudentDao studentDao = StudentDao.getInstance();
				SCDao scDao = SCDao.getInstance();
				Map<String, Course> courses = courseDao.show();
				System.out.println("--------------���пγ���Ϣ------------------");
				for (Course course : courses.values()) {
					System.out.println("�γ̱��:"+course.getCourseNo()+",�γ�����:"+course.getCourseName()+",�γ�ѧ��:"+course.getCourseGrade());
				}
				Scanner in = new Scanner(System.in);
				System.out.println("��������ѡ�γ̱��");
			    String courseNo = in.next();
				Course entity = (Course)courseDao.getEntity(courseNo);
				if (entity == null){
					System.out.println("��ѡ�γ̲�����");
					MainUI.show(studentNo);
				}else{
					int s = Integer.parseInt(courseNo);
					SC sc = (SC) scDao.getEntity(studentNo);
					Student student = (Student) studentDao.getEntity(studentNo);
					
					String[] ke={"���������","���������ϵͳ","�����Ӧ��","��ѧ����","���Դ���","��ɢ��ѧ"};
					try{
						File file = new File("sc1.txt");                                  // ����һ��file���󣬲���������������ļ���·��
						BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
						List list =new ArrayList();                                         //����һ�����ϴ��ÿһ�е��ַ���
						while(true){
						    String str=br.readLine();                                       //��ȡ�ļ����е�һ��
						    if(str==null) break;                                            //�����ȡ���ǿգ�Ҳ�����ļ���ȡ���� ����ѭ��
						    int index=str.indexOf(student.getStudentName());                                       //�����е��Ƿ�Ϊ�û���Ϣ
						    if(index == 0){
						    	int index1=str.indexOf(ke[s-1]);                                  //�����Ƿ�����ѡ�γ� ����������ֵ>=0		        
						    	System.out.println(index1);
						    	if(index1<0){  
						    	    System.out.println("��ѡʧ�ܣ��ÿγ�" + ke[s-1] + "δѡ!");                 //��������ͷ��أ�ѡ��ʧ��
						    	   // return;
						    	    SCBiz.selection(studentNo);
						        }
						        else{
						        	str=str.replace(","+ke[s-1],"");
						        	System.out.println(ke[s-1] + "��ѡ�ɹ���");
						    	    //str=str+","+ke[s-1];  //��������ѡ�γɹ�������ѡ�γ̼����ļ���     
						        	   
						        }
						    }
						    list.add(str);                                                   //���޸�֮���str�ŵ����ϵ���
						}
					br.close();
					PrintWriter pw=new PrintWriter(file);                               //����һ����������Ѷ���д���ļ�
					for(int i=0;i<list.size();i++){
						String str =(String)list.get(i);                                //�Ӽ��ϵ���ȡ���ַ���
						pw.println(str);                                                //�Ѹ��ַ���д���ļ�����
						}
					pw.close();
					} catch (Exception e){
					       e.printStackTrace();
					   }
					judge(studentNo);
				}
			}
	/*
	 * �γ�����鿴
	 */
	private static void showAllCourse() {
	
	}
	public static String getTxt(File file,String studentNo){
		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);
		StringBuilder result = new StringBuilder();
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));//����һ��BufferedReader������ȡ�ļ�
			
			String s = null;
			while((s = br.readLine())!=null){//ʹ��readLine������һ�ζ�һ��
				int index=s.indexOf(student.getStudentName());
				if(index==0) {
					System.out.println(s);
				}
				 
			}
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		judge(studentNo);
		return result.toString();
	}
	/*
	 * ��ѡ�γ�����鿴
	 *//*
	private static void showSeleceCourse() {
		scDao = SCDao.getInstance();
		scb = scDao.getAllEntities();
		Set<String> keySet = scb.keySet();
		System.out.println("���е���ѡ�γ���Ϣ��");
		Iterator it = keySet.iterator();
		while(it.hasNext()) {
			Object key = it.next();
			SC value = (SC)scb.get(key);
			System.out.println(value.getStudentNo()+","+value.getCourseNo()+","+value.getGrade());
		}
		judge(student.getStudentNo());
	}
	/*
	 * �жϿγ��Ƿ����
	 */
	/*
	public static boolean judgeCourse() {
		coursedao = CourseDao.getInstance();
		cs = coursedao.getAllEntities();
		Set<String> keySet = cs.keySet();
		System.out.println("������γ̱�ţ�");
		String courseNo = scanner.nextLine();
		 boolean blnExists = cs.containsKey(courseNo);
		 System.out.println(blnExists);
		return blnExists;
	}
	
	private void save() {
		StudentDao dbutil = StudentDao.getInstance();
		dbutil.update();
	}
	private void save2() {
		SCDao dbutil = SCDao.getInstance();
		dbutil.update();
	}
	*/
}
