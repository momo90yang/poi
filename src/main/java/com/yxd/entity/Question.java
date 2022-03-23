package com.yxd.entity;

import java.util.List;

public class Question {
    String content;
    String type;
    String analysis;
    String score;
    String hardGrade;
    List<Item> items;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getHardGrade() {
        return hardGrade;
    }

    public void setHardGrade(String hardGrade) {
        this.hardGrade = hardGrade;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Question{" +
                "content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", analysis='" + analysis + '\'' +
                ", score=" + score +
                ", hardGrade=" + hardGrade +
                ", items=" + items +
                '}';
    }
}
