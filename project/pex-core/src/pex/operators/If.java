/* $Id: BinaryExpression.java,v 1.1 2016/10/14 18:12:43 david Exp $ */
package pex.operators;

import pex.Expression;
import pex.Visitor;
import pex.Value;

/**
 * Class for describing binary operators.
 */
public class If extends Expression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201611180335L;

  /** Condition operand. */
  Expression _cond;

  /** Then operand. */
  Expression _then;

  /** Else operand. */
  Expression _else;

  /**
   * @param first
   *          first operand
   * @param second
   *          second operand
   * @param third
   *          third operand
   */
  public If(Expression first, Expression second, Expression third) {
    _cond = first;
    _then = second;
    _else = third;
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
    return _then;
  }

  /**
   * @return else operand
   */
  public Expression third() {
    return _else;
  }  

  /**
   * @param visitor
   *     The visitor.
   * @return The visitor's type representation of If.
   */
  @Override 
  public Value accept(Visitor visitor){
    return visitor.visitIf(this);
  }
}