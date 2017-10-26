package com.example.pappu.filtersbyrenderscript;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Float3;
import android.support.v8.renderscript.RenderScript;

import static com.example.pappu.filtersbyrenderscript.RSImageProcessing.FilterType.BrightContrastFilter;
import static com.example.pappu.filtersbyrenderscript.RSImageProcessing.FilterType.GammaFilter;
import static com.example.pappu.filtersbyrenderscript.RSImageProcessing.FilterType.GaussianBlurFilter;
import static com.example.pappu.filtersbyrenderscript.RSImageProcessing.FilterType.IllusionFilter;
import static com.example.pappu.filtersbyrenderscript.RSImageProcessing.FilterType.InvertFilter;
import static com.example.pappu.filtersbyrenderscript.RSImageProcessing.FilterType.PixelateFilter;

public class RSImageProcessing {

	public static class FilterType {

		public final static int Normal = 0;
		public final static int BlackWhiteFilter = 1;
		public final static int EdgeFilter = 4;
		public final static int GaussianBlurFilter = 3;
		public final static int GammaFilter = 2;
		public final static int InvertFilter = 5;
		public final static int PixelateFilter = 6;
		public final static int IllusionFilter = 7;
		public final static int BrightContrastFilter = 8;
		public final static int SaturationModifyFilter = 9;
		public final static int GradientMapFilter = 10;
		public final static int NoiseFilter = 11;
		public final static int BrickFilter = 12;
		public final static int FeatherFilter = 13;
		public final static int OilPaintFilter = 14;
		public final static int LightFilter = 15;
		public final static int MirrorFilter = 16;
		public final static int MistFilter = 17;
		public final static int MosaicFilter = 18;
		public final static int VignetteFilter = 19;
		public final static int PaintBorderFilter = 20;
		public final static int ReflectionFilter = 21;
		public final static int NightVisionFilter = 22;
		public final static int ComicFilter = 23;
		public final static int BlockPrintFilter = 24;
		public final static int GrayscaleFilter = 25;
		public final static int FillPatternFilter = 26;
		public final static int BlindFilter = 27;
		public final static int ColorQuantizeFilter = 28;
		public final static int ColorToneFilter = 29;
		public final static int SoftGlowFilter = 30;
		public final static int SmashColorFilter = 31;
		public final static int RadialDistortionFilter = 32;
		public final static int LowPassConvolutionFilter = 33;
		public final static int EdgeDetectionConvolutionFilter = 34;
		public final static int EmbossFilter = 35;
		public final static int HistogramEqualFilter = 36;
		public final static int ReliefFilter = 37;
		public final static int ThreeDGridFilter = 38;

	}

