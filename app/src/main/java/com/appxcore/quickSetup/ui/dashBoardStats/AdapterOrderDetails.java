package com.appxcore.quickSetup.ui.dashBoardStats;

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

public class AdapterOrderDetails extends RecyclerView.Adapter<AdapterOrderDetails.ViewHolder> {

    private List<ObjectsGenerics.ObjOrderHistory> listMain;
    private Context contextMain;

    AdapterOrderDetails(List<ObjectsGenerics.ObjOrderHistory> listData , Context context) {
        listMain = listData;
        contextMain = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_adp_customer_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.textId.setText(listMain.get(holder.getAdapterPosition()).getId());
        holder.tvName.setText(listMain.get(holder.getAdapterPosition()).getName());
        holder.tvMno.setText(listMain.get(holder.getAdapterPosition()).getMobileNo());
        holder.tvEid.setText(listMain.get(holder.getAdapterPosition()).getEmailId());


        if ( holder.getAdapterPosition() % 2 == 0 ){
            holder.textId.setBackgroundColor(ContextCompat.getColor(contextMain,R.color.colorPrimaryDark));
            holder.tvName.setBackgroundColor(ContextCompat.getColor(contextMain,R.color.colorPrimaryDark));
            holder.tvMno.setBackgroundColor(ContextCompat.getColor(contextMain,R.color.colorPrimaryDark));
            holder.tvEid.setBackgroundColor(ContextCompat.getColor(contextMain,R.color.colorPrimaryDark));
        }
    }


    @Override
    public int getItemCount() {
        return listMain.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textId,tvName,tvMno,tvEid;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName=itemView.findViewById(R.id.tv_adp_name);
            textId=itemView.findViewById(R.id.tv_adp_id);
            tvMno=itemView.findViewById(R.id.tv_adp_mobile);
            tvEid=itemView.findViewById(R.id.tv_adp_email_id);

        }
    }
    interface OrderHistoryInterface{

        void orderHistoryItemClicked(int position , ObjectsGenerics.ObjOrderHistory orderHistory);

    }
}

