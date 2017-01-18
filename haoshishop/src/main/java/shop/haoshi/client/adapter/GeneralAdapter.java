package shop.haoshi.client.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import base.bean.rxbus.AddFragmentBean;
import butterknife.BindView;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import shop.haoshi.client.R;
import shop.haoshi.client.bean.GeneralBean;
import shop.haoshi.client.pop.PopContactService;
import util.DrawableUtil;
import util.RxBus;
import view.TextImage;

/**
 * Created by dengmingzhi on 2017/1/16.
 */

public class GeneralAdapter extends BaseAdapter<GeneralBean> {


    public GeneralAdapter(Context ctx, ArrayList<GeneralBean> list) {
        super(ctx, list);
    }

    public GeneralAdapter(ArrayList<GeneralBean> list) {
        super(list);
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).type;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                return new Viewf5f5f5ViewHolder(View.inflate(ctx, R.layout.item_view, null));
            case 1:
                return new MyOrderNumViewHolder(View.inflate(ctx, R.layout.item_my_order_num, null));
            case 2:
                return new MyItemViewHolder(View.inflate(ctx, R.layout.item_my_center_item, null));
            case 3:
                return new ContactServiceViewHolder(View.inflate(ctx, R.layout.item_contact_service, null));
            case 4:
                return new TitleViewHolder(View.inflate(ctx, R.layout.item_title, null));
            case 5:
                return new TitleContentViewHolder(View.inflate(ctx, R.layout.item_title_content, null));
            case 6:
                return new TitleContentGoViewHolder(View.inflate(ctx, R.layout.item_title_content_go, null));
            case 7:
                return new PeosonSetHeadViewHolder(View.inflate(ctx, R.layout.item_person_head, null));
            case 8:
                return new PeosonSetTitleViewHolder(View.inflate(ctx, R.layout.item_peoson_set_title, null));
            case 9:
                return new MessageSetViewHolder(View.inflate(ctx, R.layout.item_message_set, null));

        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        GeneralBean data = list.get(position);
        switch (data.type) {
            case 1:
                MyOrderNumViewHolder mHolder = ((MyOrderNumViewHolder) holder);
                mHolder.tv_title.setText(data.title);
                mHolder.tv_title.setCompoundDrawables(null, DrawableUtil.setBounds(ctx.getResources().getDrawable(data.rid)), null, null);
                if (data.num == 0) {
                    mHolder.tv_num.setVisibility(View.GONE);
                } else {
                    mHolder.tv_num.setVisibility(View.VISIBLE);
                    mHolder.tv_num.setText(data.num + "");
                }
                break;
            case 2:
                MyItemViewHolder mHolderItem = ((MyItemViewHolder) holder);
                mHolderItem.tv_title.setText(data.title);
                mHolderItem.iv_img.setImageResource(data.rid);
                break;
            case 3:
                ContactServiceViewHolder mHolderContact = ((ContactServiceViewHolder) holder);
                mHolderContact.tv_title.setText(data.title);
                mHolderContact.tv_title.setCompoundDrawables(null, DrawableUtil.setBounds(ctx.getResources().getDrawable(data.rid)), null, null);
                break;
            case 4:
                TitleViewHolder mHolderTitle = ((TitleViewHolder) holder);
                mHolderTitle.tv_title.setText(data.title);
                break;
            case 5:
                TitleContentViewHolder mHolderTitleContent = ((TitleContentViewHolder) holder);
                mHolderTitleContent.tv_title.setText(data.title);
                mHolderTitleContent.tv_content.setText(data.content);
                break;
            case 6:
                TitleContentGoViewHolder mHolderTitleContentGo = ((TitleContentGoViewHolder) holder);
                mHolderTitleContentGo.tv_title.setText(data.title);
                mHolderTitleContentGo.tv_content.setText(data.content);
                break;
            case 7:
                PeosonSetHeadViewHolder mHolderPeosonSetHead = ((PeosonSetHeadViewHolder) holder);
                Glide.with(ctx).load(data.content).bitmapTransform(new CropCircleTransformation(ctx)).into(mHolderPeosonSetHead.iv_img);
                mHolderPeosonSetHead.tv_title.setText(data.title);
                break;
            case 8:
                PeosonSetTitleViewHolder mHolderPeosonSetTitle = ((PeosonSetTitleViewHolder) holder);
                mHolderPeosonSetTitle.tv_title.setText(data.title);
                break;
            case 9:
                MessageSetViewHolder mHolderMessageSet = ((MessageSetViewHolder) holder);
                mHolderMessageSet.tv_title.setText(data.title);
                mHolderMessageSet.tv_title.setCompoundDrawables(null, null, DrawableUtil.setBounds(ctx.getResources().getDrawable(list.get(position).num == 0 ? R.mipmap.wode_kaiguan : R.mipmap.wode_kaiguan_you)), null);
                break;
        }
    }

    public class MyOrderNumViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.tv_num)
        TextView tv_num;

        public MyOrderNumViewHolder(View itemView) {
            super(itemView);

        }
    }

    public class ContactServiceViewHolder extends BaseViewHolder {
        TextView tv_title;

        public ContactServiceViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView;
        }
    }


    public class MyItemViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.iv_img)
        ImageView iv_img;

        public MyItemViewHolder(View itemView) {
            super(itemView);
            tv_title.setOnClickListener(this);
        }

        @Override
        protected void itemOnclick(int id, int layoutPosition) {
            if (layoutPosition == list.size() - 1) {
                new PopContactService(ctx).showAtLocation(false);
            }
        }
    }

    public class TitleViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_title)
        TextView tv_title;

        public TitleViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        protected void onClick(int layoutPosition) {
            Fragment fragment = list.get(layoutPosition).fragment;
            if (fragment != null) {
                RxBus.get().post("addFragment", new AddFragmentBean(fragment));
            }
        }
    }

    public class TitleContentViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.tv_content)
        TextView tv_content;

        public TitleContentViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class TitleContentGoViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.tv_content)
        TextView tv_content;

        public TitleContentGoViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class PeosonSetHeadViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.iv_img)
        ImageView iv_img;

        public PeosonSetHeadViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class PeosonSetTitleViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_title)
        TextImage tv_title;

        public PeosonSetTitleViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextImage) itemView;
        }
    }

    public class MessageSetViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_title)
        TextView tv_title;
        public MessageSetViewHolder(View itemView) {
            super(itemView);
            tv_title.setOnClickListener(this);
        }

        @Override
        protected void itemOnclick(int id, int layoutPosition) {
            list.get(layoutPosition).num = list.get(layoutPosition).num == 0 ? 1 : 0;
            tv_title.setCompoundDrawables(null, null, DrawableUtil.setBounds(ctx.getResources().getDrawable(list.get(layoutPosition).num == 0 ? R.mipmap.wode_kaiguan : R.mipmap.wode_kaiguan_you)), null);
        }
    }

    public class Viewf5f5f5ViewHolder extends BaseViewHolder {

        public Viewf5f5f5ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
