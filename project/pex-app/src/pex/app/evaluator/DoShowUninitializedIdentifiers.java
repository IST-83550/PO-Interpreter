/** @version $Id: DoShowUninitializedIdentifiers.java,v 1.1 2016/10/14 18:12:43 david Exp $ */
package pex.app.evaluator;

import pex.Interpreter;
import pex.operators.Program;
import pex.app.ShowIdentifiersVisitor;

/**
 * Show uninitialized identifiers.
 */
public class DoShowUninitializedIdentifiers extends ProgramCommand {

  /**
   * @param interpreter
   * @param receiver
   */
  public DoShowUninitializedIdentifiers(Interpreter interpreter, Program receiver) {
    super(Label.SHOW_UNINITIALIZED_IDENTIFIERS, interpreter, receiver);
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    ShowIdentifiersVisitor v = new ShowIdentifiersVisitor();
    _receiver.accept(v);
    _display.popup(v.printUnitializedIdentifiers());
  }

}
