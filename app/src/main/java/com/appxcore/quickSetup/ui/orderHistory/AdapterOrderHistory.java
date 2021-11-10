package com.appxcore.quickSetup.ui.orderHistory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.appxcore.quickSetup.R;
import com.appxcore.quickSetup.utils.ObjectsGenerics;

import java.util.List;

public class AdapterOrderHistory extends RecyclerView.Adapter<AdapterOrderHistory.ViewHolder> {

    private List<ObjectsGenerics.ObjOrderHistory> listMain;

    AdapterOrderHistory(List<ObjectsGenerics.ObjOrderHistory> listData) {
        listMain = listData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_adp_order_history_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textId.setText(listMain.get(holder.getAdapterPosition()).getId());
        holder.tvName.setText(listMain.get(holder.getAdapterPosition()).getName());
        holder.tvDateTime.setText(listMain.get(holder.getAdapterPosition()).getDateTime());
        holder.tvMno.setText(listMain.get(holder.getAdapterPosition()).getMobileNo());
        holder.tvEid.setText(listMain.get(holder.getAdapterPosition()).getEmailId());
        holder.tvTotal.setText(listMain.get(holder.getAdapterPosition()).getTotal());
        holder.tvStatus.setText(listMain.get(holder.getAdapterPosition()).getStatus());

    }

    @Override
    public int getItemCount() {
        return listMain.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textId,tvDateTime,tvName,tvMno,tvEid,tvTotal,tvStatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName=itemView.findViewById(R.id.tv_adp_name);
            tvDateTime=itemView.findViewById(R.id.tv_adp_date_time);
            textId=itemView.findViewById(R.id.tv_adp_id);
            tvMno=itemView.findViewById(R.id.tv_adp_mobile);
            tvEid=itemView.findViewById(R.id.tv_adp_email_id);
            tvTotal=itemView.findViewById(R.id.tv_adp_total);
            tvStatus=itemView.findViewById(R.id.tv_adp_status);

        }
    }
    interface OrderHistoryInterface{

        void orderHistoryItemClicked(int position , ObjectsGenerics.ObjOrderHistory orderHistory);

    }
}

