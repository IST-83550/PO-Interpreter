/* $Id: Sequence.java,v 1.1 2016/10/14 18:12:45 david Exp $ */
package pex.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pex.Visitor;
import pex.Expression;
import pex.Value;

/**
 * Class Print(Sequence).
 */
public class Print extends Sequence {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201611180330L;

  /**
   * Default constructor (empty sequence).
   */
  public Print() {
    super();
  }

  /**
   * Constructor for single-expression sequences.
   * 
   * @param expression
   */
  public Print(Expression expression) {
    super(expression);
  }

  /**
   * Constructor for appending expressions to sequences.
   * 
   * @param previous
   * @param expression
   */
  public Print(Sequence previous, Expression expression) {
    super(previous, expression);
  }

  /**
   * @param expressions
   */
  public Print(List<Expression> expressions) {
    super(expressions);
  }

  /**
   * @param ix
   *          index to get
   * @return the expression at ix
   */
  public Expression get(int ix) {
    return super.get(ix);
  }

  /**
   * @param expression
   */
  public void add(Expression expression) {
    super.add(expression);
  }

  /**
   * @param index
   * @param expression
   */
  public void add(int index, Expression expression) {
    super.add(index, expression);
  }

  /**
   * @param index
   * @param expression
   */
  public void set(int index, Expression expression) {
    super.set(index, expression);
  }

  /**
   * @return a list with all the expressions
   */
  
  public List<Expression> getAll() {
    return super.getAll();
  }
  
  /**
   * @return last expression
   */
  public Expression getLastExpression() {
    return super.getLastExpression();
  }

  /**
   * @return size of sequence
   */
  public int size() {
    return super.size();
  }

  /**
   * @param visitor
   *     The visitor.
   * @return The visitor's type representation of Print.
   */
   @Override
  public Value accept(Visitor visitor){
    return visitor.visitPrint(this);
  } 
}

