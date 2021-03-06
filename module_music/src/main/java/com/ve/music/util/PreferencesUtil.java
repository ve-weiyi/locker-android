package com.ve.music.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.preference.PreferenceManager;

public final class PreferencesUtil {

    public static final String ARTIST_SORT_ORDER = "artist_sort_order";
    public static final String ARTIST_SONG_SORT_ORDER = "artist_song_sort_order";
    public static final String ARTIST_ALBUM_SORT_ORDER = "artist_album_sort_order";
    public static final String ALBUM_SORT_ORDER = "album_sort_order";
    public static final String ALBUM_SONG_SORT_ORDER = "album_song_sort_order";
    public static final String SONG_SORT_ORDER = "song_sort_order";
    private static final String NOW_PLAYING_SELECTOR = "now_paying_selector";
    private static final String TOGGLE_ANIMATIONS = "toggle_animations";
    private static final String TOGGLE_SYSTEM_ANIMATIONS = "toggle_system_animations";
    private static final String TOGGLE_ARTIST_GRID = "toggle_artist_grid";
    private static final String TOGGLE_ALBUM_GRID = "toggle_album_grid";
    private static final String TOGGLE_HEADPHONE_PAUSE = "toggle_headphone_pause";
    private static final String THEME_PREFERNCE = "theme_preference";
    private static final String START_PAGE_INDEX = "start_page_index";
    private static final String START_PAGE_PREFERENCE_LASTOPENED = "start_page_preference_latopened";
    private static final String NOW_PLAYNG_THEME_VALUE = "now_playing_theme_value";
    private static final String FAVRIATE_MUSIC_PLAYLIST = "favirate_music_playlist";
    private static final String DOWNMUSIC_BIT = "down_music_bit";
    private static final String CURRENT_DATE = "currentdate";

    private static PreferencesUtil sInstance;

    private static SharedPreferences mPreferences;

    public PreferencesUtil(final Context context) {
        mPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static PreferencesUtil getInstance(final Context context) {
        if (sInstance == null) {
            sInstance = new PreferencesUtil(context.getApplicationContext());
        }
        return sInstance;
    }

    public long lastExit() {
        return mPreferences.getLong("last_err_exit", 0);
    }

    public void setExitTime() {
        final SharedPreferences.Editor editor = mPreferences.edit();
        editor.putLong("last_err_exit", System.currentTimeMillis());
        editor.apply();
    }

    public boolean isCurrentDayFirst(String str) {
        return str.equals(mPreferences.getString(CURRENT_DATE, ""));
    }

    public void setCurrentDate(String str) {
        final SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString(CURRENT_DATE, str);
        editor.apply();
    }

    public void setPlayLink(long id, String link) {
        final SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString(id + "", link);
        editor.apply();
    }

    public String getPlayLink(long id) {
        return mPreferences.getString(id + "", null);
    }


    public void setItemPostion(String str) {
        final SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString("item_relative_position", str);
        editor.apply();
    }

    public String getItemPosition() {
        return mPreferences.getString("item_relative_position", "???????????? ???????????? ????????????");
    }

    public void setDownMusicBit(int bit) {
        final SharedPreferences.Editor editor = mPreferences.edit();
        editor.putInt(DOWNMUSIC_BIT, bit);
        editor.apply();
    }

    public int getDownMusicBit() {
        return mPreferences.getInt(DOWNMUSIC_BIT, 192);
    }

    public boolean getFavriateMusicPlaylist() {
        return mPreferences.getBoolean(FAVRIATE_MUSIC_PLAYLIST, false);
    }

    public void setFavriateMusicPlaylist(boolean b) {
        final SharedPreferences.Editor editor = mPreferences.edit();
        editor.putBoolean(FAVRIATE_MUSIC_PLAYLIST, b);
        editor.apply();
    }

    public void setOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        mPreferences.registerOnSharedPreferenceChangeListener(listener);
    }

    public boolean getAnimations() {
        return mPreferences.getBoolean(TOGGLE_ANIMATIONS, true);
    }

    public boolean getSystemAnimations() {
        return mPreferences.getBoolean(TOGGLE_SYSTEM_ANIMATIONS, true);
    }

    public boolean isArtistsInGrid() {
        return mPreferences.getBoolean(TOGGLE_ARTIST_GRID, true);
    }

    public void setArtistsInGrid(final boolean b) {
        final SharedPreferences.Editor editor = mPreferences.edit();
        editor.putBoolean(TOGGLE_ARTIST_GRID, b);
        editor.apply();
    }

    public boolean isAlbumsInGrid() {
        return mPreferences.getBoolean(TOGGLE_ALBUM_GRID, true);
    }

