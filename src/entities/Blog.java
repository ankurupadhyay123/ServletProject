package entities;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by ankur on 6/7/17.
 */
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer blogid;

    @Column
    private String userName;

    @Column
    private Date doc;

    @Column
    private String blogdata;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDoc() {
        return doc;
    }

    public void setDoc(Date doc) {
        this.doc = doc;
    }

    public String getBlogdata() {
        return blogdata;
    }

    public void setBlogdata(String blogdata) {
        this.blogdata = blogdata;
    }

    public Integer getBlogid() { return blogid; }

    public void setBlogid(Integer blogid) { this.blogid = blogid; }

    @Override
    public String toString(){
        return "Blog [blogid="+ blogid + ", userName="+ userName + ", doc="+ doc + ", blogData=" + blogdata +"]";

    }
}
