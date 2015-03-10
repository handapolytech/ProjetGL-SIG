package com.ppsinfo.rsig.jdbc.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.ppsinfo.rsig.jdbc.model.*;

public class AbonnementRelationDAOImpl implements AbonnementRelationDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public AbonnementRelation selectById(int id) throws InstantiationException,
			IllegalAccessException {
		return CommonOperation.selectById(id, dataSource, AbonnementRelation.class);
	}

	@Override
	public int insert(BasicData data) throws NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException {
		return CommonOperation.insert(data, dataSource);
	}

	@Override
	public int deleteById(int id) throws SQLException {
		return CommonOperation.deleteById(new AbonnementRelation().tableName, id, dataSource);
	}

	@Override
	public int update(BasicData data) throws NoSuchFieldException,
			SecurityException, IllegalArgumentException,
			IllegalAccessException, SQLException {
		return CommonOperation.updateById(data, dataSource);
	}

	@Override
	public ArrayList<AbonnementRelation> selectAll() throws InstantiationException,
			IllegalAccessException, NoSuchFieldException, SecurityException {
		return CommonOperation.selectAll(AbonnementRelation.class, dataSource);
	}

	@Override
	public ArrayList<AbonnementRelation> selectWhere(String condition)
			throws InstantiationException, IllegalAccessException,
			NoSuchFieldException, SecurityException {
		return CommonOperation.selectWhere(AbonnementRelation.class, condition, dataSource);
	}

	@Override
	public ArrayList<Integer> listeIdSourceByIdUtilisateur(int idu) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		ArrayList<Integer> alId = new ArrayList<Integer>();
		ArrayList<AbonnementRelation> alAR = CommonOperation.selectWhere(AbonnementRelation.class, "id_utilisateur="+idu, dataSource);
		for (AbonnementRelation abonnementRelation : alAR) {
			alId.add(abonnementRelation.id_source);
		}
		return alId;
	}

	@Override
	public ArrayList<Source> listSourceByIdUtilisateur(int idu) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		ArrayList<Source> alSource = new ArrayList<Source>();
		ArrayList<AbonnementRelation> alAR = CommonOperation.selectWhere(AbonnementRelation.class, "id_utilisateur="+idu, dataSource);
		for (AbonnementRelation abonnementRelation : alAR) {
			alSource.add(CommonOperation.selectById(abonnementRelation.id_source, dataSource, Source.class));
		}
		return alSource;
	}

	@Override
	public ArrayList<Source> listSourceByIdUtilisateurAvecMasquage(int idu)
			throws InstantiationException, IllegalAccessException,
			NoSuchFieldException, SecurityException {
		ArrayList<Source> alSource = listSourceByIdUtilisateur(idu);
		BlacklistageSystemeDAOImpl blcDAO = new BlacklistageSystemeDAOImpl();
		blcDAO.setDataSource(dataSource);
		ArrayList<Integer> alIdSourceMasquee = blcDAO.idSourceList();
		ArrayList<Source> result= new ArrayList<Source>();
		for (Source source : alSource) {
			if (!alIdSourceMasquee.contains(source.id)) {
				result.add(source);
			}
		}
		return result;
	}

	

}