    public void setAlbumsInGrid(final boolean b) {
        final SharedPreferences.Editor editor = mPreferences.edit();
        editor.putBoolean(TOGGLE_ALBUM_GRID, b);
        editor.apply();
    }

    public boolean pauseEnabledOnDetach() {
        return mPreferences.getBoolean(TOGGLE_HEADPHONE_PAUSE, true);
    }

    public String getTheme() {
        return mPreferences.getString(THEME_PREFERNCE, "light");
    }

    public int getStartPageIndex() {
        return mPreferences.getInt(START_PAGE_INDEX, 0);
    }

    public void setStartPageIndex(final int index) {
        final SharedPreferences.Editor editor = mPreferences.edit();
        editor.putInt(START_PAGE_INDEX, index);
        editor.apply();
    }

    public void setLastOpenedAsStartPagePreference(boolean preference) {
        final SharedPreferences.Editor editor = mPreferences.edit();
        editor.putBoolean(START_PAGE_PREFERENCE_LASTOPENED, preference);
        editor.apply();
    }

    public boolean lastOpenedIsStartPagePreference() {
        return mPreferences.getBoolean(START_PAGE_PREFERENCE_LASTOPENED, true);
    }

    private void setSortOrder(final String key, final String value) {
        final SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public final String getArtistSortOrder() {
        return mPreferences.getString(ARTIST_SORT_ORDER, SortOrder.ArtistSortOrder.ARTIST_A_Z);
    }

    public void setArtistSortOrder(final String value) {
        setSortOrder(ARTIST_SORT_ORDER, value);
    }

    public final String getArtistSongSortOrder() {
        return mPreferences.getString(ARTIST_SONG_SORT_ORDER,
                SortOrder.ArtistSongSortOrder.SONG_A_Z);
    }

    public static String FOLDER_SONG_SORT_ORDER = "folder_sort";

    public void setFolerSortOrder(final String value) {
        setSortOrder(FOLDER_SONG_SORT_ORDER, value);
    }

    public final String getFoloerSortOrder() {
        return mPreferences.getString(FOLDER_SONG_SORT_ORDER, SortOrder.FolderSortOrder.FOLDER_A_Z);
    }

    public void setArtistSongSortOrder(final String value) {
        setSortOrder(ARTIST_SONG_SORT_ORDER, value);
    }

    public final String getArtistAlbumSortOrder() {
        return mPreferences.getString(ARTIST_ALBUM_SORT_ORDER,
                SortOrder.ArtistAlbumSortOrder.ALBUM_A_Z);
    }

    public void setArtistAlbumSortOrder(final String value) {
        setSortOrder(ARTIST_ALBUM_SORT_ORDER, value);
    }

    public final String getAlbumSortOrder() {
        return mPreferences.getString(ALBUM_SORT_ORDER, SortOrder.AlbumSortOrder.ALBUM_A_Z);
    }

    public void setAlbumSortOrder(final String value) {
        setSortOrder(ALBUM_SORT_ORDER, value);
    }

    public final String getAlbumSongSortOrder() {
        return mPreferences.getString(ALBUM_SONG_SORT_ORDER,
                SortOrder.AlbumSongSortOrder.SONG_TRACK_LIST);
    }

    public void setAlbumSongSortOrder(final String value) {
        setSortOrder(ALBUM_SONG_SORT_ORDER, value);
    }

    public final String getSongSortOrder() {
        return mPreferences.getString(SONG_SORT_ORDER, SortOrder.SongSortOrder.SONG_A_Z);
    }

    public void setSongSortOrder(final String value) {
        setSortOrder(SONG_SORT_ORDER, value);
    }

    public final boolean didNowplayingThemeChanged() {
        return mPreferences.getBoolean(NOW_PLAYNG_THEME_VALUE, false);
    }

    public void setNowPlayingThemeChanged(final boolean value) {
        final SharedPreferences.Editor editor = mPreferences.edit();
        editor.putBoolean(NOW_PLAYNG_THEME_VALUE, value);
        editor.apply();
    }

    public void setFilterSize(int size) {
        final SharedPreferences.Editor editor = mPreferences.edit();
        editor.putInt("filtersize", size);
        editor.apply();
    }

    public void setFilterTime(int time) {
        final SharedPreferences.Editor editor = mPreferences.edit();
        editor.putInt("filtertime", time);
        editor.apply();
    }

    public int getFilterSize() {
        return mPreferences.getInt("filtersize", 1024 * 1024);
    }

    public int getFilterTime() {
        return mPreferences.getInt("filtertime", 60 * 1000);
    }
}