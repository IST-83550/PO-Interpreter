/* $Id: Not.java,v 1.1 2016/10/14 18:12:43 david Exp $ */
package pex.operators;

import pex.Expression;
import pex.Visitor;
import pex.Value;

/**
 * Class for describing the negation operator
 */
public class Not extends UnaryExpression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /**
   * @param argument
   */
  public Not(Expression argument) {
    super(argument);
  }

  /**
   * @param visitor
   *     The visitor.
   * @return The visitor's type representation of Not.
   */
  @Override 
  public Value accept(Visitor visitor){
    return visitor.visitNot(this);
  }
}
