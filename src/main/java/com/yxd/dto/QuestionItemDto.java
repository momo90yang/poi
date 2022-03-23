package com.yxd.dto;

public class QuestionItemDto {
    /**
     * 编号|使用雪花算法计算 ID
     */
    //@NotNull(message = "id不能为空",groups = UpdateGroup.class)
    private Long id;
    /**
     * 编号|使用雪花算法计算 ID
     */
   // @NotNull(message = "questionId不能为空",groups = {SaveGroup.class,UpdateGroup.class})
    private Long questionId;

    /**
     * 选项内容
     */
    //@NotNull(message = "content不能为空",groups = {SaveGroup.class})
    private String content;
    /**
     * 是否是答案
     */
    //@NotNull(message = "isAnswer不能为空",groups = {SaveGroup.class})
    private Integer isAnswer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIsAnswer() {
        return isAnswer;
    }

    public void setIsAnswer(Integer isAnswer) {
        this.isAnswer = isAnswer;
    }

    @Override
    public String toString() {
        return "QuestionItemDto{" +
                "id=" + id +
                ", questionId=" + questionId +
                ", content='" + content + '\'' +
                ", isAnswer=" + isAnswer +
                '}';
    }
}
