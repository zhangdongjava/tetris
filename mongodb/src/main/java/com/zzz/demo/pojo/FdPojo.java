package com.zzz.demo.pojo;

import java.util.Date;

/**
 * Created by zd on 2017/3/16.
 */
public class FdPojo {
//活动时间 参与人数 产出金币 产出钻币

    private int people;
    private Date date;
    private int score;
    private int maxScore;
    private int drill;

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getDrill() {
        return drill;
    }

    public void setDrill(int drill) {
        this.drill = drill;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("FdPojo{");
        sb.append("people=").append(people);
        sb.append(", date=").append(date);
        sb.append(", score=").append(score);
        sb.append(", maxScore=").append(maxScore);
        sb.append(", drill=").append(drill);
        sb.append('}');
        return sb.toString();
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }
}
