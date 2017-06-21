package com.github.vivchar.immutableadapter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.widget.Toast;

import com.github.vivchar.immutableadapter.items.BaseItemModel;
import com.github.vivchar.immutableadapter.items.category.CategoryModel;
import com.github.vivchar.immutableadapter.items.content.ContentModel;
import com.github.vivchar.immutableadapter.items.content.ContentViewRenderer;
import com.github.vivchar.immutableadapter.items.file.fileModel;
import com.github.vivchar.immutableadapter.items.file.fileViewRenderer;
import com.github.vivchar.immutableadapter.items.footer.CommentModel;
import com.github.vivchar.immutableadapter.items.footer.CommentViewRenderer;
import com.github.vivchar.immutableadapter.items.header.HeaderModel;
import com.github.vivchar.immutableadapter.items.header.HeaderViewRenderer;
import com.github.vivchar.immutableadapter.items.images.ImagesModel;
import com.github.vivchar.immutableadapter.items.images.ImagesViewRenderer;
import com.github.vivchar.immutableadapter.items.maps.MapsModel;
import com.github.vivchar.immutableadapter.items.maps.MapsViewRenderer;
import com.github.vivchar.immutableadapter.items.mp3.Mp3Model;
import com.github.vivchar.immutableadapter.items.mp3.Mp3ViewRenderer;
import com.github.vivchar.immutableadapter.items.profile.ProfileModel;
import com.github.vivchar.immutableadapter.items.profile.ProfileViewRenderer;
import com.github.vivchar.immutableadapter.items.soundcloud.SoundCloudModel;
import com.github.vivchar.immutableadapter.items.soundcloud.SoundCloudViewRenderer;
import com.github.vivchar.immutableadapter.items.text.TextViewRenderer;
import com.github.vivchar.immutableadapter.items.text.TextModel;
import com.github.vivchar.immutableadapter.items.viedo.VideoViewRenderer;
import com.github.vivchar.immutableadapter.items.viedo.ViedoModel;
import com.github.vivchar.immutableadapter.items.youtube.YoutubeModel;
import com.github.vivchar.immutableadapter.items.youtube.YoutubeViewRenderer;
import com.github.vivchar.immutableadapter.model.Feed2;
import com.github.vivchar.immutableadapter.presenter.FeedContract;
import com.github.vivchar.immutableadapter.presenter.FeedPresenter;
import com.github.vivchar.rendererrecyclerviewadapter.RendererRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements FeedContract.HomeView {

    public static final int MAX_SPAN_COUNT = 5;
    private RendererRecyclerViewAdapter mRecyclerViewAdapter;
    private RecyclerView mRecyclerView;
    private GridLayoutManager mLayoutManager;
    private LinearLayoutManager linearLayoutManager;
    FeedContract.HomePresenter presenter;
    private SwipeRefreshLayout mSwipeToRefresh;

    ArrayList<ProfileModel> listText = new ArrayList<>();

    ArrayList<BaseItemModel> items = new ArrayList<>();
    ArrayList<BaseItemModel> content = new ArrayList<>();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        presenter = new FeedPresenter(this);
        presenter.getAllFeed();

        mSwipeToRefresh = (SwipeRefreshLayout) findViewById(R.id.refresh);
        mSwipeToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                updateItems();
            }
        });

        mRecyclerViewAdapter = new RendererRecyclerViewAdapter();
        mRecyclerViewAdapter.registerRenderer(new HeaderViewRenderer(HeaderModel.TYPE, this));
        mRecyclerViewAdapter.registerRenderer(new ProfileViewRenderer(ProfileModel.TYPE, this, mListenerProfile));
        mRecyclerViewAdapter.registerRenderer(new TextViewRenderer(TextModel.TYPE, this, mListenerText));
        mRecyclerViewAdapter.registerRenderer(new ImagesViewRenderer(ImagesModel.TYPE, this, mListenerPhoto));
        mRecyclerViewAdapter.registerRenderer(new VideoViewRenderer(ViedoModel.TYPE, this, mListenerVideo));
        mRecyclerViewAdapter.registerRenderer(new fileViewRenderer(fileModel.TYPE, this, mListenerfile));
        mRecyclerViewAdapter.registerRenderer(new Mp3ViewRenderer(Mp3Model.TYPE, this, mListenerMp3));
        mRecyclerViewAdapter.registerRenderer(new MapsViewRenderer(MapsModel.TYPE, this, mListenerMaps));
        mRecyclerViewAdapter.registerRenderer(new YoutubeViewRenderer(YoutubeModel.TYPE, this, mListenerYoutube));
        mRecyclerViewAdapter.registerRenderer(new SoundCloudViewRenderer(SoundCloudModel.TYPE, this, mListenerSoundCloud));
        // mRecyclerViewAdapter.registerRenderer(new ContentViewRenderer(ContentModel.TYPE, this, mListener));
        mRecyclerViewAdapter.registerRenderer(new CommentViewRenderer(CommentModel.TYPE, this, mListenerComment));


        linearLayoutManager = new LinearLayoutManager(this);


        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        // mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        // mRecyclerView.addItemDecoration(new EqualSpacesItemDecoration(25));

        updateItems();
    }

    private void updateItems() {
//		mRecyclerViewAdapter.setItems(getItems());
//		mRecyclerViewAdapter.notifyDataSetChanged();

//        mRecyclerViewAdapter.setItems(getItems(), mDiffCallback);
//        mSwipeToRefresh.setRefreshing(false);
    }


    private int random(final int min, final int max) {
        final Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    @NonNull
    private final ContentViewRenderer.Listener mListener = new ContentViewRenderer.Listener() {
        @Override
        public void onCategoryClicked(@NonNull final CategoryModel model) {
            Toast.makeText(MainActivity.this, model.getName(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onContentItemClicked(@NonNull final ContentModel model) {
            Toast.makeText(MainActivity.this, model.getName(), Toast.LENGTH_SHORT).show();
        }
    };

    @NonNull
    private final CommentViewRenderer.Listener mListenerComment = new CommentViewRenderer.Listener() {
        @Override
        public void onCommentClicked(@NonNull CommentModel model) {
            Toast.makeText(getApplicationContext(), "gggg" + model.getID() + "", Toast.LENGTH_SHORT).show();
        }

    };

    @NonNull
    private final ImagesViewRenderer.Listener mListenerPhoto = new ImagesViewRenderer.Listener() {
        @Override
        public void onProfileClicked(@NonNull ImagesModel model) {
            Toast.makeText(getApplicationContext(), "gggg" + model.getID() + "", Toast.LENGTH_SHORT).show();
        }

    };

    @NonNull
    private final fileViewRenderer.Listener mListenerfile = new fileViewRenderer.Listener() {
        @Override
        public void onFileClicked(@NonNull fileModel model) {

        }

    };

    @NonNull
    private final VideoViewRenderer.Listener mListenerVideo = new VideoViewRenderer.Listener() {
        @Override
        public void onPlayClicked(@NonNull ViedoModel model) {
            Toast.makeText(getApplicationContext(), "gggg" + model.getID() + "", Toast.LENGTH_SHORT).show();
        }

    };


    @NonNull
    private final TextViewRenderer.Listener mListenerText = new TextViewRenderer.Listener() {
        @Override
        public void onTextClicked(@NonNull TextModel model) {

        }


    };

    @NonNull
    private final MapsViewRenderer.Listener mListenerMaps = new MapsViewRenderer.Listener() {
        @Override
        public void onMpasClicked(@NonNull MapsModel model) {

        }

    };

    @NonNull
    private final Mp3ViewRenderer.Listener mListenerMp3 = new Mp3ViewRenderer.Listener() {
        @Override
        public void onPlayClicked(@NonNull Mp3Model model) {

        }

    };


    private final ProfileViewRenderer.Listener mListenerProfile = new ProfileViewRenderer.Listener() {
        @Override
        public void onProfileClicked(@NonNull ProfileModel model) {
            Toast.makeText(getApplicationContext(), "gggg" + model.getID() + "", Toast.LENGTH_SHORT).show();
        }


    };

    private final YoutubeViewRenderer.Listener mListenerYoutube = new YoutubeViewRenderer.Listener() {
        @Override
        public void onYoutubeClicked(@NonNull YoutubeModel model) {

        }

    };

    private final SoundCloudViewRenderer.Listener mListenerSoundCloud = new SoundCloudViewRenderer.Listener() {
        @Override
        public void onSoundCloudClicked(@NonNull SoundCloudModel model) {

        }

    };


    @NonNull
    private final RendererRecyclerViewAdapter.DiffCallback<BaseItemModel> mDiffCallback = new RendererRecyclerViewAdapter
            .DiffCallback<BaseItemModel>() {
        @Override
        public boolean areItemsTheSame(final BaseItemModel oldItem, final BaseItemModel newItem) {
            return oldItem.getID() == newItem.getID();
        }

        @Override
        public boolean areContentsTheSame(final BaseItemModel oldItem, final BaseItemModel newItem) {
            return oldItem.equals(newItem);
        }

        @Nullable
        @Override
        public Object getChangePayload(final BaseItemModel oldItem, final BaseItemModel newItem) {
            if (oldItem.getType() != ContentModel.TYPE ||
                    newItem.getType() != ContentModel.TYPE) {
                return null;
            }

            final ContentModel oldContentItem = (ContentModel) oldItem;
            final ContentModel newContentItem = (ContentModel) newItem;

            final Bundle diffBundle = new Bundle();
            if (!oldContentItem.getName().equals(newContentItem.getName())) {
                diffBundle.putBoolean(ContentModel.KEY_NAME, true);
            }

            return diffBundle.size() == 0 ? null : diffBundle;
        }
    };

    @Override
    public void showAllFeed(List<Feed2> feed) {
        final int headerID = 1;
        String nameHeader = feed.get(0).getItems().get(0).getPublisher_data().getFirst_name();
        String avatarFile = feed.get(0).getItems().get(0).getPublisher_data().getFirst_name();
        items.add(new HeaderModel(headerID, nameHeader));
        for (int i = 0; i < feed.size(); i++) {
            int type = feed.get(i).getItems().get(i).getPost_type2();
            String name = feed.get(i).getItems().get(i).getPublisher_data().getUsername();
            String avatar = feed.get(i).getItems().get(i).getPublisher_data().getProfile_picture();

            if (type == 1) {

                String textContent = feed.get(i).getItems().get(i).getPost_data().getPost_text();
                String html = textContent;
                String result = Html.fromHtml(html).toString();
                if (result != null) {
                    items.add(new ProfileModel(i, name, avatar));
                    items.add(new TextModel(i, result));
                    items.add(new CommentModel(i, "some category #" + (i + 1)));
                }


            }
            if (type == 2) {
                String photoContent = feed.get(i).getItems().get(i).getPost_data().getPost_file();
                items.add(new ProfileModel(i, name, avatar));
                items.add(new ImagesModel(i, photoContent));
                items.add(new CommentModel(i, "some category #" + (i + 1)));
            }
            if (type == 3) {
                String urlMp4 = feed.get(i).getItems().get(i).getPost_data().getPost_file();
                String title = feed.get(i).getItems().get(i).getPost_data().getPost_text();
                items.add(new ProfileModel(i, name, avatar));
                items.add(new ViedoModel(i, urlMp4, title));
                items.add(new CommentModel(i, "some category #" + (i + 1)));
            }

            if (type == 4) {
                String urlfile = feed.get(i).getItems().get(i).getPost_data().getPost_file();
                String title = feed.get(i).getItems().get(i).getPost_data().getPost_text();
                items.add(new ProfileModel(i, name, avatar));
                items.add(new fileModel(i, urlfile, title));
                items.add(new CommentModel(i, "some category #" + (i + 1)));
            }

            if (type == 5) {
                String urlfile = feed.get(i).getItems().get(i).getPost_data().getPost_file();
                String title = feed.get(i).getItems().get(i).getPost_data().getPost_text();
                items.add(new ProfileModel(i, name, avatar));
                items.add(new Mp3Model(i, urlfile, title));
                items.add(new CommentModel(i, "some category #" + (i + 1)));
            }
            if (type == 6) {

                String title = feed.get(i).getItems().get(i).getPost_data().getPost_map();
                items.add(new ProfileModel(i, name, avatar));
                items.add(new MapsModel(i, title));
                items.add(new CommentModel(i, "some category #" + (i + 1)));
            }

            if (type == 7) {

                String title = feed.get(i).getItems().get(i).getPost_data().getPost_text();
                String cover = feed.get(i).getItems().get(i).getPost_data().getPost_thumb();
                String urlYoutube = feed.get(i).getItems().get(i).getPost_data().getPost_youtube();
                items.add(new ProfileModel(i, name, avatar));
                items.add(new YoutubeModel(i, urlYoutube, title, cover));
                items.add(new CommentModel(i, "some category #" + (i + 1)));
            }
            if (type == 8) {

                String title = feed.get(i).getItems().get(i).getPost_data().getPost_text();
                items.add(new ProfileModel(i, name, avatar));
                items.add(new SoundCloudModel(i, title));
                items.add(new CommentModel(i, "some category #" + (i + 1)));
            }


        }


        mRecyclerViewAdapter.setItems(items, mDiffCallback);
        mSwipeToRefresh.setRefreshing(false);

    }


    @NonNull
    private ArrayList<BaseItemModel> getItems() {

        final int headerID = 1;
        items.add(new HeaderModel(headerID, "header"));

        final int categoryCount = random(3, 9);

        for (int i = 0; i < categoryCount; i++) {
            final int categoryID = i * 10;
            final int commentID = i * 10;
            final int profileID = i;
            //items.add(new CategoryModel(categoryID, "some category #" + (i + 1)));


            final ArrayList<BaseItemModel> content = new ArrayList<>();

            final int contentCount = random(1, 1);
            for (int j = 0; j < contentCount; j++) {
                final int contentID = i;
                content.add(new ContentModel(contentID, "content " + (j + 1)));
            }
            Collections.shuffle(content);
            items.addAll(content);

        }

        return items;
    }
}
