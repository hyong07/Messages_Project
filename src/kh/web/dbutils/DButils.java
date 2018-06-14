package kh.web.dbutils;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DButils {
	public static Connection getConnection() throws Exception {
	      Context context = new InitialContext(); // connection�� �������� �� �ƴ϶� ���� �������� �������� ��
	      DataSource ds = (DataSource)context.lookup("java:/comp/env/oracle"); // java:/comp/env/oracle �ؽ�Ʈ�� ã�Ƽ� ��ƶ�
	      return ds.getConnection();
	   }
}
