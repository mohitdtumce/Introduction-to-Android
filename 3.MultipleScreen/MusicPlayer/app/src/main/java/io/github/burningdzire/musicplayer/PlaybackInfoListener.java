package io.github.burningdzire.musicplayer;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class PlaybackInfoListener {
    @Retention(RetentionPolicy.SOURCE)
    @IntDef({State.INVALID, State.PLAYING, State.PAUSED, State.RESET, State.COMPLETED})
    @interface State {
        int INVALID = -1;
        int PLAYING = 0;
        int PAUSED = 1;
        int RESET = 2;
        int COMPLETED = 3;
    }

    public static String convertStateToString(@State int state) {
        String stateToString;
        switch (state) {
            case State.INVALID:
                stateToString = "INVALID";
                break;
            case State.PLAYING:
                stateToString = "PLAYING";
                break;
            case State.PAUSED:
                stateToString = "PAUSED";
                break;
            case State.RESET:
                stateToString = "RESET";
                break;
            case State.COMPLETED:
                stateToString = "COMPLETED";
                break;
            default:
                stateToString = "N/A";

        }
        return stateToString;
    }

    void onLogUpdated(String formattedMessage) {
    }

    void onDurationChanged(int duration) {
    }

    void onPositionChanged(int position) {
    }

    void onStateChanged(@State int state) {
    }

    void onPlaybackCompleted() {
    }

}
