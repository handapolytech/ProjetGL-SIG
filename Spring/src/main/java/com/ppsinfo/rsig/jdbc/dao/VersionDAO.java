package com.ppsinfo.rsig.jdbc.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ppsinfo.rsig.jdbc.model.*;

public interface VersionDAO extends BasicDataDAO{
	boolean downloadVersion(String url, String cheminRep) throws IOException;
}