	public static void applyFilter(Allocation inAllocation, Bitmap outBitmap,
                                   Context context, int filterType, RenderScript rs) {

		switch (filterType) {
		
		case FilterType.BlackWhiteFilter:
			BlackWhiteFilter.getInstance(context, rs, outBitmap).process(
					inAllocation);
			break;
//		case GaussianBlurFilter:
//			// new GaussianBlurFilter(context, rs, outBitmap, 3,
//			// 30f).process(inAllocation);
//			break;
//		case GammaFilter:
////			destroyFilter(filterType);
//			GammaFilter.getInstance(context, rs, outBitmap, 50).process(
//					inAllocation);
//
//			// new GammaFilter(context, rs, outBitmap,
//			// 50).process(inAllocation);
//			break;
//		case InvertFilter:
////			destroyFilter(filterType);
//			InvertFilter.getInstance(context, rs, outBitmap).process(
//					inAllocation);
//			// new InvertFilter(context, rs, outBitmap).process(inAllocation);
//			break;
//		case PixelateFilter:
////			destroyFilter(filterType);
//			PixelateFilter.getInstance(context, rs, outBitmap, 50).process(
//					inAllocation);
//			// new PixelateFilter(context, rs, outBitmap, 50)
//			// .process(inAllocation);
//			break;
//		case IllusionFilter:
////			destroyFilter(filterType);
//			IllusionFilter.getInstance(context, rs, outBitmap).process(
//					inAllocation);
////			new IllusionFilter(context, rs, outBitmap).process(inAllocation);
//			break;
//		case BrightContrastFilter:
////			destroyFilter(filterType);
//			BrightContrastFilter.getInstance(context, rs, outBitmap).process(
//					inAllocation);
//			// new BrightContrastFilter(context, rs, outBitmap)
//			// .process(inAllocation);
//			break;
//		case FilterType.SaturationModifyFilter:
////			destroyFilter(filterType);
//			SaturationModifyFilter.getInstance(context, rs, outBitmap).process(
//					inAllocation);
////			new SaturationModifyFilter(context, rs, outBitmap)
////					.process(inAllocation);
//			break;
//		case FilterType.GradientMapFilter:
////			destroyFilter(filterType);
//			GradientMapFilter.getInstance(context, rs, outBitmap).process(
//					inAllocation);
////			new GradientMapFilter(context, rs, outBitmap).process(inAllocation);
//			break;
//		case FilterType.NoiseFilter:
//			destroyFilter(filterType);
//			NoiseFilter.getInstance(context, rs, outBitmap).process(
//					inAllocation);
////			new NoiseFilter(context, rs, outBitmap).process(inAllocation);
//			break;
//		case FilterType.BrickFilter:
////			destroyFilter(filterType);
//			BrickFilter.getInstance(context, rs, outBitmap).process(
//					inAllocation);
////			new BrickFilter(context, rs, outBitmap).process(inAllocation);
//			break;
//		case FilterType.FeatherFilter:
////			destroyFilter(filterType);
//			FeatherFilter.getInstance(context, rs, outBitmap).process(
//					inAllocation);
////			new FeatherFilter(context, rs, outBitmap).process(inAllocation);
//			break;
//		case FilterType.OilPaintFilter:
////			destroyFilter(filterType);
//			OilPaintFilter.getInstance(context, rs, outBitmap).process(
//					inAllocation);
////			new OilPaintFilter(context, rs, outBitmap).process(inAllocation);
//			break;
//		case FilterType.LightFilter:
////			destroyFilter(filterType);
//			LightFilter.getInstance(context, rs, outBitmap).process(
//					inAllocation);
////			new LightFilter(context, rs, outBitmap).process(inAllocation);
//			break;
//		case FilterType.MirrorFilter:
////			destroyFilter(filterType);
//			MirrorFilter.getInstance(context, rs, outBitmap).process(
//					inAllocation);
////			new MirrorFilter(context, rs, outBitmap).process(inAllocation);
//			break;
//		case FilterType.MistFilter:
////			destroyFilter(filterType);
//			MistFilter.getInstance(context, rs, outBitmap).process(
//					inAllocation);
////			new MistFilter(context, rs, outBitmap).process(inAllocation);
//			break;
//		case FilterType.MosaicFilter:
////			destroyFilter(filterType);
//			MosaicFilter.getInstance(context, rs, outBitmap).process(
//					inAllocation);
////			new MosaicFilter(context, rs, outBitmap).process(inAllocation);
//			break;
//		case FilterType.VignetteFilter:
////			destroyFilter(filterType);
//			VignetteFilter.getInstance(context, rs, outBitmap).process(
//					inAllocation);
////			new VignetteFilter(context, rs, outBitmap).process(inAllocation);
//			break;
//		case FilterType.PaintBorderFilter:
////			destroyFilter(filterType);
//			PaintBorderFilter.getInstance(context, rs, outBitmap).process(
//					inAllocation);
////			new PaintBorderFilter(context, rs, outBitmap).process(inAllocation);
//			break;
//		case FilterType.ReflectionFilter:
////			destroyFilter(filterType);
//			ReflectionFilter.getInstance(context, rs, outBitmap,true).process(
//					inAllocation);
////			new ReflectionFilter(context, rs, outBitmap, true)
////					.process(inAllocation);
//			break;
//		case FilterType.NightVisionFilter:
////			destroyFilter(filterType);
//			NightVisionFilter.getInstance(context, rs, outBitmap, 0.4f, 0.6f).process(
//					inAllocation);
////			new NightVisionFilter(context, rs, outBitmap, 0.4f, 0.6f)
////					.process(inAllocation);
//			break;
//		case FilterType.ComicFilter:
////			destroyFilter(filterType);
//			ComicFilter.getInstance(context, rs, outBitmap).process(
//					inAllocation);
////			new ComicFilter(context, rs, outBitmap).process(inAllocation);
//			break;
//		case FilterType.BlockPrintFilter:
////			destroyFilter(filterType);
//			BlockPrintFilter.getInstance(context, rs, outBitmap).process(
//					inAllocation);
////			new BlockPrintFilter(context, rs, outBitmap).process(inAllocation);
//			break;
//		case FilterType.GrayscaleFilter:
////			destroyFilter(filterType);
//			GrayscaleFilter.getInstance(context, rs, outBitmap).process(
//					inAllocation);
////			new GrayscaleFilter(context, rs, outBitmap).process(inAllocation);
//			break;
//		case FilterType.FillPatternFilter:
////			destroyFilter(filterType);
//			FillPatternFilter.getInstance(context, rs, outBitmap).process(
//					inAllocation);
////			new FillPatternFilter(context, rs, outBitmap).process(inAllocation);
//			break;
//		case FilterType.BlindFilter:
////			destroyFilter(filterType);
//			BlindFilter.getInstance(context, rs, outBitmap, new Float3(0f, 0f, 0f),
//					true).process(
//					inAllocation);
////			new BlindFilter(context, rs, outBitmap, new Float3(0f, 0f, 0f),
////					true).process(inAllocation);// new Float3(1.0f, 1.0f,
//												// 1.0f),false)
//			break;
//		case FilterType.ColorQuantizeFilter:
////			destroyFilter(filterType);
//			ColorQuantizeFilter.getInstance(context, rs, outBitmap).process(
//					inAllocation);
////			new ColorQuantizeFilter(context, rs, outBitmap)
////					.process(inAllocation);
//			break;
//		case FilterType.ColorToneFilter:
////			destroyFilter(filterType);
//			ColorToneFilter.getInstance(context, rs, outBitmap, new Float3(0.1294f,
//					0.6588f, 0.9961f), 0.7529f).process(
//					inAllocation);
////			new ColorToneFilter(context, rs, outBitmap, new Float3(0.1294f,
////					0.6588f, 0.9961f), 0.7529f).process(inAllocation);
//			break;
//		case FilterType.SoftGlowFilter:
////			destroyFilter(filterType);
//			SoftGlowFilter.getInstance(context, rs, outBitmap,3.0f, 0.4f, 1.1f).process(
//					inAllocation);
////			new SoftGlowFilter(context, rs, outBitmap, 3.0f, 0.4f, 1.1f)
////					.process(inAllocation);
//			break;
//		case FilterType.SmashColorFilter:
////			destroyFilter(filterType);
//			SmashColorFilter.getInstance(context, rs, outBitmap).process(
//					inAllocation);
////			new SmashColorFilter(context, rs, outBitmap).process(inAllocation);
//			break;
//		case FilterType.RadialDistortionFilter:
////			destroyFilter(filterType);
//			RadialDistortionFilter.getInstance(context, rs, outBitmap).process(
//					inAllocation);
////			new RadialDistortionFilter(context, rs, outBitmap)
////					.process(inAllocation);
//			break;
//		case FilterType.LowPassConvolutionFilter:
////			destroyFilter(filterType);
//			LowPassConvolutionFilter.getInstance(context, rs, outBitmap, 0.1f, false).process(
//					inAllocation);
////			new LowPassConvolutionFilter(context, rs, outBitmap, 0.1f, false)
////					.process(inAllocation);// 0.1f, true
//			break;
//		case FilterType.EdgeDetectionConvolutionFilter:
////			destroyFilter(filterType);
//			EdgeDetectionConvolutionFilter.getInstance(context, rs, outBitmap, 0.1f, false).process(
//					inAllocation);
////			new EdgeDetectionConvolutionFilter(context, rs, outBitmap, 0.1f,
////					false).process(inAllocation);// 0.1f, true
//			break;
//		case FilterType.EmbossFilter:
////			destroyFilter(filterType);
//			EmbossFilter.getInstance(context, rs, outBitmap, 0.1f, 0.1f, false).process(
//					inAllocation);
////			new EmbossFilter(context, rs, outBitmap, 1.0f, 0.1f, false)
////					.process(inAllocation);// 1.0f, 0.1f, true
//			break;
//		case FilterType.HistogramEqualFilter:
////			destroyFilter(filterType);
//			HistogramEqualFilter.getInstance(context, rs, outBitmap,  0.25f).process(
//					inAllocation);
////			new HistogramEqualFilter(context, rs, outBitmap, 0.25f)
////					.process(inAllocation);// 1.0f, 0.1f, true
//			break;
//		case FilterType.ReliefFilter:
////			destroyFilter(filterType);
//			ReliefFilter.getInstance(context, rs, outBitmap).process(
//					inAllocation);
////			new ReliefFilter(context, rs, outBitmap).process(inAllocation);// 1.0f,
//			// 0.1f,
//			// true
//			break;
//		case FilterType.ThreeDGridFilter:
//			destroyFilter(filterType);
//			ThreeDGridFilter.getInstance(context, rs, outBitmap, 16, 100.0f / 255.0f).process(
//					inAllocation);
//			new ThreeDGridFilter(context, rs, outBitmap, 16, 100.0f / 255.0f)
//					.process(inAllocation);// 1.0f, 0.1f, true
//			break;
		default:
			
			break;
		}

	}

