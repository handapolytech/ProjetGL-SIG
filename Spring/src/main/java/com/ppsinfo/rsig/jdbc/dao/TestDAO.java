package com.ppsinfo.rsig.jdbc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import com.ppsinfo.rsig.jdbc.model.*;

public interface TestDAO {

	public Test selectById(int id) throws InstantiationException,
			IllegalAccessException;

	public int insert(Test data) throws NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException;

	public int deleteById(int id) throws SQLException;

	public int update(Test data) throws NoSuchFieldException,
			SecurityException, IllegalArgumentException,
			IllegalAccessException, SQLException;

	public ArrayList<Test> selectAll() throws InstantiationException,
			IllegalAccessException, NoSuchFieldException, SecurityException;

	public ArrayList<Test> selectWhere(String condition)
			throws InstantiationException, IllegalAccessException,
			NoSuchFieldException, SecurityException;

}
