package uam.azc.adsi.cinetubi.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Avalos Albino Aldair Oswaldo 2222005685
 */
public class MoneyFormatter {

  public static String format(BigDecimal amount) {
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
    return currencyFormatter.format(amount);
  }

}
