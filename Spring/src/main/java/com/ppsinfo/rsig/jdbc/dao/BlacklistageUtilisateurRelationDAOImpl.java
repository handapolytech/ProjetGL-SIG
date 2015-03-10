package com.ppsinfo.rsig.jdbc.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.ppsinfo.rsig.jdbc.model.*;

public class BlacklistageUtilisateurRelationDAOImpl implements BlacklistageUtilisateurRelationDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public BlacklistageUtilisateurRelation selectById(int id) throws InstantiationException,
			IllegalAccessException {
		return CommonOperation.selectById(id, dataSource, BlacklistageUtilisateurRelation.class);
	}

	@Override
	public int insert(BasicData data) throws NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException {
		return CommonOperation.insert(data, dataSource);
	}

	@Override
	public int deleteById(int id) throws SQLException {
		return CommonOperation.deleteById(new BlacklistageUtilisateurRelation().tableName, id, dataSource);
	}

	@Override
	public int update(BasicData data) throws NoSuchFieldException,
			SecurityException, IllegalArgumentException,
			IllegalAccessException, SQLException {
		return CommonOperation.updateById(data, dataSource);
	}

	@Override
	public ArrayList<BlacklistageUtilisateurRelation> selectAll() throws InstantiationException,
			IllegalAccessException, NoSuchFieldException, SecurityException {
		return CommonOperation.selectAll(BlacklistageUtilisateurRelation.class, dataSource);
	}

	@Override
	public ArrayList<BlacklistageUtilisateurRelation> selectWhere(String condition)
			throws InstantiationException, IllegalAccessException,
			NoSuchFieldException, SecurityException {
		return CommonOperation.selectWhere(BlacklistageUtilisateurRelation.class, condition, dataSource);
	}

	@Override
	public ArrayList<Source> listeSourceMasqueeByIdUser(int idu) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		ArrayList<Source> alSource = new ArrayList<Source>();
		ArrayList<BlacklistageUtilisateurRelation> alAR = CommonOperation.selectWhere(BlacklistageUtilisateurRelation.class, "id_utilisateur="+idu, dataSource);
		for (BlacklistageUtilisateurRelation blacklistageUtilisateurRelation : alAR) {
			alSource.add(CommonOperation.selectById(blacklistageUtilisateurRelation.id_source, dataSource, Source.class));
		}
		return alSource;
	}

	@Override
	public ArrayList<Source> listeSourceDispoByIdUser(int idu)
			throws InstantiationException, IllegalAccessException,
			NoSuchFieldException, SecurityException {
		ArrayList<Source> alSources = new ArrayList<Source>();
		ArrayList<Source> alSourcesComplet = CommonOperation.selectAll(Source.class, dataSource);
		ArrayList<Integer> alIdSourcesMasqueUser = listeIdSourceMasqueeByIdUser(idu);
		ArrayList<Integer> alIdSourcesMasqueSys = new ArrayList<Integer>();
		ArrayList<BlacklistageSysteme> alBlc= CommonOperation.selectAll(BlacklistageSysteme.class, dataSource);
		for (BlacklistageSysteme blc : alBlc) {
			alIdSourcesMasqueSys.add(blc.id_source);
		}
		for (Source s : alSourcesComplet) {
			if (alIdSourcesMasqueSys.contains(s.id) || alIdSourcesMasqueUser.contains(s.id)) {
				
			}else {
				alSources.add(s);
			}
		}
		return alSources;
	}

	@Override
	public ArrayList<Integer> listeIdSourceMasqueeByIdUser(int idu)
			throws InstantiationException, IllegalAccessException,
			NoSuchFieldException, SecurityException {
		ArrayList<Integer> alSource = new ArrayList<Integer>();
		ArrayList<BlacklistageUtilisateurRelation> alAR = CommonOperation.selectWhere(BlacklistageUtilisateurRelation.class, "id_utilisateur="+idu, dataSource);
		for (BlacklistageUtilisateurRelation blacklistageUtilisateurRelation : alAR) {
			alSource.add(blacklistageUtilisateurRelation.id_source);
		}
		return alSource;
	}

	

}
