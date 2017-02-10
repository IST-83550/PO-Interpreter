/** @version $Id: DoRunProgram.java,v 1.1 2016/10/14 18:12:43 david Exp $ */
package pex.app.evaluator;

import pt.tecnico.po.ui.DialogException;

import pex.Interpreter;
import pex.app.EvaluatorVisitor;
import pex.operators.Program;
import pex.app.BadExpressionException;

/**
 * Run program.
 */
public class DoRunProgram extends ProgramCommand {
  
  /**
   * @param interpreter 
   * @param receiver
   */
  public DoRunProgram(Interpreter interpreter, Program receiver) {
    super(Label.RUN_PROGRAM, interpreter, receiver);
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    try {
    _receiver.accept(new EvaluatorVisitor(_interpreter));
    }
    catch(RuntimeException e){
      throw new BadExpressionException(e.getMessage());
    }
  }
  
}
