package com.mzx.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
//@ApiModel("球队信息")
public class Team {
    //@ApiModelProperty(value = "球队主键",required = true)
    private Integer teamId;
    //@ApiModelProperty(value = "球队名称")
    private String teamName;
    //@ApiModelProperty("球队中文名")
    private String chineseName;
    //@ApiModelProperty("球队教练")
    private String coach;
    //@ApiModelProperty("球队场馆")
    private String stadium;
    //@ApiModelProperty("球队位置")
    private String location;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    //@ApiModelProperty("球队创建时间")
    private Date createTime;
    //@ApiModelProperty("球队logo")
    private String teamLogo;
    //@ApiModelProperty("球队所属联盟")
    private Integer area;
    //@ApiModelProperty("是否删除")
    private Integer isDel;

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName == null ? null : teamName.trim();
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName == null ? null : chineseName.trim();
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach == null ? null : coach.trim();
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium == null ? null : stadium.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTeamLogo() {
        return teamLogo;
    }

    public void setTeamLogo(String teamLogo) {
        this.teamLogo = teamLogo == null ? null : teamLogo.trim();
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}
