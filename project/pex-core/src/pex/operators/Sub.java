/* $Id: Sub.java,v 1.1 2016/10/14 18:12:43 david Exp $ */
package pex.operators;

import pex.Expression;
import pex.Value;
import pex.Visitor;

/**
 * Class for describing the subtraction ('-') operator
 */
public class Sub extends BinaryExpression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /**
   * @param first
   * @param second
   */
  public Sub(Expression first, Expression second) {
    super(first, second);
  }

  /**
   * @param visitor
   *     The visitor.
   * @return The visitor's type representation of Sub.
   */
  @Override
  public Value accept(Visitor visitor){
    return visitor.visitSub(this);
  }
}
