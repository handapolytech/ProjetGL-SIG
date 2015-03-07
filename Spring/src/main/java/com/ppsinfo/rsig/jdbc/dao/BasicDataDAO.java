package com.ppsinfo.rsig.jdbc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import com.ppsinfo.rsig.jdbc.model.*;

public interface BasicDataDAO {

	public BasicData selectById(int id) throws InstantiationException,
			IllegalAccessException;

	public int insert(BasicData data) throws NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException;

	public int deleteById(int id) throws SQLException;

	public int update(BasicData data) throws NoSuchFieldException,
			SecurityException, IllegalArgumentException,
			IllegalAccessException, SQLException;

	public ArrayList<? extends BasicData> selectAll() throws InstantiationException,
			IllegalAccessException, NoSuchFieldException, SecurityException;

	public ArrayList<? extends BasicData> selectWhere(String condition)
			throws InstantiationException, IllegalAccessException,
			NoSuchFieldException, SecurityException;

}
