package com.a101nechasim.tomer.controller.tools;

import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

/*
 * Created by Adir on 3/17/2018.
 */

public class Listeners {
    public static final String TAG = "Listeners";

    /**
     * @param min is null if u support VERSION_CODES.O
     */

    public static void attachEdittextToSeekbar(SeekBar seekBar, EditText editText, @Nullable Integer min) {
        if (min == null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            new AttachEdittextToSeekbar(seekBar, editText, seekBar.getMin());
        else
            new AttachEdittextToSeekbar(seekBar, editText, min);
    }

    private static class AttachEdittextToSeekbar implements SeekBar.OnSeekBarChangeListener, TextWatcher {
        SeekBar mSeekBar;
        EditText mEditText;
        boolean changedOnce = false;
//        private int gap;

        public AttachEdittextToSeekbar(SeekBar seekBar, EditText editText, int min) {
            mSeekBar = seekBar;
            mEditText = editText;
            mEditText.addTextChangedListener(this);
            mSeekBar.setOnSeekBarChangeListener(this);
        }


        //-----------------------text-watcher------------------------------
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        boolean isTyping = false;
        private Timer timer = new Timer();
        private final long DELAY = 3000; // milliseconds

        @Override
        public void afterTextChanged(Editable s) {
            String s1 = mEditText.getText().toString();
            if (s1 != "") {// then set the value on the editText to the seekbar
                InsertToSeekBar(s1);
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    mSeekBar.setProgress(mSeekBar.getMin());
                    mEditText.setText(String.valueOf(mSeekBar.getMin()));
                }
            }

        }

        private void InsertToSeekBar(String s1) {
            try {
                final int value = Integer.valueOf(s1);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    if (value >= mSeekBar.getMin() && value <= mSeekBar.getMax() && value != mSeekBar.getProgress()) {
                        scheduleEditTextChange(value);
                    } else if (value < mSeekBar.getMin()) {
                        scheduleEditTextChange(mSeekBar.getMin());
                    }else if (value > mSeekBar.getMax())
                    {
                        scheduleEditTextChange(mSeekBar.getMax());
                    }
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        private void scheduleEditTextChange(final int value) {
            timer.cancel();
            timer = new Timer();
            timer.schedule(
                    new TimerTask() {
                        @Override
                        public void run() {
                            mEditText.setSelection(mEditText.getText().length());
                            mSeekBar.setProgress(value);
                            Log.d(TAG, "set seekbar");
                        }
                    },
                    DELAY - 1500
            );
        }


        //-----------------------seekbar-change------------------------------
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            mEditText.setText(String.valueOf(progress));
            Log.d(TAG, "set text");

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }
}
