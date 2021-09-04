package helper;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Utils {
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	static NumberFormat nf = new DecimalFormat("R$ #,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
	
	public static String data_string(Date data) {
		return sdf.format(data);
	}
	
	public static Date string_data(String data) {
		try {
			return sdf.parse(data);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static String double_string(double valor) {
		return nf.format(valor);
	}
	
	public static Double string_double(String valor) {
		try {
			return (Double)nf.parse(valor);
		}catch(ParseException e) {
			return null;
		}
	}
	
	public static void pausar(int segundos) {
		try {
			TimeUnit.SECONDS.sleep(segundos);
		}catch(InterruptedException e) {
			System.out.println("Erro ao pausar por " + segundos);
		}
	}

}
