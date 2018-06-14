package kh.web.dbutils;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DButils {
	public static Connection getConnection() throws Exception {
	      Context context = new InitialContext(); // connection을 가져오는 게 아니라 서버 설정값을 가져오는 것
	      DataSource ds = (DataSource)context.lookup("java:/comp/env/oracle"); // java:/comp/env/oracle 텍스트를 찾아서 담아라
	      return ds.getConnection();
	   }
}
