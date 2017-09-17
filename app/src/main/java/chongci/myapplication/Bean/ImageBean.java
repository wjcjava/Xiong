package chongci.myapplication.Bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ASUS on 2017/9/13.
 */

public class ImageBean {

    /**
     * data : {"bigImg":[{"id":"TITE1505384459304175","image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/9/14/1505384444728_170.jpg","order":"1","pid":"29261a6b576f488a9124a7ded9d241d3","stype":"","title":"大熊猫\u201c巴斯\u201d获熊猫界数个第一","type":"2","url":"http://live.ipanda.com/2017/09/14/VIDEkP7cpB0YzMi4dDatcw7f170914.shtml","vid":""}],"listurl":"http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * bigImg : [{"id":"TITE1505384459304175","image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/9/14/1505384444728_170.jpg","order":"1","pid":"29261a6b576f488a9124a7ded9d241d3","stype":"","title":"大熊猫\u201c巴斯\u201d获熊猫界数个第一","type":"2","url":"http://live.ipanda.com/2017/09/14/VIDEkP7cpB0YzMi4dDatcw7f170914.shtml","vid":""}]
         * listurl : http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda
         */

        private String listurl;
        private List<BigImgBean> bigImg;

        public String getListurl() {
            return listurl;
        }

        public void setListurl(String listurl) {
            this.listurl = listurl;
        }

        public List<BigImgBean> getBigImg() {
            return bigImg;
        }

        public void setBigImg(List<BigImgBean> bigImg) {
            this.bigImg = bigImg;
        }

        public static class BigImgBean implements Serializable{
            /**
             * id : TITE1505384459304175
             * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/9/14/1505384444728_170.jpg
             * order : 1
             * pid : 29261a6b576f488a9124a7ded9d241d3
             * stype :
             * title : 大熊猫“巴斯”获熊猫界数个第一
             * type : 2
             * url : http://live.ipanda.com/2017/09/14/VIDEkP7cpB0YzMi4dDatcw7f170914.shtml
             * vid :
             */

            private String id;
            private String image;
            private String order;
            private String pid;
            private String stype;
            private String title;
            private String type;
            private String url;
            private String vid;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getOrder() {
                return order;
            }

            public void setOrder(String order) {
                this.order = order;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public String getStype() {
                return stype;
            }

            public void setStype(String stype) {
                this.stype = stype;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getVid() {
                return vid;
            }

            public void setVid(String vid) {
                this.vid = vid;
            }
        }
    }
}
