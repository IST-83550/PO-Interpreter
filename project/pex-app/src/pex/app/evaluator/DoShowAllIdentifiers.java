/** @version $Id: DoShowAllIdentifiers.java,v 1.1 2016/10/14 18:12:43 david Exp $ */
package pex.app.evaluator;

import pex.Interpreter;
import pex.operators.Program;
import pex.app.ShowIdentifiersVisitor;

/**
 * Show all program identifiers.
 */
public class DoShowAllIdentifiers extends ProgramCommand {

  /**
   * @param interpreter
   * @param receiver
   */
  public DoShowAllIdentifiers(Interpreter interpreter, Program receiver) {
    super(Label.SHOW_ALL_IDENTIFIERS, interpreter, receiver);
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    ShowIdentifiersVisitor v = new ShowIdentifiersVisitor();
    _receiver.accept(v);
    _display.popup(v.printAllIdentifiers());
  }

}
