package shop.haoshi.client.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;

/**
 * Created by dengmingzhi on 2017/1/16.
 */

public class GeneralAdapter extends BaseAdapter {
    private int type;

    public void setType(int type) {
        this.type = type;
    }

    public GeneralAdapter(Context ctx, ArrayList list) {
        super(ctx, list);
    }

    public GeneralAdapter(ArrayList list) {
        super(list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    public class ViewHolder extends BaseViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
