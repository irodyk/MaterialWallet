package com.iuriirodyk.materialwallet.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.iuriirodyk.materialwallet.R;
import com.iuriirodyk.materialwallet.presenter.TransactionsPresenter;
import com.iuriirodyk.materialwallet.ui.activity.CardDetailsActivity;
import com.iuriirodyk.materialwallet.ui.adapter.TransactionListAdapter;
import com.iuriirodyk.materialwallet.view.TransactionsView;
import com.iuriirodyk.materialwallet.viewmodel.CardViewModel;
import com.iuriirodyk.materialwallet.viewmodel.TransactionViewModel;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import javax.inject.Inject;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 01.04.2018.
 */

@EFragment(R.layout.fragment_transactions)
public class TransactionsFragment extends BaseFragment implements TransactionsView {

    @Inject
    TransactionsPresenter presenter;

    @ViewById(R.id.recycler_transactions)
    RecyclerView recyclerView;

    @Override
    public void onAttach(Context context) {
        if(context instanceof CardDetailsActivity){

        }
        super.onAttach(context);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        ((CardDetailsActivity)getActivity()).getTransactionComponent().inject(this);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        CardViewModel card = CardViewModel.fromExtras(getArguments());
        presenter.setView(this);
        presenter.getTransactions(card);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.dispose();
    }

    @Override
    public void renderTransactions(List<TransactionViewModel> transactions) {
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(new TransactionListAdapter(transactions));
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
