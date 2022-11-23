package com.mzx.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
//@ApiModel("比赛记录信息")
public class Game {
    //@ApiModelProperty(value = "比赛记录主键",required = true)
    private Integer gameId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss",iso = DateTimeFormat.ISO.DATE_TIME)
    //改用全局   时间接收不到导致 什么400 请求方式不对
    //@ApiModelProperty("比赛时间")
    private Date gameDate;
    //@ApiModelProperty("主场队伍id")
    private Integer homeTeamId;
    //@ApiModelProperty("主场队伍比分")
    private Integer homeTeamScore;
    //@ApiModelProperty("客场队伍id")
    private Integer visitingTeamId;
    //@ApiModelProperty("客场队伍比分")
    private Integer visitingTeamScore;
    //@ApiModelProperty("比赛类型")
    private Integer typeId;
    //@ApiModelProperty("比赛状态")
    private Integer status;
    //@ApiModelProperty("是否删除")
    private Integer isDel;





    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Date getGameDate() {
        return gameDate;
    }

    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }

    public Integer getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(Integer homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public Integer getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(Integer homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public Integer getVisitingTeamId() {
        return visitingTeamId;
    }

    public void setVisitingTeamId(Integer visitingTeamId) {
        this.visitingTeamId = visitingTeamId;
    }

    public Integer getVisitingTeamScore() {
        return visitingTeamScore;
    }

    public void setVisitingTeamScore(Integer visitingTeamScore) {
        this.visitingTeamScore = visitingTeamScore;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}
