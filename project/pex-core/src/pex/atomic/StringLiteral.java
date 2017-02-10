/* $Id: StringLiteral.java,v 1.1 2016/10/14 18:12:43 david Exp $ */
package pex.atomic;

import pex.Value;
import pex.Visitor;

/**
 * Class for describing syntactic tree leaves for holding string values.
 */
public class StringLiteral extends Value<String> {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /**
   * @param value
   */
  public StringLiteral(String value) {
    super(value);
  }

  /**
   * @param visitor
   *     The visitor.
   * @return The visitor's type representation of StringLiteral.
   */
  @Override
  public Value accept(Visitor visitor){
    return visitor.visitStringLiteral(this);
  }
}
