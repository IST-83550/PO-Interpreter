/* $Id: While.java,v 1.1 2016/10/14 18:12:43 david Exp $ */
package pex.operators;

import pex.Expression;
import pex.Value;
import pex.Visitor;

/**
 * Class for describing the ge operator
 */
public class While extends Expression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201611180346L;

  /** Condition operand. */
  Expression _cond;

  /** Action operand. */
  Expression _action;

  /**
   * @param first
   * @param second
   */
  public While(Expression first, Expression second) {
  	_cond = first;
  	_action = second;
  }

   /**
   * @return condition operand
   */
  public Expression first() {
    return _cond;
  }

  /**
   * @return then operand
   */
  public Expression second() {
    return _action;
  } 

  /**
   * @param visitor
   *     The visitor.
   * @return The visitor's type representation of While.
   */
  @Override 
  public Value accept(Visitor visitor){
    return visitor.visitWhile(this);
  }
}
