/* $Id: IntegerLiteral.java,v 1.1 2016/10/14 18:12:43 david Exp $ */
package pex.atomic;

import pex.Value;
import pex.Visitor;

/**
 * Class for describing syntactic tree leaves for holding integer values.
 */
public class IntegerLiteral extends Value<Integer> {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /**
   * @param value
   */
  public IntegerLiteral(int value) {
    super(value);
  }

  /**
   * @param visitor
   *     The visitor.
   * @return The visitor's type representation of IntegerLiteral.
   */
  @Override
  public Value accept(Visitor visitor){
    return visitor.visitIntegerLiteral(this);
  }
}
