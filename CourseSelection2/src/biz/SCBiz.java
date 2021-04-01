package biz;

import view.CourseSelection;
import view.MainUI;
import dao.*;
import entity.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
import dao.*;

public class SCBiz {
	StudentDao studentDao;
	CourseDao coursedao;
	SCDao scDao;
	Course course;
	private SC sc;
	private Student student;
	private HashMap<String, IEntity> cs;
	private HashMap<String, IEntity> scb;
	private ArrayList<Course> selectedCourses;
	private HashMap<String,ArrayList> scs;
	Scanner scanner = new Scanner(System.in);
	
	public void judge(String studentNo){
		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);

		
			System.out.println("1-ѡ�Σ�2-��ѡ��3-������ѡ�γ�����鿴��4-ȫ����ѡ�γ�����鿴��0-����������");
			System.out.println("���������ѡ��");
			Scanner in = new Scanner(System.in);
			String s = in.nextLine();
			if("1".equals(s) || "2".equals(s)) {
			switch (s) {
			case "1": //ѡ�β���
			   addCourse(studentNo);
			   break;
			case "2": //��ѡ����
				/*
				Scanner scanner1 = new Scanner(System.in);
				System.out.println("������γ̱�ţ�");
				String courseNo1 = scanner1.nextLine();
			    exitRace(studentNo,courseNo1);
			    break;
			    */
			}
		  }else if("3".equals(s)) {
			  selfShowSeleceCourse(studentNo); 
		  }else if("4".equals(s)) {
			  showSeleceCourse(); 
		  }else if("0".equals(s)) {
			  MainUI.show(studentNo); 
		  } else {
			System.out.println("��ע�⣬ѧԺ��д����");
			CourseSelection.show(studentNo);
		}
	}
	/*
	 * ѡ�β���
	 */
	private void addCourse(String studentNo) {
		selectedCourses= new ArrayList();
		scDao=SCDao.getInstance();
		showAllCourse();
		coursedao=CourseDao.getInstance();
		
		Scanner ins = new Scanner(System.in);
		System.out.println("������γ̱�ţ�");
		String courseNo = ins.nextLine();
		if(judgeCourse(courseNo)==true) {
			
		
		course=new Course();
		sc = new SC();
		course = (Course) coursedao.getEntity(courseNo);
		sc=(SC) SCDao.getInstance().getEntity(studentNo);
		sc.getCourseInformation().add(course);
		//selectedCourses.add(course);
//          sc.setStudentNo(studentNo);     //���γ���Ϣ����
//          sc.setCourseInformation(selectedCourses);
          
         // scDao = SCDao.getInstance();
          scDao.insert(sc);
            save2();
          System.out.println(course.getCourseName()+"ѡ��ɹ���");
          judge(student.getStudentNo());
          }else {
        	  System.out.println("��ѡ��Ŀ�����ڣ�����������");
        	  addCourse(studentNo);
          }
}
	/*
	 * ��ѡ����
	 */
	private void exitRace(String studentNo,
            String courseNo) {
		scDao = SCDao.getInstance();
		scb = scDao.getAllEntities();
		Set<String> keySet = scb.keySet();
		scb.remove(courseNo);
		System.out.println(sc.getCourseNo()+"�γ���ѡ�ɹ���");
		save2();
		MainUI.show(studentNo);
		/*
		Scanner in = new Scanner(System.in);
		String id = in.next();	
		if(!id.equals("end")) {			
			Course cr = map2.get(id);	
			courses.remove(cr);		
			map2.remove(id);		
			System.out.println("�Ƴ��ɹ�");
		}
*/

	}
	/*
	 * �γ�����鿴
	 */
	private void showAllCourse() {
		
		coursedao = CourseDao.getInstance();
		cs = coursedao.getAllEntities();
		Set<String> keySet = cs.keySet();
		System.out.println("����ѡ����Ϣ��");
		Iterator it = keySet.iterator();
		while(it.hasNext()) {
			Object key = it.next();
			Course value = (Course)cs.get(key);
			System.out.println("�γ̱�ţ�"+value.getCourseNo()+","+"�γ����ƣ�"+value.getCourseName()+","+"�γ�ѧ�֣�"+value.getCourseGrade());
		}
		
	}
	/*
	 * ������ѡ�γ�����鿴
	 */
	private void showSeleceCourse() {
		coursedao = CourseDao.getInstance();
		cs = coursedao.getAllEntities();
		scDao = SCDao.getInstance();
		scb = scDao.getAllEntities();
		Set<String> keySet = scb.keySet();
		System.out.println("���е���ѡ�γ���Ϣ��");
		Iterator it = keySet.iterator();
		while(it.hasNext()) {
			Object key = it.next();
			SC value = (SC)scb.get(key);
			System.out.println(value.getStudentNo()+","+value.getCourseInformation().get(0));
		}
		judge(student.getStudentNo());
	}
	/*
	 * ������ѡ�γ�����鿴
	 */
	private void selfShowSeleceCourse(String studentNo) {
		coursedao = CourseDao.getInstance();
		cs = coursedao.getAllEntities();
		scDao = SCDao.getInstance();
		scb = scDao.getAllEntities();
		Set<String> keySet = scb.keySet();
		System.out.println("���е���ѡ�γ���Ϣ��");
		Iterator it = keySet.iterator();
		while(it.hasNext()) {
			Object key = it.next();
			SC value = (SC)scb.get(key);
			if(studentNo.equals(value.getStudentNo())) {
			System.out.println(value.getStudentNo()+","+value.getCourseInformation().get(0));
		    }
	    }
		judge(student.getStudentNo());
	}
	/*
	 * �жϿγ��Ƿ����
	 */
	public boolean judgeCourse(String courseNo) {
		coursedao = CourseDao.getInstance();
		cs = coursedao.getAllEntities();
		 boolean blnExists = cs.containsKey(courseNo);
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
}
