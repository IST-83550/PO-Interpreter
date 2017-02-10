/* $Id: And.java,v 1.1 2016/10/14 18:12:43 david Exp $ */
package pex.operators;

import pex.Visitor;
import pex.Value;
import pex.Expression;

/**
 * Class for describing the Reads operator
 */
public class Reads extends Expression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201611171853L;

  /**
   * @param visitor
   *     The visitor.
   * @return The visitor's type representation of Reads.
   */
  @Override
  public Value accept(Visitor visitor){
    return visitor.visitReads(this);
  }
}