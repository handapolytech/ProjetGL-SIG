package com.ppsinfo.rsig.jdbc.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ppsinfo.rsig.jdbc.model.*;

public interface ThemeDAO extends BasicDataDAO{
	public ArrayList<Integer> idList() throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException;
}
