package com.yxd.entity;

public class Item {
    String content;
    Integer is_answer;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIs_answer() {
        return is_answer;
    }

    public void setIs_answer(Integer is_answer) {
        this.is_answer = is_answer;
    }

    @Override
    public String toString() {
        return "Item{" +
                "content='" + content + '\'' +
                ", is_answer=" + is_answer +
                '}';
    }
}
