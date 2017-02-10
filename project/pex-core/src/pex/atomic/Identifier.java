/* $Id: Identifier.java,v 1.1 2016/10/14 18:12:43 david Exp $ */
package pex.atomic;

import pex.Expression;
import pex.Value;
import pex.Visitor;

/**
 * Class for describing syntactic tree leaves for holding identifier values.
 */
public class Identifier extends Expression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /** Identifier name. */
  private String _name;

  /**
   * @param name
   */
  public Identifier(String name) {
    _name = name;
  }

  /**
   * @return the name
   */
  public String getName() {
    return _name;
  }

  /**
   * @param visitor
   *     The visitor.
   * @return The visitor's type representation of Identifier.
   */
  @Override
  public Value accept(Visitor visitor){
    return visitor.visitIdentifier(this);
  }
}
