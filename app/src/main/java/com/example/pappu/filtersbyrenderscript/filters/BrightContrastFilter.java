package com.example.pappu.filtersbyrenderscript.filters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v8.renderscript.RenderScript;

import com.example.pappu.filtersbyrenderscript.renderscript.ScriptC_BrightContrastFilter;

public class BrightContrastFilter extends ImageFilter {
	// The brightness factor.
	// Should be in the range [-1.0f, 1.0f].
	private final float mBrightnessFactor;

	// The contrast factor.
	// Should be in the range [-1.0f, 1.0f].
	private final float mContrastFactor;

	private static BrightContrastFilter instance;
	private ScriptC_BrightContrastFilter script;

	public BrightContrastFilter(Context context, RenderScript rs,
                                Bitmap outBitmap) {
		super(context, rs, outBitmap);
		mBrightnessFactor = (float) 0.5f;
		mContrastFactor = (float) 0.5f;
		script = new ScriptC_BrightContrastFilter(rs);
	}

	public static BrightContrastFilter getInstance(Context context,
			RenderScript rs, Bitmap outBimap) {
		if (instance == null)
			instance = new BrightContrastFilter(context, rs, outBimap);
		return instance;
	}

	public static void destroy() {
		instance = null;
	}

	@Override
	protected final void _process() {

		script.set_gIn(mInAllocation);
		script.set_gOut(mOutAllocation);
		script.set_gBrightnessFactor(mBrightnessFactor);
		script.set_gContrastFactor(mContrastFactor);
		script.set_gScript(script);

		script.invoke_filter();
		mScript = script;
	}
};