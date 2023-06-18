package com.example.genshin_wiki;

import android.content.SearchRecentSuggestionsProvider;

public class MySearchProvider extends SearchRecentSuggestionsProvider {
    public final static String AUTHORITY = "user.all";
    public final static int MODE = DATABASE_MODE_QUERIES;

    public MySearchProvider() {
        setupSuggestions(AUTHORITY, MODE);
    }
}
