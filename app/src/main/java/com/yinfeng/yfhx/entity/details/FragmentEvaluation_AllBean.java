package com.yinfeng.yfhx.entity.details;

import java.util.List;

public class FragmentEvaluation_AllBean  {

    /**
     * status : success
     * data : [{"add_time":"2019-11-12 16:39:18","content":"不错","rank":3,"user_name":"H***婷","user_picture":"http://thirdwx.qlogo.cn/mmopen/Q3auHgzwzM7WqMhcEtTks7lXW5KB9GbXLRRWibvCiaYh345ZuTM55Ty1iat8RAlZkjK3leYqQeEV8CY79U4hDl4H0fvFz5qlJNiap8sXwIhReEs/132","goods":[{"goods_attr":"","goods_id":5440,"goods_name":"乐扣乐扣 绮丽保温杯不锈钢水杯 340ml LHC40181"}],"comment_img":["http://yinfenghui.oss-cn-beijing.aliyuncs.com/data/cmt_img/201911/1573519141922122635.jpg","http://yinfenghui.oss-cn-beijing.aliyuncs.com/data/cmt_img/201911/1573519149293268197.jpg"]}]
     * time : 1573547972
     * timestamp : 1.573547972371144E9
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
         * add_time : 2019-11-12 16:39:18
         * content : 不错
         * rank : 3
         * user_name : H***婷
         * user_picture : http://thirdwx.qlogo.cn/mmopen/Q3auHgzwzM7WqMhcEtTks7lXW5KB9GbXLRRWibvCiaYh345ZuTM55Ty1iat8RAlZkjK3leYqQeEV8CY79U4hDl4H0fvFz5qlJNiap8sXwIhReEs/132
         * goods : [{"goods_attr":"","goods_id":5440,"goods_name":"乐扣乐扣 绮丽保温杯不锈钢水杯 340ml LHC40181"}]
         * comment_img : ["http://yinfenghui.oss-cn-beijing.aliyuncs.com/data/cmt_img/201911/1573519141922122635.jpg","http://yinfenghui.oss-cn-beijing.aliyuncs.com/data/cmt_img/201911/1573519149293268197.jpg"]
         */

        private String add_time;
        private String content;
        private int rank;
        private String user_name;
        private String user_picture;
        private List<GoodsBean> goods;
        private List<String> comment_img;

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getUser_picture() {
            return user_picture;
        }

        public void setUser_picture(String user_picture) {
            this.user_picture = user_picture;
        }

        public List<GoodsBean> getGoods() {
            return goods;
        }

        public void setGoods(List<GoodsBean> goods) {
            this.goods = goods;
        }

        public List<String> getComment_img() {
            return comment_img;
        }

        public void setComment_img(List<String> comment_img) {
            this.comment_img = comment_img;
        }

        public static class GoodsBean {
            /**
             * goods_attr :
             * goods_id : 5440
             * goods_name : 乐扣乐扣 绮丽保温杯不锈钢水杯 340ml LHC40181
             */

            private String goods_attr;
            private int goods_id;
            private String goods_name;

            public String getGoods_attr() {
                return goods_attr;
            }

            public void setGoods_attr(String goods_attr) {
                this.goods_attr = goods_attr;
            }

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }
        }
    }
}
