package com.zzz.demo.pojo;

import java.util.Date;

/**
 * 天降福袋记录
 * Created by zd on 2017/3/15.
 */
public class TJFDLog {

    private Date startDate;
    private Integer userId;
    private Integer score;
    private Integer drill;
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getDrill() {
        return drill;
    }

    public void setDrill(Integer drill) {
        this.drill = drill;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TJFDLog{");
        sb.append("startDate=").append(startDate);
        sb.append(", userId=").append(userId);
        sb.append(", score=").append(score);
        sb.append(", drill=").append(drill);
        sb.append(", nickName='").append(nickName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}