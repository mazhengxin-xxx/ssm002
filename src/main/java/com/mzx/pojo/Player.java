package com.mzx.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
//@ApiModel("球员信息")
public class Player {
    //@ApiModelProperty(value = "球员主键",required = true)
    private Integer playerId;
    //@ApiModelProperty("球员姓名")
    private String playerName;
   // @ApiModelProperty("球员号码")
    private Integer playerNum;
    //@ApiModelProperty("球员位置")
    private String location;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    //@ApiModelProperty("球员生日")
    private Date birthday;
    //@ApiModelProperty("球员国籍")
    private String nationality;
    //@ApiModelProperty("球员身高")
    private Double height;
    //@ApiModelProperty("球员体重")
    private Double weight;
    //@ApiModelProperty("球员工资")
    private Double salary;
    //@ApiModelProperty("所属队伍id")
    private Integer teamId;
    //@ApiModelProperty("是否在职")
    private Integer status;
    //@ApiModelProperty("是否删除")
    private Integer isDel;

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName == null ? null : playerName.trim();
    }

    public Integer getPlayerNum() {
        return playerNum;
    }

    public void setPlayerNum(Integer playerNum) {
        this.playerNum = playerNum;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality == null ? null : nationality.trim();
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
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
