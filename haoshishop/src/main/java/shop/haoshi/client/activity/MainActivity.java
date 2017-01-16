package shop.haoshi.client.activity;

import android.content.Intent;

import com.canyinghao.canphotos.CanPhotoHelper;

import base.activity.BaseActivity;
import base.bean.rxbus.AddFragmentBean;
import base.bean.rxbus.PhotoRxbus;
import shop.haoshi.client.fragment.index.IndexFragment;
import util.RxBus;

public class MainActivity extends BaseActivity {


    @Override
    protected void initData() {
        sendFragment();
    }


//    private void initUserInfo() {
//        Map<String, String> map = new SharedPreferenUtil(this, "userLogin").getData(new String[]{"uid", "token"});
//        UserInfo.uid = map.get("uid");
//        UserInfo.token = map.get("token");
//    }

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
