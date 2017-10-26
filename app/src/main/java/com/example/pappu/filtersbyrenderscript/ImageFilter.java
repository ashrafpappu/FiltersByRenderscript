package com.example.pappu.filtersbyrenderscript;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.ScriptC;
import android.util.Log;

public abstract class ImageFilter {
	private long startTime;

	protected RenderScript mRS;

	protected Allocation mInAllocation;

	protected Allocation mOutAllocation;

	protected ScriptC mScript;
	protected Context context;

//	protected Bitmap mBitmapIn;

	protected Bitmap outBitmap;



//	public ImageFilter(Context context, Bitmap mBitmapIn, Bitmap mBitmapOut,
//			File outputFile) {
//		// TODO Auto-generated constructor stub
//		this.context = context;
////		this.mBitmapIn = mBitmapIn;
//		this.outBitmap = mBitmapOut;
//
//
//	}

	public ImageFilter(Context paramContext, RenderScript paramRenderScript,
                       Bitmap paramBitmap) {
		this.context = paramContext;
		this.outBitmap = paramBitmap;
		this.mRS = paramRenderScript;
		mInAllocation = Allocation.createFromBitmap(mRS, outBitmap,
				Allocation.MipmapControl.MIPMAP_NONE, Allocation.USAGE_SCRIPT);
		this.mOutAllocation = Allocation.createFromBitmap(this.mRS,
				paramBitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
	}

//	protected void preProcess() {
//		mRS = RenderScript.create(context);
//		mInAllocation = Allocation.createFromBitmap(mRS, mBitmapIn,
//				Allocation.MipmapControl.MIPMAP_NONE, Allocation.USAGE_SCRIPT);
//		mOutAllocation = Allocation.createFromBitmap(mRS, outBitmap,
//				Allocation.MipmapControl.MIPMAP_NONE, Allocation.USAGE_SCRIPT);
//	}

	protected void preProcess(Allocation paramAllocation) {
		this.mInAllocation = paramAllocation;
	}

	protected void _preProcess() {
	}

	protected abstract void _process();

	protected void _postProcess() {
	}

//	public void process() {
//		preProcess();
//		startTime = System.currentTimeMillis();
//		_preProcess();
//		_process();
//		Log.d("profile",
//				getClass().getSimpleName() + " use "
//						+ (System.currentTimeMillis() - startTime));
//		_postProcess();
//		postProcess();
//	}

	public void process(Allocation paramAllocation) {
		preProcess(paramAllocation);
		this.startTime = System.currentTimeMillis();
		_preProcess();
		_process();
		Log.d("profile",
				getClass().getSimpleName() + " use "
						+ (System.currentTimeMillis() - this.startTime));
		_postProcess();
		postProcess();
	}

	protected void postProcess() {
		mOutAllocation.copyTo(outBitmap);
		// File outputFile = new File(Environment.getExternalStorageDirectory()
		// + "/test/" + this.getClass().getSimpleName() + ".jpeg");

//		mScript.destroy();
//		mScript = null;
//		mInAllocation.destroy();
//		mInAllocation = null;
//		mOutAllocation.destroy();
//		mOutAllocation = null;
//		mRS.destroy();
//		mRS = null;
		System.gc();
	}
}
