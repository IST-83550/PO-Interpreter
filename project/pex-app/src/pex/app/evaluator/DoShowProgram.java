/** @version $Id: DoShowProgram.java,v 1.1 2016/10/14 18:12:43 david Exp $ */
package pex.app.evaluator;

import pex.Interpreter;
import pex.operators.Program;
import pex.app.RenderVisitor;

/**
 * Show program (presents code).
 */
public class DoShowProgram extends ProgramCommand {

  /**
   * @param interpreter
   * @param receiver
   */
  public DoShowProgram(Interpreter interpreter, Program receiver) {
    super(Label.SHOW_PROGRAM, interpreter, receiver);
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    _display.popup(_receiver.accept(new RenderVisitor()));
  }
  
}
