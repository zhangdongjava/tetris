package com.zzz.demo.pojo;

import java.util.Date;

/**
 * Created by zd on 2017/3/20.
 */
public class MuScoreRecord {

    private Integer userId;
    private Date startTime;
    private Date endTime;
    private Date insertDate;
    private Long score;
    private Integer hour;

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MuScoreRecord{");
        sb.append("userId=").append(userId);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", insertDate=").append(insertDate);
        sb.append(", score=").append(score);
        sb.append(", hour=").append(hour);
        sb.append('}');
        return sb.toString();
    }
}
