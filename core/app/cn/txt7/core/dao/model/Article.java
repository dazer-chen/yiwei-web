package cn.txt7.core.dao.model;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: shijinkui
 * Date: 13-10-7
 * Time: 下午9:05
 * To change this template use File | Settings | File Templates.
 */
public class Article {
    private long id;
    private String author = "";     //  作者
    private String head;            //  标题
    private String content;         //  内容
    private int editor;             //  编辑
    private String tag = "";
    private Timestamp ctime;        //  创建时间
    private Timestamp uptime;       //  更新时间
    private String category = "";   //  目录
    private String shotname;        //  文章简称, 可选作为html文件名
    private String medianame;       //  媒体名字

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getEditor() {
        return editor;
    }

    public void setEditor(int editor) {
        this.editor = editor;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Timestamp getCtime() {
        return ctime;
    }

    public void setCtime(Timestamp ctime) {
        this.ctime = ctime;
    }

    public Timestamp getUptime() {
        return uptime;
    }

    public void setUptime(Timestamp uptime) {
        this.uptime = uptime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getShotname() {
        return shotname;
    }

    public void setShotname(String shotname) {
        this.shotname = shotname;
    }

    public String getMedianame() {
        return medianame;
    }

    public void setMedianame(String medianame) {
        this.medianame = medianame;
    }
}
