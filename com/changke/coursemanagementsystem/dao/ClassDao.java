package com.changke.coursemanagementsystem.dao;

import java.sql.SQLException;
import java.util.List;
import com.changke.selectclasssystem.model.Clazz;

public interface ClassDao {

	List<Clazz> queryClass() throws SQLException;

}
