package base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by dengmingzhi on 16/10/11.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void onClick(View view) {
        if (view == itemView) {
            onClick(getLayoutPosition());
        } else {
            itemOnclick(view.getId(), getLayoutPosition());
        }

    }

    @Override
    public boolean onLongClick(View view) {
        if (view == itemView) {
            onLongClick(getLayoutPosition());
        } else {
            itemOnLongClick(view.getId(), getLayoutPosition());

        }
        return true;
    }

    private void itemOnLongClick(int id, int layoutPosition) {

    }

    protected void onLongClick(int layoutPosition) {

    }

    protected void onClick(int layoutPosition) {

    }

    protected void itemOnclick(int id, int layoutPosition) {
    }
}