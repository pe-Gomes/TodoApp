package com.TodoApp.PedroGomes.model;

import java.util.Date;

public class Task {
    private int id;
    private int projectId;
    private String name;
    private String description;
    private String observations;
    private boolean completed;
    private Date deadline;
    private Date createdAt;
    private Date updatedAt;

    public Task(int id, int projectId, String name, String description, String observations, boolean completed, Date deadline, Date createdAt, Date updatedAt) {
        this.id = id;
        this.projectId = projectId;
        this.name = name;
        this.description = description;
        this.observations = observations;
        this.completed = completed;
        this.deadline = deadline;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Task() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", observations='" + observations + '\'' +
                ", completed=" + completed +
                ", deadline=" + deadline +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
