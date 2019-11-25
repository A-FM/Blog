package pers.ycy.blog.domain;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "blog.outside_chain")
public class OutsideChain implements Serializable {
    private static final long serialVersionUID = 5266356063009709410L;
    /**
     * 主键, 长度为10 , 不为空, 自增, 唯一 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 外链标题
     */
    private String title;

    /**
     * 外链
     */
    private String url;

    /**
     * 外链详情
     */
    private String details;

    /**
     * 获取主键, 长度为10 , 不为空, 自增, 唯一 
     *
     * @return id - 主键, 长度为10 , 不为空, 自增, 唯一 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键, 长度为10 , 不为空, 自增, 唯一 
     *
     * @param id 主键, 长度为10 , 不为空, 自增, 唯一 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取外链标题
     *
     * @return title - 外链标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置外链标题
     *
     * @param title 外链标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取外链
     *
     * @return url - 外链
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置外链
     *
     * @param url 外链
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取外链详情
     *
     * @return details - 外链详情
     */
    public String getDetails() {
        return details;
    }

    /**
     * 设置外链详情
     *
     * @param details 外链详情
     */
    public void setDetails(String details) {
        this.details = details;
    }
}