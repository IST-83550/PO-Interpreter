/** @version $Id: DoOpen.java,v 1.1 2016/10/14 18:12:43 david Exp $ */
package pex.app.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import pex.Manager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

/**
 * Open existing interpreter.
 */
public class DoOpen extends Command<Manager> {
  /** Input field. */
  Input<String> _fileName;
  /**
   * 
   * @param receiver
   */
  public DoOpen(Manager receiver) {
    super(Label.OPEN, receiver);
    _fileName = _form.addStringInput(Message.openFile());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    _form.parse();
    try {
      _receiver.loadInterpreter(_fileName.value());
    }
    catch (FileNotFoundException  e) { _display.popup(Message.fileNotFound()); }
    catch (IOException            e) { e.printStackTrace(); }
  }
  
}
