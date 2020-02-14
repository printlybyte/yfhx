package com.yinfeng.yfhx.ui.wheight.popup;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.yinfeng.yfhx.R;

import java.util.ArrayList;
import java.util.List;

import razerdp.basepopup.BasePopupWindow;

public class MenuPopup extends BasePopupWindow   {
    private ListView mListView;
    private OnListPopupItemClickListener mOnListPopupItemClickListener;
    private MenuPopup(Context context, Builder builder) {
        super(context);

//        setAlignBackground(false);
//        setClipChildren(false);
        setAutoLocatePopup(true);




        mListView = (ListView) findViewById(R.id.popup_list);
        setPopupGravity(Gravity.TOP);
        setAdapter(context, builder);


    }
    @Override
    protected Animation onCreateShowAnimation() {
        return getDefaultAlphaAnimation();
    }

    @Override
    protected Animation onCreateDismissAnimation() {
        return getDefaultAlphaAnimation(false);
    }

//    @Override
//    public void showPopupWindow(View v) {
//        setOffsetX(v.getWidth() / 2);
//        super.showPopupWindow(v);
//    }

    @Override
    public void onAnchorTop() {

    }

    @Override
    public void onAnchorBottom() {

    }
    @Override
    public View onCreateContentView() {
        return createPopupById(R.layout.popup_menu_layout);
    }




    public static class Builder {
        private List<Object> mItemEventList = new ArrayList<>();
        private Activity mContext;

        public Builder(Activity context) {
            mContext = context;
        }

        public Builder addItem(String itemTx) {
            mItemEventList.add(itemTx);
            return this;
        }

        public Builder addItem(int clickTag, String itemTx) {
            mItemEventList.add(new clickItemEvent(clickTag, itemTx));
            return this;
        }

        public List<Object> getItemEventList() {
            return mItemEventList;
        }

        public MenuPopup build() {
            return new MenuPopup(mContext, this);
        }

    }

    public static class clickItemEvent {
        private int clickTag;
        private String itemTx;

        public clickItemEvent(int clickTag, String itemTx) {
            this.clickTag = clickTag;
            this.itemTx = itemTx;
        }

        public int getClickTag() {
            return clickTag;
        }

        public void setClickTag(int clickTag) {
            this.clickTag = clickTag;
        }

        public String getItemTx() {
            return itemTx;
        }

        public void setItemTx(String itemTx) {
            this.itemTx = itemTx;
        }
    }

    //=============================================================adapter
    class ListPopupAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        private Context mContext;
        private List<Object> mItemList;

        public ListPopupAdapter(Context context, @NonNull List<Object> itemList) {
            mContext = context;
            mItemList = itemList;
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return mItemList.size();
        }

        @Override
        public String getItem(int position) {
            if (mItemList.get(position) instanceof String) {
                return (String) mItemList.get(position);
            }
            if (mItemList.get(position) instanceof clickItemEvent) {
                return ((clickItemEvent) mItemList.get(position)).getItemTx();
            }
            return "";
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder vh = null;
            if (convertView == null) {
                vh = new ViewHolder();
                convertView = mInflater.inflate(R.layout.item_popup_list, parent, false);
                vh.mTextView = (TextView) convertView.findViewById(R.id.item_tx);
                convertView.setTag(vh);
            } else {
                vh = (ViewHolder) convertView.getTag();
            }
            vh.mTextView.setText(getItem(position));
            return convertView;
        }

        public List<Object> getItemList() {
            return this.mItemList;
        }


        class ViewHolder {
            public TextView mTextView;
        }
    }

    //=============================================================init
    private void setAdapter(Context context, Builder builder) {
        if (builder.getItemEventList() == null || builder.getItemEventList().size() == 0) return;
        final ListPopupAdapter adapter = new ListPopupAdapter(context, builder.getItemEventList());
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mOnListPopupItemClickListener != null) {
                    Object clickObj = adapter.getItemList().get(position);
                    if (clickObj instanceof String) {
                        mOnListPopupItemClickListener.onItemClick(position);
                    }
                    if (clickObj instanceof clickItemEvent) {
                        int what = ((clickItemEvent) clickObj).clickTag;
                        mOnListPopupItemClickListener.onItemClick(what);
                    }
                }
            }
        });

    }
    //=============================================================interface

    public OnListPopupItemClickListener getOnListPopupItemClickListener() {
        return mOnListPopupItemClickListener;
    }

    public void setOnListPopupItemClickListener(OnListPopupItemClickListener onListPopupItemClickListener) {
        mOnListPopupItemClickListener = onListPopupItemClickListener;
    }

    public interface OnListPopupItemClickListener {
        void onItemClick(int what);
    }
}
