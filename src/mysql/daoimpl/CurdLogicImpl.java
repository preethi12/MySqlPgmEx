package mysql.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mysql.bean.Employee;
import mysql.dao.Crudlogic;
import mysql.dbconnection.DatabaseConnection;

public class CurdLogicImpl implements Crudlogic {

	private Connection connection;
	String sql;
	private static PreparedStatement ps;
	private static ResultSet rs;
	
	CurdLogicImpl()
	{
		connection=DatabaseConnection.getCon();
	}
	@Override
	public void insertData(Employee emp) throws Exception
	{
	sql="insert into Employee values(?,?,?,?)";
	
	ps=connection.prepareStatement(sql);
	ps.setInt(1, emp.getId());
	ps.setString(2, emp.getName());
	ps.setString(3, emp.getAddress());
	ps.setDouble(4, emp.getSalary());
	ps.executeUpdate();
	System.out.println("data inserted");
	System.out.println(emp.getId()+","+emp.getName()+","+emp.getAddress()+","+emp.getSalary());
		
	}
	public void updateData(Employee emp,int empid)throws Exception
	{
		sql="update Employee set name=? where id='"+empid+"'";
		ps=connection.prepareStatement(sql);
		ps.setString(1, emp.getName());
		ps.executeUpdate();
		System.out.println("data updated .....");
		
	}
	
	@Override
	public void deleteData(int id) throws Exception {
		sql="delete from Employee  where id='"+id+"'";
		ps=connection.prepareStatement(sql);
		ps.executeUpdate();
		System.out.println("Data deleted...");
		
	}
	
	@Override
	public void getData() throws Exception {
		sql="select * from Employee";
		ps=connection.prepareStatement(sql);
		rs=ps.executeQuery();
		Employee emp=new Employee();
		while(rs.next())
		{
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setAddress(rs.getString(3));
			emp.setSalary(rs.getDouble(4));
			System.out.println(emp);
		}

	}
	public static void main(String[] args) throws Exception
	{
		CurdLogicImpl cl=new CurdLogicImpl();
			Employee em=new Employee();
		em.setId(6);
		em.setName("Pintu");
		em.setAddress("Salem");
		em.setSalary(45000);
		cl.insertData(em);
		/*		Employee em1=new Employee();
		em1.setName("pintu");
	
		cl.updateData(em1, 1);*/
	//	cl.deleteData(1);
		cl.getData();
		
		
		
	}



	
}
