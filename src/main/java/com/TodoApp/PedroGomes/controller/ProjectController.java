package com.TodoApp.PedroGomes.controller;

import com.TodoApp.PedroGomes.model.Project;
import com.TodoApp.PedroGomes.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectController {
    public void create(Project project) {
        String sql = "INSERT INTO PROJECTS (" +
                "NAME," +
                "DESCRIPTION," +
                "CREATED_AT," +
                "UPDATED_AT) " +
                "VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);

            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date( project.getCreatedAt().getTime() ));
            statement.setDate(4, new Date( project.getUpdatedAt().getTime() ));

            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Failed to save project " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }

    }

    public void update(Project project) {
        String sql = "UPDATE PROJECTS SET " +
                "NAME = ?," +
                "DESCRIPTION = ?," +
                "UPDATED_AT = ?" +
                "WHERE ID = ?";
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);

            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.setInt(5, project.getId());
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Failed to update project " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }

    }

    public void removeById(int projectId)  {
        String sql = "DELETE FROM PROJECTS WHERE ID = ?";

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);

            statement.setInt(1, projectId);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete project" + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
    }

    public List<Project> getAll() {
        String sql = "SELECT * FROM PROJECTS";

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Project> projects = new ArrayList<Project>();

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedAt(resultSet.getDate("created_at"));
                project.setUpdatedAt(resultSet.getDate("updated_at"));

                projects.add(project);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to search projects " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(conn, statement, resultSet);
        }

        return projects;
    }
}
