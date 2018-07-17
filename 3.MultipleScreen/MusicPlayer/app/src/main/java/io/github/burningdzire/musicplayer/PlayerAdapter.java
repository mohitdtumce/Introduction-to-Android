package io.github.burningdzire.musicplayer;

public interface PlayerAdapter {
    void loadMedia(int resourceId);

    void initializeProgressCallback();

    void play();

    void reset();

    void pause();

    boolean isPlaying();

    void seekTo(int position);

    void release();
}
