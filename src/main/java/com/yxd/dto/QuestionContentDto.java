package com.yxd.dto;

public class QuestionContentDto {
    /**
     * 编号|使用雪花算法计算 ID
     */
    //@NotNull(message = "id不能为空",groups = UpdateGroup.class)
    private Long id;
    /**
     * 题目内容
     */
    //@NotNull(message = "title不能为空",groups = SaveGroup.class)
    private String title;
    /**
     * typeId|雪花算法计算
     */
    //@NotNull(message = "typeId不能为空",groups = SaveGroup.class)
    private Long typeId;
    /**
     * 题目类型，0单选，1多选，2判断，3简答
     */
    //@NotNull(message = "type不能为空",groups = SaveGroup.class)
    private Integer type;
    /**
     * 禁用标识，0不禁用，1禁用
     */
    //@NotNull(message = "isDisabled不能为空",groups = SaveGroup.class)
    private Integer isDisabled;
    /**
     * 题目解析
     */

    private String analysis;
    /**
     * 题目分值
     */
    //@NotNull(message = "score不能为空",groups = SaveGroup.class)
    private Integer score;
    //是否已发布到试卷
    //@NotNull(message = "isPublished不能为空",groups = SaveGroup.class)
    private Integer isPublished;
    //难度分级
    //@NotNull(message = "hardGradeEnum不能为空",groups = SaveGroup.class)
    private Integer hardGrade;

    public QuestionContentDto(String title, Integer type, String analysis, Integer score, Integer hardGrade) {
        this.title = title;
        this.type = type;
        this.analysis = analysis;
        this.score = score;
        this.hardGrade = hardGrade;
    }

    public QuestionContentDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(Integer isDisabled) {
        this.isDisabled = isDisabled;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(Integer isPublished) {
        this.isPublished = isPublished;
    }

    public Integer getHardGrade() {
        return hardGrade;
    }

    public void setHardGrade(Integer hardGrade) {
        this.hardGrade = hardGrade;
    }

    @Override
    public String toString() {
        return "QuestionContentDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", typeId=" + typeId +
                ", type=" + type +
                ", isDisabled=" + isDisabled +
                ", analysis='" + analysis + '\'' +
                ", score=" + score +
                ", isPublished=" + isPublished +
                ", hardGrade=" + hardGrade +
                '}';
    }
}
