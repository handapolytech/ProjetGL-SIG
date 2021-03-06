package com.ppsinfo.rsig.jdbc.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.ppsinfo.rsig.jdbc.model.*;

public class BlacklistageSystemeDAOImpl implements BlacklistageSystemeDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public BlacklistageSysteme selectById(int id) throws InstantiationException,
			IllegalAccessException {
		return CommonOperation.selectById(id, dataSource, BlacklistageSysteme.class);
	}

	@Override
	public int insert(BasicData data) throws NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException {
		return CommonOperation.insert(data, dataSource);
	}

	@Override
	public int deleteById(int id) throws SQLException {
		return CommonOperation.deleteById(new BlacklistageSysteme().tableName, id, dataSource);
	}

	@Override
	public int update(BasicData data) throws NoSuchFieldException,
			SecurityException, IllegalArgumentException,
			IllegalAccessException, SQLException {
		return CommonOperation.updateById(data, dataSource);
	}

	@Override
	public ArrayList<BlacklistageSysteme> selectAll() throws InstantiationException,
			IllegalAccessException, NoSuchFieldException, SecurityException {
		return CommonOperation.selectAll(BlacklistageSysteme.class, dataSource);
	}

	@Override
	public ArrayList<BlacklistageSysteme> selectWhere(String condition)
			throws InstantiationException, IllegalAccessException,
			NoSuchFieldException, SecurityException {
		return CommonOperation.selectWhere(BlacklistageSysteme.class, condition, dataSource);
	}

	@Override
	public ArrayList<Integer> idSourceList() throws InstantiationException,
			IllegalAccessException, NoSuchFieldException, SecurityException {
		ArrayList<Integer> alIdSource = new ArrayList<Integer>();
		ArrayList<BlacklistageSysteme> al= this.selectAll();
		for (BlacklistageSysteme blc : al) {
			alIdSource.add(blc.id_source);
		}
		return alIdSource;
	}

	

}
