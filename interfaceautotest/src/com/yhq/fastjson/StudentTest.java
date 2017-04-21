package com.yhq.fastjson;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

public class StudentTest {
  @Test
  public void f() {
	  Student s = new Student(12,"����",8);
	 // System.out.println(JSON.toJSONString(s));
	  
	  List<Student> students = new ArrayList<Student>();  
      for(int i=0;i<5;i++) {  
          Student stu = new Student(i, "Student" + i, 18 +i);   
          students.add(stu);  
      }  
      System.out.println(JSON.toJSONString(students));

	  
}
  
 // @Test
  public void TestTeacher() {
	  List<Teacher> TeachersList = new ArrayList<Teacher>();
	  for (int i =0;i<5;i++){
		  //������ʦ����
		  Teacher teacher = new Teacher(i,"teachar");
		  List<Student> studentlist = new ArrayList<Student>();
		  Student student = new Student(i,"sutdenta",i);
		  studentlist.add(student);
		  teacher.myStudent = studentlist;
		  TeachersList.add(teacher);
		  
	  }
	  System.out.println(JSON.toJSONString(TeachersList,true));
	  
  }
  @Test
  public void TestTeacher2() {
	  List<Teacher> TeachersList = new ArrayList<Teacher>();
	  for (int i =0;i<5;i++){
		  //������ʦ����
		  Teacher teacher = new Teacher(i,"teachar");
		  List<Student> studentlist = new ArrayList<Student>();
		  Student student = new Student(i,"sutdenta",i);
		  studentlist.add(student);
		  teacher.myStudent = studentlist;
		  TeachersList.add(teacher);
		  
	  }
	  SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Teacher.class, "id","age");  
	  //���л�
      String jsonStu =JSON.toJSONString(TeachersList,filter); 
	  
  }
  
  //�����л������ַ��������л���һ������
  @Test
  public void strToTeacher() {
	   List<Student> students = new ArrayList<Student>();  
       for(int i=0;i<5;i++) {  
           Student stu = new Student(i, "Student" + i, 18 +i);   
           students.add(stu);  
       }  
       // ������Щ������Ҫת��  
//     SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Student.class, "id","age");  
//     String jsonStu =JSON.toJSONString(students,filter);  
       String jsonStu =JSON.toJSONString(students);  
       System.out.println(jsonStu);  
         
       List<Student> stu =JSON.parseObject(jsonStu, new TypeReference<List<Student>>(){});  
       for(int i=0;i<stu.size();i++)   
       {  
           System.out.println(stu.get(i).getAge());  
       }  
	
	  
  }
  
}
