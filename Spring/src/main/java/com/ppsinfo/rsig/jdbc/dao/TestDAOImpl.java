package com.ppsinfo.rsig.jdbc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import com.ppsinfo.rsig.jdbc.model.Test;

public class TestDAOImpl implements TestDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Test selectById(int id) throws InstantiationException,
			IllegalAccessException {
		return CommonOperation.selectById(id, dataSource, Test.class);
	}

	@Override
	public int insert(Test data) throws NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException {
		return CommonOperation.insert(data, dataSource);
	}

	@Override
	public int deleteById(int id) throws SQLException {
		return CommonOperation.deleteById(new Test().tableName, id, dataSource);
	}

	@Override
	public int update(Test data) throws NoSuchFieldException,
			SecurityException, IllegalArgumentException,
			IllegalAccessException, SQLException {
		return CommonOperation.updateById(data, dataSource);
	}

	@Override
	public ArrayList<Test> selectAll() throws InstantiationException,
			IllegalAccessException, NoSuchFieldException, SecurityException {
		return CommonOperation.selectAll(Test.class, dataSource);
	}

	@Override
	public ArrayList<Test> selectWhere(String condition)
			throws InstantiationException, IllegalAccessException,
			NoSuchFieldException, SecurityException {
		return CommonOperation.selectWhere(Test.class, condition, dataSource);
	}

}
