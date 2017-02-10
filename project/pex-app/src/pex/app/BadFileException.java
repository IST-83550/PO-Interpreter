/* $Id: BadExpressionException.java,v 1.1 2016/10/14 18:12:43 david Exp $ */
package pex.app;

import pt.tecnico.po.ui.DialogException;

/**
 * Exception for representing format errors.
 */
@SuppressWarnings("nls")
public class BadFileException extends DialogException {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201611191904L;
  
  /** Original leaf expression. */
  String _description;

  /**
   * @param description
   */
  public BadFileException(String description) {
    _description = description;
  }
  
  /**
   * @return the description
   */
  public String getDescription() {
    return _description;
  }

  /** @see pt.tecnico.po.ui.DialogException#getMessage() */
  @Override
  public String getMessage() {
    return "Problemas no ficheiro: " + _description;
  }
  
}
