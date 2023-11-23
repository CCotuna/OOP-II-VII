package com.spring.dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.spring.helpers.DBHelper;
import com.spring.pojo.Door;

public class DoorDao {
	
	public Door getById(int id) throws SQLException, IOException {
		Connection con = DBHelper.getConnection();
		String query = "SELECT * FROM doors WHERE id = ?";
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
	
	public ArrayList<Door> getAllDoors() throws SQLException {
		Connection con = DBHelper.getConnection();
		String query = "SELECT * FROM doors";
		
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
	
	public void insertDoor(Door door) throws SQLException {
		Connection conn = DBHelper.getConnection();
		String query = "INSERT INTO doors(material, height, width, installationDate) VALUES(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, door.getMaterial());
		ps.setDouble(2, door.getHeight());
		ps.setDouble(3, door.getWidth());
		ps.setDate(4, java.sql.Date.valueOf(door.getInstallationDate()));
		
		ps.executeUpdate();
	}
	
	public void deleteDoor(int id) throws SQLException {
		Connection conn = DBHelper.getConnection();
		String query = "DELETE FROM doors WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public void updateDoor(Door door) throws SQLException {
		Connection conn = DBHelper.getConnection();
		String query = "UPDATE doors SET material=?, height=?, width=?, installationDate=? WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, door.getMaterial());
		ps.setDouble(2, door.getHeight());
		ps.setDouble(3, door.getWidth());
		ps.setDate(4, java.sql.Date.valueOf(door.getInstallationDate()));
		ps.setInt(5, door.getId());
		
		ps.executeUpdate();
	}
}
