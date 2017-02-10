/** @version $Id: DoReplaceExpression.java,v 1.1 2016/10/14 18:12:43 david Exp $ */
package pex.app.evaluator;

import pex.Interpreter;
import pex.Expression;
import pex.ParserException;
import pex.app.BadExpressionException;
import pex.app.BadPositionException;
import pex.operators.Program;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;

/**
 * Replace expression in program.
 */
public class DoReplaceExpression extends ProgramCommand {
  /** Input field. */
  Input<Integer> _position;

  /** Input field. */
  Input<String> _description;

  /**
   * @param interpreter
   * @param receiver
   */
  public DoReplaceExpression(Interpreter interpreter, Program receiver) {
    super(Label.REPLACE_EXPRESSION, interpreter, receiver);
    _position = _form.addIntegerInput(Message.requestPosition());
    _description = _form.addStringInput(Message.requestExpression());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    _form.parse();
    try {
      Expression expression = _interpreter.parseString(_description.value());
      _receiver.set(_position.value(), expression);
    }
    catch(ParserException e){ 
      throw new BadExpressionException(_description.value());
    }
    catch(IndexOutOfBoundsException e){
      throw new BadPositionException(_position.value());
    }
  }
  
}
