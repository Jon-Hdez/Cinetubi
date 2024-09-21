package uam.azc.adsi.cinetubi.controller;

import java.util.List;
import java.util.ArrayList;
import uam.azc.adsi.cinetubi.model.Snack;
import uam.azc.adsi.cinetubi.model.SnackCatalog;
import uam.azc.adsi.cinetubi.view.SnackPanel;
import uam.azc.adsi.cinetubi.view.VentaDulceriaView;

/**
 *
 * @author Avalos Albino Aldair Oswaldo 2222005685
 */
public class DulceriaController {

  private SnackCatalog snackCatalog;
  private VentaDulceriaView dulceriaView;

  public DulceriaController(SnackCatalog snackCatalog) {
    this.snackCatalog = snackCatalog;
  }

  public List<SnackPanel> createSnackPanels() {
    List<SnackPanel> snackPanels = new ArrayList<>();
    for (Snack s : snackCatalog.getCatalog()) {
      snackPanels.add(new SnackPanel(s));
    }
    return snackPanels;
  }

  public SnackCatalog getSnackCatalog() {
    return snackCatalog;
  }

  public void setSnackCatalog(SnackCatalog snackCatalog) {
    this.snackCatalog = snackCatalog;
  }

}
