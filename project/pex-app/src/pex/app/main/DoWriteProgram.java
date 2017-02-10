/** @version $Id: DoWriteProgram.java,v 1.1 2016/10/14 18:12:43 david Exp $ */
package pex.app.main;

import java.io.FileNotFoundException;

import pex.Manager;
import pex.app.RenderVisitor;
import pex.operators.Program;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

/**
 * Write (save) program to file.
 */
public class DoWriteProgram extends Command<Manager> {
  /** Input field. */
  Input<String> _programName;
  /** Input field. */
  Input<String> _filename;

  /**
   * @param receiver
   */
  public DoWriteProgram(Manager receiver) {
    super(Label.WRITE_PROGRAM, receiver);
    _programName = _form.addStringInput(Message.requestProgramId());
    _filename = _form.addStringInput(Message.programFileName());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute(){
    _form.parse();
    Program programToWrite = _receiver.getProgram(_programName.value());

    try {
      if (programToWrite == null){
          _display.popup(Message.noSuchProgram(_programName.value()));
      }
      else {
        RenderVisitor render = new RenderVisitor();
        String toWrite = "" + programToWrite.accept(render);
        _receiver.writeProgram(toWrite, _filename.value()); 
      }
    }
    catch(FileNotFoundException e) {e.printStackTrace(); }
  }

}
