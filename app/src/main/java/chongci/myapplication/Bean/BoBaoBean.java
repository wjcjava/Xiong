package chongci.myapplication.Bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ASUS on 2017/9/13.
 */

public class BoBaoBean {

    /**
     * total : 73
     * list : [{"num":1,"datatype":"article","id":"ARTI3lUl90Ibd7PqhTzjvB0h170913","title":"4只熊猫本月来沈安家，一只是\u201c网红\u201d","videolength":"","guid":"","picurl":"http://p1.img.cctvpic.com/photoworkspace/2017/09/13/2017091310403662639.jpg","picurl2":"","picurl3":"","url":"http://news.ipanda.com/2017/09/13/ARTI3lUl90Ibd7PqhTzjvB0h170913.shtml","focus_date":1505270810000,"isaixiyou":"0"},{"num":2,"datatype":"article","id":"ARTIuhSOo5AHiXuJIcMzUhrw170912","title":"海归大熊猫\u201c秋浜\u201d首次在深圳过生日","videolength":"","guid":"","picurl":"http://p1.img.cctvpic.com/photoworkspace/2017/09/12/2017091209421629489.jpg","picurl2":"http://p1.img.cctvpic.com/photoworkspace/2017/09/12/2017091209430724056.jpg","picurl3":"http://p1.img.cctvpic.com/photoworkspace/2017/09/12/2017091209431488580.jpg","url":"http://news.ipanda.com/2017/09/12/ARTIuhSOo5AHiXuJIcMzUhrw170912.shtml","focus_date":1505180282000,"isaixiyou":"0"},{"num":3,"datatype":"article","id":"ARTIqx8nsLeWCFKAee59LPCx170911","title":"日本动物园为大熊猫\u201c良滨\u201d庆生 母子嬉戏场面温馨","videolength":"","guid":"","picurl":"http://p1.img.cctvpic.com/photoworkspace/2017/09/11/2017091110175227595.jpg","picurl2":"","picurl3":"","url":"http://news.ipanda.com/2017/09/11/ARTIqx8nsLeWCFKAee59LPCx170911.shtml","focus_date":1505096330000,"isaixiyou":"0"},{"num":4,"datatype":"article","id":"ARTISb7SOmtxT5PBRUiJJwFI170908","title":"游客热烈期待旅英大熊猫\u201c甜甜\u201d生产","videolength":"","guid":"","picurl":"http://p1.img.cctvpic.com/photoworkspace/2017/09/08/2017090809221638044.jpg","picurl2":"","picurl3":"","url":"http://news.ipanda.com/2017/09/08/ARTISb7SOmtxT5PBRUiJJwFI170908.shtml","focus_date":1504833696000,"isaixiyou":"0"},{"num":5,"datatype":"article","id":"ARTIQHOfflIp0jXp8CCpvD4B170906","title":"旅法大熊猫幼仔满月：动物园制作熊猫30天成长视频","videolength":"","guid":"","picurl":"http://p1.img.cctvpic.com/photoworkspace/2017/09/06/2017090615022893235.jpg","picurl2":"","picurl3":"","url":"http://news.ipanda.com/2017/09/06/ARTIQHOfflIp0jXp8CCpvD4B170906.shtml","focus_date":1504681436000,"isaixiyou":"0"},{"num":6,"datatype":"article","id":"ARTI3hxGuKX6DNEDRd3G2AL6170906","title":"旅日大熊猫宝宝茁壮成长，名字将于9月下旬公布","videolength":"","guid":"","picurl":"http://p1.img.cctvpic.com/photoworkspace/2017/09/06/2017090609232549463.jpg","picurl2":"","picurl3":"","url":"http://news.ipanda.com/2017/09/06/ARTI3hxGuKX6DNEDRd3G2AL6170906.shtml","focus_date":1504661156000,"isaixiyou":"0"}]
     */

    private int total;
    private List<ListBean> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean implements Serializable{
        /**
         * num : 1
         * datatype : article
         * id : ARTI3lUl90Ibd7PqhTzjvB0h170913
         * title : 4只熊猫本月来沈安家，一只是“网红”
         * videolength :
         * guid :
         * picurl : http://p1.img.cctvpic.com/photoworkspace/2017/09/13/2017091310403662639.jpg
         * picurl2 :
         * picurl3 :
         * url : http://news.ipanda.com/2017/09/13/ARTI3lUl90Ibd7PqhTzjvB0h170913.shtml
         * focus_date : 1505270810000
         * isaixiyou : 0
         */

        private int num;
        private String datatype;
        private String id;
        private String title;
        private String videolength;
        private String guid;
        private String picurl;
        private String picurl2;
        private String picurl3;
        private String url;
        private long focus_date;
        private String isaixiyou;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getDatatype() {
            return datatype;
        }

        public void setDatatype(String datatype) {
            this.datatype = datatype;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getVideolength() {
            return videolength;
        }

        public void setVideolength(String videolength) {
            this.videolength = videolength;
        }

        public String getGuid() {
            return guid;
        }

        public void setGuid(String guid) {
            this.guid = guid;
        }

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }

        public String getPicurl2() {
            return picurl2;
        }

        public void setPicurl2(String picurl2) {
            this.picurl2 = picurl2;
        }

        public String getPicurl3() {
            return picurl3;
        }

        public void setPicurl3(String picurl3) {
            this.picurl3 = picurl3;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public long getFocus_date() {
            return focus_date;
        }

        public void setFocus_date(long focus_date) {
            this.focus_date = focus_date;
        }

        public String getIsaixiyou() {
            return isaixiyou;
        }

        public void setIsaixiyou(String isaixiyou) {
            this.isaixiyou = isaixiyou;
        }
    }
}