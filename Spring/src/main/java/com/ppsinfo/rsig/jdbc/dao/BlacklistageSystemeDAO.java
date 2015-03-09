package com.ppsinfo.rsig.jdbc.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ppsinfo.rsig.jdbc.model.*;

public interface BlacklistageSystemeDAO extends BasicDataDAO{
	public ArrayList<Integer> idSourceList() throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException;
}
