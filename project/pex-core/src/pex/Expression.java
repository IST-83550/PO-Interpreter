/* $Id: Expression.java,v 1.1 2016/10/14 18:12:43 david Exp $ */
package pex;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.Serializable;

import pex.Value;

/**
 * An expressions can be evaluated to produce a value.
 */
public abstract class Expression implements Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201611171850L;

  /** Visitor accept method. */
  public abstract Value accept(Visitor visitor);
}
