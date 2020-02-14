package com.yinfeng.yfhx.ui.search;

import android.app.ListActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lgd.lgd_core.base.BaseActivity;
import com.lgd.lgd_core.ui.utils.ITTUtils;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.orhanobut.hawk.Hawk;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.ui.details.CommodityListActivity;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;


public class SearchActivity extends BaseActivity implements View.OnClickListener {


    private TagFlowLayout mActivitySearchFlawlayout;
    private TextView mIncludeSearchLayoutBtn;
    private EditText mIncludeSearchLayoutInput;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {
        mActivitySearchFlawlayout = (TagFlowLayout) findViewById(R.id.activity_search_flawlayout);
        mIncludeSearchLayoutBtn = (TextView) findViewById(R.id.include_search_layout_btn);
        mIncludeSearchLayoutBtn.setOnClickListener(this);
        mIncludeSearchLayoutInput = (EditText) findViewById(R.id.include_search_layout_input);
        mIncludeSearchLayoutInput.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        setTitle("商品搜索");
        setTagDate();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;

            case R.id.include_search_layout_btn:
                String inptuStr = mIncludeSearchLayoutInput.getText().toString();
                if (TextUtils.isEmpty(inptuStr)) {
                    ToastUS.Error("请输入关键词");
                    return;
                }

                JSONArray jsonArrayX = Hawk.get(temp_list_key);
                if (jsonArrayX != null && jsonArrayX.length() > 0) {
                    jsonArrayX.put(inptuStr);
                    Hawk.put(temp_list_key, jsonArrayX);

                } else {
                    JSONArray jsonArray = new JSONArray();
                    jsonArray.put(inptuStr);
                    Hawk.put(temp_list_key, jsonArray);
                }
                setTagDate();
                ITTUtils.Jump(SearchListActivity.class, "" +inptuStr);

                break;

        }
    }


    String temp_list_key = "temp_list_key";

    public void setTagDate() {
        List<String> mList_c = new ArrayList<>();
        JSONArray jsonArrayX = Hawk.get(temp_list_key);
        if (jsonArrayX != null && jsonArrayX.length() > 0) {
            for (int i = 0; i < jsonArrayX.length(); i++) {
                String as = null;
                try {
                    as = (String) jsonArrayX.get(i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                mList_c.add(as);
            }
        }

        Collections.reverse(mList_c);
        String[] strings = new String[mList_c.size()];
        TagAdapter<String> tagAdapter = new TagAdapter<String>(mList_c.toArray(strings)) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(mContext).inflate(R.layout.tag_search_layout_layout, mActivitySearchFlawlayout, false);
                tv.setText(s);
                return tv;
            }
        };
//        tagAdapter.setSelectedList(0);
        mActivitySearchFlawlayout.setAdapter(tagAdapter);
        mActivitySearchFlawlayout.setOnSelectListener(new TagFlowLayout.OnSelectListener() {
            @Override
            public void onSelected(Set<Integer> selectPosSet) {
                if (selectPosSet.toString().length() == 3) {
                    String as = selectPosSet.toString().substring(1, 2);
                    String sel_str = mList_c.get(Integer.parseInt(as));
//                    ToastUS.Error("" + sel_str);
                    ITTUtils.Jump(SearchListActivity.class, "" +sel_str);

                } else {

                }
            }
        });
    }

}
