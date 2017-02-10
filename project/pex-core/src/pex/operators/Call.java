/* $Id: Call.java,v 1.1 2016/10/14 18:12:43 david Exp $ */
package pex.operators;

import pex.Expression;
import pex.Value;
import pex.Visitor;

/**
 * Class for describing the call operator
 */
public class Call extends UnaryExpression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201611190210L;

  /**
   * @param argument
   */
  public Call(Expression argument) {
    super(argument);
  }

  /**
   * @param visitor
   *     The visitor.
   * @return The visitor's type representation of Call.
   */
  @Override  
  public Value accept(Visitor visitor){
    return visitor.visitCall(this);
  }
}
