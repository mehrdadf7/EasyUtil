package com.github.mehrdadf7.util;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

public class InfiniteScrollProvider {

    private RecyclerView recyclerView;
    private boolean isLoading = false;
    private OnLoadMoreListener onLoadMoreListener;
    private RecyclerView.LayoutManager layoutManager;
    private int lastVisibleItem;
    private int totalItemCount;
    private int previousItemCount = 0;
    private static final int THRESHOLD = 3;

    public void attach(RecyclerView recyclerView, OnLoadMoreListener onLoadMoreListener) {
        this.recyclerView = recyclerView;
        this.onLoadMoreListener = onLoadMoreListener;
        layoutManager =recyclerView.getLayoutManager();
        setInfiniteScrollGrid(layoutManager);
    }

    private void setInfiniteScrollGrid(final RecyclerView.LayoutManager layoutManager) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                totalItemCount = layoutManager.getItemCount();
                if (previousItemCount > totalItemCount) {
                    previousItemCount = totalItemCount - THRESHOLD;
                }
                if (layoutManager instanceof GridLayoutManager){
                    lastVisibleItem = ((GridLayoutManager)layoutManager).findLastVisibleItemPosition();
                }else if (layoutManager instanceof LinearLayoutManager){
                    lastVisibleItem = ((LinearLayoutManager)layoutManager).findLastVisibleItemPosition();
                }else if (layoutManager instanceof StaggeredGridLayoutManager){
                    StaggeredGridLayoutManager staggeredGridLayoutManager=(StaggeredGridLayoutManager) layoutManager;
                    int spanCount=staggeredGridLayoutManager.getSpanCount();
                    int[] ids=new int[spanCount];
                    staggeredGridLayoutManager.findLastVisibleItemPositions(ids);
                    int max=ids[0];
                    for (int i = 1; i < ids.length; i++) {
                        if (ids[1]>max){
                            max=ids[1];
                        }
                    }
                    lastVisibleItem=max;
                }
                if (totalItemCount > THRESHOLD) {
                    if (previousItemCount <= totalItemCount && isLoading) {
                        isLoading = false;
                        //Log.e("InfiniteScroll", "Data fetched");
                    }
                    if (!isLoading && (lastVisibleItem > (totalItemCount - THRESHOLD)) && totalItemCount > previousItemCount) {
                        if (onLoadMoreListener != null) {
                            onLoadMoreListener.onLoadMore();
                        }
                        //Log.e("InfiniteScroll", "End Of List");
                        isLoading = true;
                        previousItemCount = totalItemCount;
                    }
                }
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }
}
