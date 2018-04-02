package mysql.dao;

import mysql.bean.Employee;

public interface Crudlogic 
{
public void insertData(Employee emp) throws Exception;
public void updateData(Employee emp,int empid)throws Exception;
public void deleteData(int id) throws Exception;
public void getData() throws Exception;
}
