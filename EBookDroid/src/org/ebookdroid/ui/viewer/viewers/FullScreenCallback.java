package org.ebookdroid.ui.viewer.viewers;

import org.ebookdroid.common.settings.AppSettings;

import android.app.Activity;
import android.view.View;

import java.util.concurrent.atomic.AtomicBoolean;

import org.emdev.common.android.AndroidVersion;
import org.emdev.ui.uimanager.IUIManager;

public class FullScreenCallback implements Runnable {

    protected final Activity activity;
    protected final View view;
    protected long time;
    protected final AtomicBoolean added = new AtomicBoolean();

    public FullScreenCallback(final Activity activity, final View view) {
        this.activity = activity;
        this.view = view;
    }

    @Override
    public void run() {
        if (AppSettings.getInstance().fullScreen && AndroidVersion.is41x) {
            final long expected = time + 2000;
            final long now = System.currentTimeMillis();
            if (now <= expected) {
                IUIManager.setFullScreenMode(activity, view, true);
                added.set(false);
            } else {
                view.getHandler().postDelayed(this, expected - now);
            }
        }
    }

    public void checkFullScreenMode() {
        if (AppSettings.getInstance().fullScreen && AndroidVersion.is41x) {
            this.time = System.currentTimeMillis();
            if (added.compareAndSet(false, true)) {
                view.getHandler().postDelayed(this, 2000);
            }
        }
    }
}
