package com.ppsinfo.rsig.jdbc.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.ppsinfo.rsig.jdbc.model.*;

public class ThemeDAOImpl implements ThemeDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Theme selectById(int id) throws InstantiationException,
			IllegalAccessException {
		return CommonOperation.selectById(id, dataSource, Theme.class);
	}

	@Override
	public int insert(BasicData data) throws NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException {
		return CommonOperation.insert(data, dataSource);
	}

	@Override
	public int deleteById(int id) throws SQLException {
		return CommonOperation.deleteById(new Theme().tableName, id, dataSource);
	}

	@Override
	public int update(BasicData data) throws NoSuchFieldException,
			SecurityException, IllegalArgumentException,
			IllegalAccessException, SQLException {
		return CommonOperation.updateById(data, dataSource);
	}

	@Override
	public ArrayList<Theme> selectAll() throws InstantiationException,
			IllegalAccessException, NoSuchFieldException, SecurityException {
		return CommonOperation.selectAll(Theme.class, dataSource);
	}

	@Override
	public ArrayList<Theme> selectWhere(String condition)
			throws InstantiationException, IllegalAccessException,
			NoSuchFieldException, SecurityException {
		return CommonOperation.selectWhere(Theme.class, condition, dataSource);
	}

	@Override
	public ArrayList<Integer> idList() throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		ArrayList<Integer> alId = new ArrayList<Integer>();
		ArrayList<Theme> alThemes = this.selectAll();
		for (Theme theme : alThemes) {
			alId.add(theme.id);
		}
		return alId;
	}

	

}
