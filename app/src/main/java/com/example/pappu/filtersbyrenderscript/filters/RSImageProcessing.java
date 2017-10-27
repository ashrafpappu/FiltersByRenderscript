package com.example.pappu.filtersbyrenderscript.filters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.RenderScript;


public class RSImageProcessing {

	public static class FilterType {

		public final static int Normal = 0;
		public final static int BlackWhiteFilter = 1;
		public final static int BrightContrastFilter = 8;


	}

	public static void applyFilter(Allocation inAllocation, Bitmap outBitmap,
                                   Context context, int filterType, RenderScript rs) {

		switch (filterType) {
		
		case FilterType.BlackWhiteFilter:
			BlackWhiteFilter.getInstance(context, rs, outBitmap).process(
					inAllocation);
			break;
			case FilterType.BrightContrastFilter:
			BrightContrastFilter.getInstance(context, rs, outBitmap).process(
					inAllocation);
			break;
		default:
			
			break;
		}

	}

	public static void destroyFilter(int filterType) {

		switch (filterType) {
		case FilterType.BlackWhiteFilter:
			BlackWhiteFilter.destroy();
			break;
			case FilterType.BrightContrastFilter:
				BrightContrastFilter.destroy();
				break;
		default:

			break;
		}

	}

}