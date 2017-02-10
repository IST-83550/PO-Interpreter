/** @version $Id: DoReadProgram.java,v 1.1 2016/10/14 18:12:43 david Exp $ */
package pex.app.main;

import pex.Manager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import pex.ParserException;
import pex.app.BadFileException;
import pt.tecnico.po.ui.DialogException;

/**
 * Read existing program.
 */
public class DoReadProgram extends Command<Manager> {
  /** Input field. */
  Input<String> _filename;

  /**
   * @param receiver
   */
  public DoReadProgram(Manager receiver) {
    super(Label.READ_PROGRAM, receiver);
    _filename = _form.addStringInput(Message.programFileName());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException{
    _form.parse();
    try {
      _receiver.readProgram(_filename.value());
    } 
    catch (ParserException e ) {
      throw new BadFileException(_filename.value());
    }
  }

}
