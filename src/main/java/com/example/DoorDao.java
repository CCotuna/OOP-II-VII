package com.example;


import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DoorDao {
	
	public Door getById(int id) throws SQLException, IOException {
		Connection con = DBHelper.getConnection();
		String query = "select * from doors where id = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
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
	
	public ArrayList<Door> getAllDoors() throws SQLException {
		Connection con = DBHelper.getConnection();
		String query = "select * from doors";
		
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Door> doors = new ArrayList<>();
		while(rs.next()) {
			Door w = new Door(rs.getInt("id"), rs.getString("material"), rs.getDouble("height"), rs.getDouble("width"), rs.getDate("installationDate").toLocalDate());
			doors.add(w);
		}
		DBHelper.closeConnection();
		return doors;
	}
}
