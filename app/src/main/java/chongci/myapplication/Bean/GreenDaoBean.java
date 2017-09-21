package chongci.myapplication.Bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.io.Serializable;

/**
 * Created by ASUS on 2017/9/18.
 */
@Entity
public class GreenDaoBean {
    @Id(autoincrement = true)
    private Long id;
    @Property
    private String img;
    @Property
    private String title;
    @Property
    private String time;
    @Generated(hash = 1752308701)
    public GreenDaoBean(Long id, String img, String title, String time) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.time = time;
    }
    @Generated(hash = 826843181)
    public GreenDaoBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImg() {
        return this.img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
}
