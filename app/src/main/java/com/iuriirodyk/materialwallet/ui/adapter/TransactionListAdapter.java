package com.iuriirodyk.materialwallet.ui.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iuriirodyk.materialwallet.R;
import com.iuriirodyk.materialwallet.viewmodel.TransactionViewModel;

import java.util.List;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 02.04.2018.
 */

public class TransactionListAdapter extends RecyclerView.Adapter<TransactionListAdapter.ViewHolder> {


    private final List<TransactionViewModel> transactions;

    public TransactionListAdapter(List<TransactionViewModel> transactions){
        this.transactions = transactions;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.transaction_detail_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int pos) {
        TransactionViewModel item = transactions.get(pos);

        holder.tvDate.setText(item.date());
        holder.tvMerchant.setText(item.merchant());

        String amount = item.amount() + " " + item.currency();
        if(item.type() == TransactionViewModel.Type.INCOMING) {
            holder.tvAmount.setTextColor(Color.GREEN);
            amount = "+" + amount;
        }else {
            holder.tvAmount.setTextColor(Color.RED);
            amount = "-" + amount;
        }

        holder.tvAmount.setText(amount);
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView tvDate;
        final TextView tvMerchant;
        final TextView tvAmount;

        ViewHolder(View view) {
            super(view);
            tvDate = view.findViewById(R.id.tv_date);
            tvMerchant = view.findViewById(R.id.tv_merchant);
            tvAmount = view.findViewById(R.id.tv_amount);
        }
    }
}
