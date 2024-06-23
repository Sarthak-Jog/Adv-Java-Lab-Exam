package com.studentmvc.daoimpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.studentmv.util.SqlUtil;
import com.studentmvc.dao.StudentDAO;
import com.studentmvc.model.Student;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public int save(Student student) {
		int result = -1;
		try {
			SqlUtil.connectDb();
			SqlUtil.stmt = SqlUtil.conn.prepareStatement("insert into student values(?,?,?,?,?,?)");
			SqlUtil.stmt.setInt(1, student.getId());
			SqlUtil.stmt.setString(2, student.getName());
			SqlUtil.stmt.setString(3, student.getPhone());
			SqlUtil.stmt.setFloat(4, student.getMarks());
			SqlUtil.stmt.setString(5, student.getCity());
			SqlUtil.stmt.setString(6, student.getGender());
			result = SqlUtil.insert();
			SqlUtil.close();
		} catch (Exception e) {
			e.printStackTrace();		
			}
		return result;
	}

	@Override
	public List<Student> getAll() {
		List<Student> students = new ArrayList<Student>();
		try {
			SqlUtil.connectDb();
			SqlUtil.stmt = SqlUtil.conn.prepareStatement("select * from student");
			ResultSet rs = SqlUtil.fetch();
			if(rs!=null) {
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String phone = rs.getString("phone");
					String city = rs.getString("city");
					String gender = rs.getString("gender");
					float marks = rs.getFloat("marks");
					Student student = new Student(id, name, phone, gender,marks, city);
					students.add(student);
				}
			}
			SqlUtil.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public Student getById(int id) {
		Student student = null;
		try {
			SqlUtil.connectDb();
			SqlUtil.stmt = SqlUtil.conn.prepareStatement("select * from student where id=?");
			SqlUtil.stmt.setInt(1, id);
			ResultSet rs = SqlUtil.fetch();
			if(rs!=null) {
				if(rs.next()) {
					student = new Student();
					student.setId(rs.getInt("id"));
					student.setName(rs.getString("name"));
					student.setCity(rs.getString("city"));
					student.setMarks(rs.getFloat("marks"));
					student.setPhone(rs.getString("phone"));
					student.setGender(rs.getString("gender"));
					}
				}
			SqlUtil.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public int remove(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(int id, Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

}
