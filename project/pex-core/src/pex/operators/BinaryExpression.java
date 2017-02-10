/* $Id: BinaryExpression.java,v 1.1 2016/10/14 18:12:43 david Exp $ */
package pex.operators;

import pex.Expression;

/**
 * Class for describing binary operators.
 */
public abstract class BinaryExpression extends Expression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201611190210L;

  /** First operand. */
  Expression _first;

  /** Second operand. */
  Expression _second;

  /**
   * @param first
   *          first operand
   * @param second
   *          second operand
   */
  public BinaryExpression(Expression first, Expression second) {
    _first = first;
    _second = second;
  }

  /**
   * @return first operand
   */
  public Expression first() {
    return _first;
  }

  /**
   * @return second operand
   */
  public Expression second() {
    return _second;
  }

}
