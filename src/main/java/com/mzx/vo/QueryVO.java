package com.mzx.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*929 上午十点半
先写的是service层  传的是页数页码和查询条件（一个queryvo,包装的是表单条件）
先写的是service（且kkbservice层无接口）
然后前端控制器（929上午没有写）给    service层一个Queryvo  其中时间类转换

kkb把查询条件封装成了Queryvo                    后端给前端的vo起名为Resultvo
 */
public class QueryVO {
    //球队名子
    private String teamName;
    //中文名
    private String chineseName;
    //主教练
    private String coach;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    //西东部联盟
    private Integer area;

    @Override
    public String toString() {
        return "QueryVo{" +
                "teamName='" + teamName + '\'' +
                ", chineseName='" + chineseName + '\'' +
                ", coach='" + coach + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", area=" + area +
                '}';
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }
}
