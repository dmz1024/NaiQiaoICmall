package shop.haoshi.client.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import butterknife.BindView;
import shop.haoshi.client.R;
import shop.haoshi.client.bean.MessageBean;

/**
 * Created by dengmingzhi on 2017/1/18.
 */

public class MessageAdapter extends BaseAdapter<MessageBean.Data> {
    public MessageAdapter(Context ctx, ArrayList<MessageBean.Data> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_message, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.iv_img)
        ImageView iv_img;
        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.tv_content)
        TextView tv_content; @BindView(R.id.tv_time)
        TextView tv_time;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
