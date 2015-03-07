package com.ppsinfo.rsig.jdbc.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.ppsinfo.rsig.jdbc.model.*;

public class ThemeRelationDAOImpl implements ThemeRelationDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public ThemeRelation selectById(int id) throws InstantiationException,
			IllegalAccessException {
		return CommonOperation.selectById(id, dataSource, ThemeRelation.class);
	}

	@Override
	public int insert(BasicData data) throws NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException {
		return CommonOperation.insert(data, dataSource);
	}

	@Override
	public int deleteById(int id) throws SQLException {
		return CommonOperation.deleteById(new ThemeRelation().tableName, id, dataSource);
	}

	@Override
	public int update(BasicData data) throws NoSuchFieldException,
			SecurityException, IllegalArgumentException,
			IllegalAccessException, SQLException {
		return CommonOperation.updateById(data, dataSource);
	}

	@Override
	public ArrayList<ThemeRelation> selectAll() throws InstantiationException,
			IllegalAccessException, NoSuchFieldException, SecurityException {
		return CommonOperation.selectAll(ThemeRelation.class, dataSource);
	}

	@Override
	public ArrayList<ThemeRelation> selectWhere(String condition)
			throws InstantiationException, IllegalAccessException,
			NoSuchFieldException, SecurityException {
		return CommonOperation.selectWhere(ThemeRelation.class, condition, dataSource);
	}

	

}
