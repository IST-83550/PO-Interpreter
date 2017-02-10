/** @version $Id: DoSave.java,v 1.1 2016/10/14 18:12:43 david Exp $ */
package pex.app.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import pex.Manager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

/**
 * Save to file under current name (if unnamed, query for name).
 */
public class DoSave extends Command<Manager> {
  /** Input field. */
  Input<String> _filename;
  
  /**
   * @param receiver
   */
  public DoSave(Manager receiver) {
    super(Label.SAVE, receiver);
    _filename = _form.addStringInput(Message.newSaveAs());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    try {
      if(_receiver.hasChanges()) {
        String fileName;
            
        if ((fileName = _receiver.getFileName()).equals("")) {
          _form.parse();
          fileName = _filename.value();
          _receiver.setFileName(fileName);
        }
        _receiver.saveInterpreter();
      }
    }
    catch (FileNotFoundException  e) { _display.popup(Message.fileNotFound()); }
    catch (IOException            e) { e.printStackTrace(); }
  }
  
}
