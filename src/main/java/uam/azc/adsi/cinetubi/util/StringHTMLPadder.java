package uam.azc.adsi.cinetubi.util;

/**
 *
 * @author Avalos Albino Aldair Oswaldo 2222005685
 */
public class StringHTMLPadder {

  public static String padString(String input, int length) {
    StringBuilder sb = new StringBuilder(input);
    int spacesToAdd = length - input.length();
    if (spacesToAdd > 0) {
      for (int i = 0; i < spacesToAdd; i++) {
        sb.append("&nbsp;"); // Append non-breaking spaces
      }
    }
    return sb.toString();
  }
}
