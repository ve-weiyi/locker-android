package com.ve.lib_audio.mediaplayer.view.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.ve.lib_api.model.song.AudioBean;
import com.ve.lib_audio.mediaplayer.core.AudioController;
import com.ve.lib_image_loader.app.ImageLoaderManager;
import com.ve.music.R;

import java.util.ArrayList;

public class MusicPagerAdapter extends PagerAdapter {

	private ArrayList<AudioBean> mData;
	private Context mContext;


	private SparseArray<ObjectAnimator> mAnims = new SparseArray<>();

	public MusicPagerAdapter(ArrayList<AudioBean> queue, Context context, Object o) {
		mData = queue;
		mContext = context;
	}

	@NonNull
	@Override
	public Object instantiateItem(@NonNull ViewGroup container, int position) {
		View rootView = LayoutInflater.from(mContext).inflate(R.layout.indictor_item_view, null);
		//显示专辑图片
		final ImageView imageView = rootView.findViewById(R.id.circle_view);
		container.addView(rootView);
		ImageLoaderManager.getInstance()
				.displayImageForCircle(imageView, mData.get(position).getAlbumPic());
		mAnims.put(position, createAnim(imageView));
		return rootView;
	}

	private ObjectAnimator createAnim(ImageView imageView) {
		imageView.setRotation(0);
		ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, View.ROTATION.getName(), 0, 360);
		animator.setDuration(10000);
		animator.setInterpolator(new LinearInterpolator());
		animator.setRepeatCount(-1);
		if (AudioController.getInstance().isStartState()) {
			animator.start();
		}
		return animator;
	}


	public ObjectAnimator getAnims(int position) {
		return mAnims.get(position);
	}

	@Override
	public int getCount() {
		return mData == null ? 0 : mData.size();
	}

	@Override
	public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
		return view == o;
	}

	@Override
	public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
		container.removeView((View) object);
	}
}
