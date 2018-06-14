package kh.web.messagesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kh.web.dbutils.DButils;
import kh.web.messagesDTO.MessagesDTO;

public class MessagesDAO {
	
	public int insertData(MessagesDTO dto) throws Exception {
		Connection con = DButils.getConnection();
		String sql = "insert into messages values(?,?,?)";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, dto.getMessage_id());
		pstat.setString(2, dto.getName());
		pstat.setString(3, dto.getMessage());
		int insert_result = pstat.executeUpdate();
		
		con.commit();
		con.close();
		pstat.close();
		return insert_result;
	}
	
	public List<MessagesDTO> selectData() throws Exception {
		Connection con = DButils.getConnection();
		String sql = "select * from messages";
		Statement stat = con.createStatement();
		ResultSet result = stat.executeQuery(sql);
		List<MessagesDTO> select_list = new ArrayList<>(); 
		
		while(result.next()) {
			MessagesDTO dto = new MessagesDTO();
			dto.setMessage_id(result.getString(1));
			dto.setName(result.getString(2));
			dto.setMessage(result.getString(3));
			
			select_list.add(dto);
		}
		
		con.commit();
		con.close();
		stat.close();
		return select_list;
	}

}
