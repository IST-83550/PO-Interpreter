/* $Id: Neg.java,v 1.1 2016/10/14 18:12:43 david Exp $ */
package pex.operators;

import pex.Expression;
import pex.Visitor;
import pex.Value;

/**
 * Class for describing the neg operator
 */
public class Neg extends UnaryExpression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201611180319L;

  /**
   * @param argument
   */
  public Neg(Expression argument) {
    super(argument);
  }

  /**
   * @param visitor
   *     The visitor.
   * @return The visitor's type representation of Neg.
   */
  @Override 
  public Value accept(Visitor visitor){
    return visitor.visitNeg(this);
  }
}
