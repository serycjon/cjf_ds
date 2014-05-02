/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

import java.io.Serializable;

/**
 *
 * @author jonas
 */
public class TymyHasOsoby_ID implements Serializable{
  private long tymy_tym_id;
  private long osoby_osoba_id;
 
  @Override
  public int hashCode() {
    return (int)(tymy_tym_id + osoby_osoba_id);
  }
 
  @Override
  public boolean equals(Object object) {
    if (object instanceof TymyHasOsoby_ID) {
      TymyHasOsoby_ID otherId = (TymyHasOsoby_ID) object;
      return (otherId.tymy_tym_id == this.tymy_tym_id) && (otherId.osoby_osoba_id == this.osoby_osoba_id);
    }
    return false;
  }
}
