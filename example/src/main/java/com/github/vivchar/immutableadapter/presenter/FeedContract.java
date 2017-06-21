package com.github.vivchar.immutableadapter.presenter;


import com.github.vivchar.immutableadapter.model.Feed2;

import java.util.List;

public interface FeedContract {
    interface HomeView {


        void showAllFeed(List<Feed2> feed);




    }

    interface HomePresenter {
        void getAllFeed();

        void onFeedItemClicked(Feed2 film);
    }
}
