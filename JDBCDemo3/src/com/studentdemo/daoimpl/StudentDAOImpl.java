package com.studentdemo.daoimpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.studentdemo.dao.StudentDAO;
import com.studentdemo.model.Student;
import com.studentdemo.utility.StudentUtil;

public class StudentDAOImpl implements StudentDAO {
	
	@Override
	public int save(Student student) {
		int result = -1;
		try {
			StudentUtil.connectDb();
			String qry = "insert into student values ('"+student.getId()+"','"+student.getName()+"','"+student.getMarks()+"')";
			result = StudentUtil.insert(qry);
			StudentUtil.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	@Override
	public List<Student> getAll() {
		List<Student> students = new ArrayList<Student>();
		try {
			StudentUtil.connectDb();
			String qry = "select * from student";
			ResultSet rs = StudentUtil.fetch(qry);
			if(rs!=null) {
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					float marks = rs.getFloat("marks");
					Student student = new Student(id,name,marks);
					students.add(student);
				}
			}
			StudentUtil.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return students;
	}

	@Override
	public Student getById(int id) {
		Student student = null;
		try {
			StudentUtil.connectDb();
			String qry = "select * from student where id="+id;
			ResultSet rs = StudentUtil.fetch(qry);
			if(rs!=null) {
				while(rs.next()) {
					int studentId = rs.getInt("id");
					String name = rs.getString("name");
					float marks = rs.getFloat("marks");
					student = new Student();
					student.setId(studentId);
					student.setName(name);
					student.setMarks(marks);
				}
			}
			StudentUtil.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return student;
	}

	@Override
	public int remove(int id) {
		int result = -1;
		try {
			StudentUtil.connectDb();
			String qry = "delete from student where id="+id;
			result = StudentUtil.delete(qry);
			StudentUtil.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	@Override
	public int update(int id, Student student) {
		int result = -1;
		try {
			StudentUtil.connectDb();
			String qry = "update student set id='"+student.getId()+"', name='"+student.getName()+"', marks='"+student.getMarks()+"'where id="+id;
			result = StudentUtil.update(qry);
			StudentUtil.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

}
