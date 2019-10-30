package es.alten.rumbo.salesTax;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Utils {

	public static String parseQuanty(Number cantidad) {
		DecimalFormat df = new DecimalFormat();
		df.setRoundingMode(RoundingMode.HALF_EVEN);
		df.setMaximumFractionDigits(2);
		return df.format(cantidad);
	}
}