	public static void destroyFilter(int filterType) {

		switch (filterType) {
		case FilterType.BlackWhiteFilter:
			BlackWhiteFilter.destroy();
			break;
		case GaussianBlurFilter:
//			GaussianBlurFilter.destroy();
			break;
		case GammaFilter:
//			GammaFilter.destroy();
			break;
		case InvertFilter:
//			InvertFilter.destroy();
			break;
		case PixelateFilter:
//			PixelateFilter.destroy();
			break;
		case IllusionFilter:
//			IllusionFilter.destroy();
			break;
		case BrightContrastFilter:
//			BrightContrastFilter.destroy();
			break;
		case FilterType.SaturationModifyFilter:
//			SaturationModifyFilter.destroy();
			break;
		case FilterType.GradientMapFilter:
//			GradientMapFilter.destroy();
			break;
		case FilterType.NoiseFilter:
//			NoiseFilter.destroy();
			break;
		case FilterType.BrickFilter:
//			BrickFilter.destroy();
			break;
		case FilterType.FeatherFilter:
//			FeatherFilter.destroy();
			break;
		case FilterType.OilPaintFilter:
//			OilPaintFilter.destroy();
			break;
		case FilterType.LightFilter:
//			LightFilter.destroy();
			break;
		case FilterType.MirrorFilter:
//			MirrorFilter.destroy();
			break;
		case FilterType.MistFilter:
//			MistFilter.destroy();
			break;
		case FilterType.MosaicFilter:
//			MosaicFilter.destroy();
			break;
		case FilterType.VignetteFilter:
//			VignetteFilter.destroy();
			break;
		case FilterType.PaintBorderFilter:
//			PaintBorderFilter.destroy();
			break;
		case FilterType.ReflectionFilter:
//			ReflectionFilter.destroy();
			break;
		case FilterType.NightVisionFilter:
//			NightVisionFilter.destroy();
			break;
		case FilterType.ComicFilter:
//			ComicFilter.destroy();
			break;
		case FilterType.BlockPrintFilter:
//			BlockPrintFilter.destroy();
			break;
		case FilterType.GrayscaleFilter:
//			GrayscaleFilter.destroy();
			break;
		case FilterType.FillPatternFilter:
//			FillPatternFilter.destroy();
			break;
		case FilterType.BlindFilter:
//			BlindFilter.destroy();
			break;
		case FilterType.ColorQuantizeFilter:
//			ColorQuantizeFilter.destroy();
			break;
		case FilterType.ColorToneFilter:
//			ColorToneFilter.destroy();
			break;
		case FilterType.SoftGlowFilter:
//			SoftGlowFilter.destroy();
			break;
		case FilterType.SmashColorFilter:
//			SmashColorFilter.destroy();
			break;
		case FilterType.RadialDistortionFilter:
//			RadialDistortionFilter.destroy();
			break;
		case FilterType.LowPassConvolutionFilter:
//			LowPassConvolutionFilter.destroy();
			break;
		case FilterType.EdgeDetectionConvolutionFilter:
//			EdgeDetectionConvolutionFilter.destroy();
			break;
		case FilterType.EmbossFilter:
//			EmbossFilter.destroy();
			break;
		case FilterType.HistogramEqualFilter:
//			HistogramEqualFilter.destroy();
			break;
		case FilterType.ReliefFilter:
//			ReliefFilter.destroy();
			break;
		case FilterType.ThreeDGridFilter:
//			ThreeDGridFilter.destroy();
			break;
		default:

			break;
		}

	}

}