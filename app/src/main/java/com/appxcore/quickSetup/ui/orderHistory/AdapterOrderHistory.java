package com.appxcore.quickSetup.ui.orderHistory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.appxcore.quickSetup.R;
import com.appxcore.quickSetup.utils.ObjectsGenerics;

import java.util.List;

public class AdapterOrderHistory extends RecyclerView.Adapter<AdapterOrderHistory.ViewHolder> {

    private List<ObjectsGenerics.ObjOrderHistory> listMain;
    private Context contextMain;

    AdapterOrderHistory(List<ObjectsGenerics.ObjOrderHistory> listData , Context context) {
        listMain = listData;
        contextMain = context;
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

        if ( holder.getAdapterPosition() % 2 == 0 ){

            holder.textId.setBackgroundColor(ContextCompat.getColor(contextMain,R.color.color_primary_bg));
            holder.tvName.setBackgroundColor(ContextCompat.getColor(contextMain,R.color.color_primary_bg));
            holder.tvDateTime.setBackgroundColor(ContextCompat.getColor(contextMain,R.color.color_primary_bg));
            holder.tvMno.setBackgroundColor(ContextCompat.getColor(contextMain,R.color.color_primary_bg));
            holder.tvEid.setBackgroundColor(ContextCompat.getColor(contextMain,R.color.color_primary_bg));
            holder.tvTotal.setBackgroundColor(ContextCompat.getColor(contextMain,R.color.color_primary_bg));
            holder.tvStatus.setBackgroundColor(ContextCompat.getColor(contextMain,R.color.color_primary_bg));

        }else {

            holder.textId.setBackgroundColor(ContextCompat.getColor(contextMain,R.color.color_primary_list_bg));
            holder.tvName.setBackgroundColor(ContextCompat.getColor(contextMain,R.color.color_primary_list_bg));
            holder.tvDateTime.setBackgroundColor(ContextCompat.getColor(contextMain,R.color.color_primary_list_bg));
            holder.tvMno.setBackgroundColor(ContextCompat.getColor(contextMain,R.color.color_primary_list_bg));
            holder.tvEid.setBackgroundColor(ContextCompat.getColor(contextMain,R.color.color_primary_list_bg));
            holder.tvTotal.setBackgroundColor(ContextCompat.getColor(contextMain,R.color.color_primary_list_bg));
            holder.tvStatus.setBackgroundColor(ContextCompat.getColor(contextMain,R.color.color_primary_list_bg));

        }
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

