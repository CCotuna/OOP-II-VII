package com.example;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoorDao {
	
	public Door getById(int id) throws SQLException, IOException {
		Connection con = DBHelper.getConnection();
		String query = "select * from doors where id = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		// cata vreme sunt obiecte in rezultatul meu, in cazul nostru 1 ca id = 1
		
		//ori cealalta in care punem w variabila globala = null, si dam valoarea lui w in while
		while(rs.next()) {
			Door door = new Door(rs.getInt("id"), rs.getString("material"), rs.getDouble("height"), rs.getDouble("width"), rs.getDate("installationDate").toLocalDate());
			
			DBHelper.closeConnection();
			return door;
		}
		DBHelper.closeConnection();
		return null;
		
	}
	
	public int getTotalDoors() throws SQLException {
		Connection conn = DBHelper.getConnection();
		String query = "select count(*) as total from doors";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		int total = 0;
		
		while(rs.next()) {
			total = rs.getInt("total");
		}
		
		DBHelper.closeConnection();
		return total;
	}
}
