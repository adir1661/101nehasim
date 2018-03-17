package com.a101nechasim.tomer.controller.tools;

import android.content.IntentFilter;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;

/**
 * Created by Adir on 3/17/2018.
 */

public class Listeners {
    public static void attachEdittextToSeekbar(SeekBar seekBar, EditText editText) {
        new AttachEdittextToSeekbar(seekBar, editText);
    }

    private static class AttachEdittextToSeekbar implements SeekBar.OnSeekBarChangeListener, TextWatcher {
        SeekBar mSeekBar;
        EditText mEditText;

        public AttachEdittextToSeekbar(SeekBar seekBar, EditText editText) {
            mSeekBar = seekBar;
            mEditText = editText;
            mSeekBar.setOnSeekBarChangeListener(this);
            mEditText.addTextChangedListener(this);
        }


        //-----------------------text-watcher------------------------------
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String s1 = mEditText.getText().toString();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                if (s1 != "") {
                    int value = Integer.valueOf(mEditText.getText().toString());

                    if (value >= mSeekBar.getMin() && value <= mSeekBar.getMax()) {
                        mSeekBar.setProgress(value);
                    } else {
                        mEditText.setText(mSeekBar.getProgress() + "");
                    }

                } else
                    mSeekBar.setProgress(mSeekBar.getMin());
            }
        }

        //-----------------------seekbar-change------------------------------
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            mEditText.setText(String.valueOf(progress));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }
}
