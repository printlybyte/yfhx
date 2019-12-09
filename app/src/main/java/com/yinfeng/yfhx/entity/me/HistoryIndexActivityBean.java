package com.yinfeng.yfhx.entity.me;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.entity.me
 * 类  名：HistoryIndexActivityBean
 * 创建人：liuguodong
 * 创建时间：2019/12/9 15:20
 * ============================================
 **/
public class HistoryIndexActivityBean {

    /**
     * status : success
     * data : [{"type":"goods","id":"5440","name":"乐扣乐扣 绮丽保温杯不锈钢水杯 340ml LHC40181","img":"http://yinfenghui.oss-cn-beijing.aliyuncs.com/data/gallery_album/137/thumb_img/137_thumb_G_1560033288825.jpg","price":"78","addtime":"1571369259950","/api/v4/history/store":null}]
     * time : 1572418569
     * timestamp : 1.572418569174333E9
     */

    private String status;
    private int time;
    private double timestamp;
    private List<DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(double timestamp) {
        this.timestamp = timestamp;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * type : goods
         * id : 5440
         * name : 乐扣乐扣 绮丽保温杯不锈钢水杯 340ml LHC40181
         * img : http://yinfenghui.oss-cn-beijing.aliyuncs.com/data/gallery_album/137/thumb_img/137_thumb_G_1560033288825.jpg
         * price : 78
         * addtime : 1571369259950
         * /api/v4/history/store : null
         */

        private String type;
        private String id;
        private String name;
        private String img;
        private String price;
        private String addtime;
        @SerializedName("/api/v4/history/store")
        private Object _$ApiV4HistoryStore14; // FIXME check this code

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public Object get_$ApiV4HistoryStore14() {
            return _$ApiV4HistoryStore14;
        }

        public void set_$ApiV4HistoryStore14(Object _$ApiV4HistoryStore14) {
            this._$ApiV4HistoryStore14 = _$ApiV4HistoryStore14;
        }
    }
}
