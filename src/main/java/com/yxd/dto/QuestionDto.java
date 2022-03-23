package com.yxd.dto;

import java.util.List;

public class QuestionDto {
    //题干
    private QuestionContentDto content;
    //选项
    private List<QuestionItemDto> items;

    public QuestionContentDto getContent() {
        return content;
    }

    public void setContent(QuestionContentDto content) {
        this.content = content;
    }

    public List<QuestionItemDto> getItems() {
        return items;
    }

    public void setItems(List<QuestionItemDto> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "QuestionDto{" +
                "content=" + content +
                ", items=" + items +
                '}';
    }
}
