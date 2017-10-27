package com.example.pappu.filtersbyrenderscript.filters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v8.renderscript.RenderScript;

import com.example.pappu.filtersbyrenderscript.renderscript.ScriptC_BlackWhiteFilter;


public class BlackWhiteFilter extends ImageFilter {
	
	  private static BlackWhiteFilter instance;
	  private ScriptC_BlackWhiteFilter script;

	  private BlackWhiteFilter(Context context, RenderScript rs, Bitmap outBitmap)
	  {
	    super(context, rs, outBitmap);
	    script = new ScriptC_BlackWhiteFilter(rs);
	  }
	  public static BlackWhiteFilter getInstance(Context context, RenderScript rs, Bitmap outBimap)
	  {
	    if (instance == null)
	      instance = new BlackWhiteFilter(context, rs, outBimap);
	    return instance;
	  }
	  public static void destroy()
	  {
	    instance = null;
	  }


	@Override
	protected final void _process() {
		
		

		script.set_gIn(mInAllocation);
		script.set_gOut(mOutAllocation);
		script.set_gScript(script);
		
//		script.forEach_root(mInAllocation, mOutAllocation);

		script.invoke_filter();
		mScript = script;
	}	
};
