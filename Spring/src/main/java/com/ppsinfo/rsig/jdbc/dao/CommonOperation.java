package com.ppsinfo.rsig.jdbc.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.ppsinfo.rsig.jdbc.model.*;

public class CommonOperation {

	/**
	 * Inserer une donnée dans la BD, retourner l'id pour la ligne insérer (0 si
	 * echec)
	 * 
	 * @param data
	 *            la donnée à insérer
	 * @param dataSource
	 *            info de connexion pour la BD
	 * @return nombre de ligne insérée
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 */
	public static int insert(BasicData data, DataSource dataSource)
			throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {
		// Template pour la connextion a la BD
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		// résultat de l'exécution
		// Noms des colonnes
		String[] columNames = data.getDefautUpdateColumns();
		// Requete
		String sql = "INSERT INTO " + data.getTableName() + " VALUES (";
		// Ajouter les champs
		if (columNames.length > 1) {
			for (int i = 0; i < columNames.length - 1; i++) {
				Class<?> c = data.getClass();
				// Récupérer l'attribut de l'objet data qui prote le nom "name"
				Field field = c.getDeclaredField(columNames[i]);
				if (field.get(data) == null) {
					sql += "null,";
				} else if (field.get(data).getClass().equals(Date.class)) {
					// Formater la date pour adapter au DateFormat de SQL
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					sql += "'" + df.format((Date) field.get(data)) + "',";

				} else {
					sql += "'" + field.get(data) + "',";
				}
			}
		}
		Class<?> c = data.getClass();
		// Traiter la date
		Field field = c.getDeclaredField(columNames[columNames.length - 1]);
		if (field.get(data) == null) {
			sql += "null,";
		} else if (field.get(data).getClass().equals(Date.class)) {
			// Formater la date pour adapter au DateFormat de SQL
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			sql += "'" + df.format((Date) field.get(data)) + "'";

		} else {
			sql += "'" + field.get(data) + "'";
		}
		// compléter la fin de la requete
		sql += ")";
		final String sqlFinal = sql;
		// Exécuter la requete et récupérer l'id pour la nouvelle ligne insérée
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sqlFinal,
						Statement.RETURN_GENERATED_KEYS);
				return ps;
			}
		}, holder);
		return holder.getKey().intValue();

	}

	/**
	 * Selectionnner une ligne de données avec id
	 * 
	 * @param id
	 * @param dataSource
	 * @param classT
	 *            la classe de la donnée selectionné
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static <T extends BasicData> T selectById(int id,
			DataSource dataSource, final Class<T> classT)
			throws InstantiationException, IllegalAccessException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		// Noms des colonnes
		T instanceData = classT.newInstance();
		final String[] columnNames = instanceData.getDefautUpdateColumns();
		// Requete
		String sql = "SELECT * FROM " + instanceData.getTableName()
				+ " WHERE id = ?";
		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse
		instanceData = jdbcTemplate.queryForObject(sql, new Object[] { id },
				new RowMapper<T>() {

					@Override
					public T mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						T t;
						try {
							t = classT.newInstance();
							for (String columnName : columnNames) {
								Field field = classT
										.getDeclaredField(columnName);
								field.set(t, rs.getObject(columnName));
							}
							return t;
						} catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							return null;
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							return null;
						} catch (NoSuchFieldException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							return null;
						} catch (SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							return null;
						}
					}
				});
		return instanceData;
	}

	/**
	 * Supprimer une donnée depuis son id
	 * 
	 * @param tableName
	 * @param id
	 * @param dataSource
	 *            info de connexion pour la BD
	 * @return
	 * @throws SQLException
	 */
	public static int deleteById(String tableName, int id, DataSource dataSource)
			throws SQLException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		// Requete
		String sql = "DELETE FROM " + tableName + " WHERE id=" + id;
		return jdbcTemplate.update(sql);
	}

	/**
	 * Modifier une donnée Attention: C'est l'id de data qui détermine la donnée
	 * à mettre à jour
	 * 
	 * @param data
	 * @param dataSource
	 *            info de connexion pour la BD
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 */
	public static int updateById(BasicData data, DataSource dataSource)
			throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, SQLException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		// résultat de l'exécution
		int result = 0;
		// Noms des colonnes
		String[] columNames = data.getDefautUpdateColumns();
		// Requete
		String sql = "UPDATE " + data.getTableName() + " SET ";
		// Ajouter les champs
		if (columNames.length > 1) {
			for (int i = 0; i < columNames.length - 1; i++) {
				if (!columNames[i].equals("id")) {
					Class<?> c = data.getClass();
					// Récupérer l'attribut de l'objet data qui prote le nom
					// "name"
					Field field = c.getDeclaredField(columNames[i]);
					if (field.get(data) == null) {
						sql += columNames[i] + "='',";
					} else {
						sql += columNames[i] + "='" + field.get(data) + "',";
					}
				}
			}
		}
		Class<?> c = data.getClass();
		// Récupérer l'attribut de l'objet data qui prote le nom "name"
		Field field = c.getDeclaredField(columNames[columNames.length - 1]);
		if (field.get(data) == null) {
			sql += columNames[columNames.length - 1] + "=''";
		} else if (field.get(data).getClass().equals(Date.class)) {
			// Formater la date pour adapter au DateFormat de SQL
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			sql += columNames[columNames.length - 1] + "='"
					+ df.format((Date) field.get(data)) + "'";

		} else {
			sql += columNames[columNames.length - 1] + "='" + field.get(data)
					+ "'";
		}
		// compléter la fin de la requet
		field = c.getDeclaredField("id");
		sql += " WHERE id=" + field.get(data);
		// debug
		// System.out.println(sql);
		// Exécuter la requete
		result = jdbcTemplate.update(sql);
		return result;
	}

	/**
	 * Selectionner tous les données dans un tableau
	 * 
	 * @param classT
	 * @param dataSource
	 *            info de connexion pour la BD
	 * @return Les lignes selectionnés, taille = 0 si aucune résultat
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static <T extends BasicData> ArrayList<T> selectAll(Class<T> classT,
			DataSource dataSource) throws InstantiationException,
			IllegalAccessException, NoSuchFieldException, SecurityException {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		// résultat de selection
		ArrayList<T> resultArray = new ArrayList<T>();
		// Noms des colonnes
		T dataInstance = classT.newInstance();
		String[] columnNames = dataInstance.getDefautUpdateColumns();
		// Requete
		String sql = "SELECT * FROM " + dataInstance.getTableName();
		// Exécuter la requete
		List<Map<String, Object>> resultRows = jdbcTemplate.queryForList(sql);

		for (Map<String, Object> resultRow : resultRows) {
			T t = classT.newInstance();
			for (String columnName : columnNames) {
				Field field = classT.getDeclaredField(columnName);
				field.set(t, resultRow.get(columnName));
			}
			resultArray.add(t);
		}
		return resultArray;
	}

	/**
	 * Select avec condition where
	 * 
	 * @param classT
	 * @param condition
	 * @param dataSource
	 *            info de connexion pour la BD
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static <T extends BasicData> ArrayList<T> selectWhere(
			Class<T> classT, String condition, DataSource dataSource)
			throws InstantiationException, IllegalAccessException,
			NoSuchFieldException, SecurityException {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		// résultat de selection
		ArrayList<T> resultArray = new ArrayList<T>();
		// Noms des colonnes
		T dataInstance = classT.newInstance();
		String[] columnNames = dataInstance.getDefautUpdateColumns();
		// Requete
		String sql = "SELECT * FROM " + dataInstance.getTableName() + " WHERE "
				+ condition;
		// Exécuter la requete
		List<Map<String, Object>> resultRows = jdbcTemplate.queryForList(sql);

		for (Map<String, Object> resultRow : resultRows) {
			T t = classT.newInstance();
			for (String columnName : columnNames) {
				Field field = classT.getDeclaredField(columnName);
				field.set(t, resultRow.get(columnName));
			}
			resultArray.add(t);
		}
		return resultArray;
	}

}