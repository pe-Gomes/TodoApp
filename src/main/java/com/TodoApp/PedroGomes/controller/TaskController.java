package com.TodoApp.PedroGomes.controller;

import com.TodoApp.PedroGomes.model.Task;
import com.TodoApp.PedroGomes.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskController {
    public void create(Task task) {
        String sql = "INSERT INTO TASKS (PROJECT_ID," +
                "NAME," +
                "DESCRIPTION," +
                "OBSERVATIONS," +
                "COMPLETED," +
                "DEADLINE," +
                "CREATED_AT," +
                "UPDATED_AT) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);

            statement.setInt(1, task.getProjectId());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setString(4, task.getObservations());
            statement.setBoolean(5, task.isCompleted());
            statement.setDate(6, new Date( task.getDeadline().getTime() ));
            statement.setDate(7, new Date( task.getCreatedAt().getTime() ));
            statement.setDate(8, new Date( task.getUpdatedAt().getTime() ));

            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Failed to save task " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }

    }

    public void update(Task task) {
        String sql = "UPDATE TASKS SET " +
                "PROJECT_ID = ?," +
                "NAME = ?," +
                "DESCRIPTION = ?," +
                "OBSERVATIONS = ?," +
                "COMPLETED = ?," +
                "DEADLINE = ?," +
                "UPDATED_AT = ? " +
                "WHERE ID = ?";
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);

            statement.setInt(1, task.getProjectId());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setString(4, task.getObservations());
            statement.setBoolean(5, task.isCompleted());
            statement.setDate(6, new Date( task.getDeadline().getTime() ));
            statement.setDate(7, new Date( task.getUpdatedAt().getTime() ));
            statement.setInt(8, task.getId());
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Failed to update task " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }

    }

    public void removeById(int taskId) {
        String sql = "DELETE FROM TASKS WHERE ID = ?";

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);

            statement.setInt(1, taskId);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete task" + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
    }

    public List<Task> getAll(int projectId) {
        String sql = "SELECT * FROM TASKS WHERE PROJECT_ID = ?";

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Task> tasks = new ArrayList<Task>();

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, projectId);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setProjectId(resultSet.getInt("project_id"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setObservations(resultSet.getString("observations"));
                task.setCompleted(resultSet.getBoolean("completed"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreatedAt(resultSet.getDate("created_at"));
                task.setUpdatedAt(resultSet.getDate("updated_at"));

                tasks.add(task);
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to search task " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(conn, statement, resultSet);
        }

        return tasks;
    }

}
