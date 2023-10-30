package model;

import constant.Constant;


public class Task {
    
    private String name; // Tên công việc
    private int type; // Loại công việc
    private double from; // Thời gian bắt đầu dự định
    private double to; // Thời gian kết thúc dự định
    private String reviewer; // Người review
    private int assigneeId; // ID của Assignee

    public Task() {}

    public Task(int assigneeId, String name, int type, double from, double to, String reviewer) {
        this.assigneeId = assigneeId;
        this.name = name;
        this.type = type;
        this.from = from;
        this.to = to;
        this.reviewer = reviewer;
    }

    public int getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(int assigneeId) {
        this.assigneeId = assigneeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
    
     public String getTaskTypeString(int taskTypeID) {
        String result = null;
        switch (taskTypeID) {
            case Constant.TASK_TYPE_CODE:
                result = "Code";
                break;
            case Constant.TASK_TYPE_TEST:
                result = "Test";
                break;
            case Constant.TASK_TYPE_DESIGN:
                result = "Design";
                break;
            case Constant.TASK_TYPE_REVIEW:
                result = "Review";
                break;
        }
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "assigneeId=" + assigneeId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", from=" + from +
                ", to=" + to +
                ", reviewer='" + reviewer + '\'' +
                '}';
    }
}
