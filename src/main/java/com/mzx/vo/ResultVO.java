package com.mzx.vo;

import com.github.pagehelper.PageInfo;

import java.util.List;
/*
929 下午15.00
给前端的结果类
插件的信息
集合
单个对象    状态码   异常报错.
 */
public class ResultVO<T>{
    //插件所需信息大全
    private PageInfo<T> pageInfo;
    private List<T> list;
    private T obj;
    private Integer code=200;
    private String msg="ok";
    //构造函数  成功返回一个多个 code msg定死       也可改变


    public ResultVO() {
    }

    public ResultVO(PageInfo<T> pageInfo) {
        this.pageInfo = pageInfo;
    }

    public ResultVO(List<T> list) {
        this.list = list;
    }

    public ResultVO(T obj) {
        this.obj = obj;
    }

    public ResultVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;//此时其余属性为空
    }

    public PageInfo<T> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<T> pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
