/* $Id: And.java,v 1.1 2016/10/14 18:12:43 david Exp $ */
package pex.operators;

import pex.Expression;
import pex.Value;
import pex.Visitor;

/**
 * Class for describing the and operator
 */
public class And extends BinaryExpression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201611190209L;

  /**
   * @param first
   * @param second
   */
  public And(Expression first, Expression second) {
    super(first, second);
  }

  /**
   * @param visitor
   *     The visitor.
   * @return The visitor's type representation of And.
   */
  @Override
  public Value accept(Visitor visitor){
    return visitor.visitAnd(this);
  }
}
