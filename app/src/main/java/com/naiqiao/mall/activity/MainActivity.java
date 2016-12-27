package com.naiqiao.mall.activity;

import android.content.Intent;
import android.util.Log;

import com.canyinghao.canphotos.CanPhotoHelper;
import com.naiqiao.mall.constant.UserInfo;
import com.naiqiao.mall.fragment.index.IndexFragment;

import java.util.Map;

import base.activity.BaseActivity;
import base.bean.rxbus.AddFragmentBean;
import base.bean.rxbus.PhotoRxbus;
import util.RxBus;
import util.SharedPreferenUtil;

public class MainActivity extends BaseActivity {

    @Override
    protected void initData() {
        initUserInfo();
        sendFragment();
    }

    private void initUserInfo() {
        Map<String, String> map = new SharedPreferenUtil(this, "userLogin").getData(new String[]{"uid", "token"});
        UserInfo.uid = map.get("uid");
        UserInfo.token = map.get("token");
    }

    private void sendFragment() {
        AddFragmentBean addFragmentBean = new AddFragmentBean(new IndexFragment());
        addFragmentBean.setAddBack(true);
        addFragmentBean.setHaveAnima(true);
        RxBus.get().post("addFragment", addFragmentBean);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (data != null && data.hasExtra(CanPhotoHelper.PHOTO_COLLECTION)) {
                RxBus.get().post("photoRxBus", new PhotoRxbus(true, data.getStringArrayListExtra(CanPhotoHelper.PHOTO_COLLECTION)));
            }
        }
    }

}
