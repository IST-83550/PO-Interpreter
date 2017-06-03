package pex.app;

import pt.tecnico.po.ui.Display;
import pt.tecnico.po.ui.Form;
import pt.tecnico.po.ui.Input;

import pex.Visitor;
import pex.Interpreter;
import pex.ParserException;
import pex.Expression;
import pex.Value;
import pex.atomic.*;
import pex.operators.*;

/**
 * Visitor for evaluating.
 *
 * @see pex.Visitor
 */
public class EvaluatorVisitor implements Visitor{

	/** Form (interaction) */
	private Form _form = new Form();

	/** Input Integer */
	private Input<Integer> _inputInteger;

	/** Input String */
	private Input<String> _inputString;	

    	/** Current Interpreter. */
	private Interpreter _interpreter;

    	/** Render (toString) Visitor. */
	private RenderVisitor _render = new RenderVisitor();

    	/**
   	* Constructor.
    	*
    	* @param interpreter
    	*/
	public EvaluatorVisitor(Interpreter interpreter){
		_interpreter = interpreter;
	}

	/**
	 * Visits And operator.
   	 *
	 * @param operator
	 * @return the evaluation of And.
	 */
	@Override
	public IntegerLiteral visitAnd(And operator){
		int op1 = 0, op2 = 0, res = 0;
		try {
			op1 = (int) operator.first().accept(this).getValue();
			if(op1 != 0){
				op2 = (int) operator.second().accept(this).getValue();

				if(op2 != 0)
					res = 1;
			}
		}
		catch(ClassCastException e){
			String error = "" + operator.accept(_render);
			throw new RuntimeException(error);	
		}
		return new IntegerLiteral(res);
	}

	/**
	 * Visits Or operator.
   	 *
	 * @param operator
	 * @return the evaluation of Or.
	 */
	@Override
	public IntegerLiteral visitOr(Or operator){
		int op1 = 0, op2 = 0, res = 1;
		try {
			op1 = (int) operator.first().accept(this).getValue();
			if(op1 == 0){
				op2 = (int) operator.second().accept(this).getValue();

				if(op2 == 0)
					res = 0;
			}
		}
		catch(ClassCastException e){
			String error = "" + operator.accept(_render);
			throw new RuntimeException(error);	
		}
		return new IntegerLiteral(res);
	}

	/**
	 * Visits Not operator.
   	 *
	 * @param operator
	 * @return the evaluation of Not.
	 */
	@Override
	public IntegerLiteral visitNot(Not operator){
		int op = 0;
		try {
			op = (int) operator.argument().accept(this).getValue();
		}
		catch(ClassCastException e){
			String error = "" + operator.accept(_render);
			throw new RuntimeException(error);
		}
		if(op == 0)
			return new IntegerLiteral(1);
		else
			return new IntegerLiteral(0);
	}

	/**
	 * Visits Neg operator.
   	 *
	 * @param operator
	 * @return the evaluation of Neg.
	 */
	@Override
	public IntegerLiteral visitNeg(Neg operator){
		int op = 0;
		try {
			op = (int) operator.argument().accept(this).getValue();
		}
		catch(ClassCastException e){
			String error = "" + operator.accept(_render);
			throw new RuntimeException(error);
		}
		return new IntegerLiteral(-op);
	}	

	/**
	 * Visits Lt operator.
   	 *
	 * @param operator
	 * @return the evaluation of Lt.
	 */
	@Override
	public IntegerLiteral visitLt(Lt operator){
		int op1 = 0, op2 = 0;
		try {
			op1 = (int) operator.first().accept(this).getValue();
			op2 = (int) operator.second().accept(this).getValue();
		}
		catch(ClassCastException e){
			String error = "" + operator.accept(_render);
			throw new RuntimeException(error);
		}
		if(op1 < op2)
			return new IntegerLiteral(1);
		else
			return new IntegerLiteral(0);
	}

	/**
	 * Visits Le operator.
   	 *
	 * @param operator
	 * @return the evaluation of Le.
	 */
	@Override
	public IntegerLiteral visitLe(Le operator){
		int op1 = 0, op2 = 0;
		try {
			op1 = (int) operator.first().accept(this).getValue();
			op2 = (int) operator.second().accept(this).getValue();
		}
		catch(ClassCastException e){
			String error = "" + operator.accept(_render);
			throw new RuntimeException(error);
		}
		if(op1 <= op2)
			return new IntegerLiteral(1);
		else
			return new IntegerLiteral(0);
	}

	/**
	 * Visits Ge operator.
   	 *
	 * @param operator
	 * @return the evaluation of Ge.
	 */
	@Override	
	public IntegerLiteral visitGe(Ge operator){
		int op1 = 0, op2 = 0;
		try {
			op1 = (int) operator.first().accept(this).getValue();
			op2 = (int) operator.second().accept(this).getValue();
		}
		catch(ClassCastException e){
			String error = "" + operator.accept(_render);
			throw new RuntimeException(error);	
		}
		if(op1 >= op2)
			return new IntegerLiteral(1);
		else
			return new IntegerLiteral(0);
	}

	/**
	 * Visits Gt operator.
   	 *
	 * @param operator
	 * @return the evaluation of Gt.
	 */
	@Override	
	public IntegerLiteral visitGt(Gt operator){
		int op1 = 0, op2 = 0;
		try {
			op1 = (int) operator.first().accept(this).getValue();
			op2 = (int) operator.second().accept(this).getValue();
		}
		catch(ClassCastException e){
			String error = "" + operator.accept(_render);
			throw new RuntimeException(error);
		}
		if(op1 > op2)
			return new IntegerLiteral(1);
		else
			return new IntegerLiteral(0);
	}

	/**
	 * Visits Eq operator.
   	 *
	 * @param operator
	 * @return the evaluation of Eq.	 
	 */
	@Override	
	public IntegerLiteral visitEq(Eq operator){
		int op1 = 0, op2 = 0;
		try {
			op1 = (int) operator.first().accept(this).getValue();
			op2 = (int) operator.second().accept(this).getValue();
		}
		catch(ClassCastException e){
			String error = "" + operator.accept(_render);
			throw new RuntimeException(error);	
		}
		if(op1 == op2)
			return new IntegerLiteral(1);
		else
			return new IntegerLiteral(0);
	}	

	/**
	 * Visits Ne operator.
   	 *
	 * @param operator
	 * @return the evaluation of Ne.	 
	 */
	@Override	
	public IntegerLiteral visitNe(Ne operator){
		int op1 = 0, op2 = 0;
		try {
			op1 = (int) operator.first().accept(this).getValue();
			op2 = (int) operator.second().accept(this).getValue();
		}
		catch(ClassCastException e){
			String error = "" + operator.accept(_render);
			throw new RuntimeException(error);	
		}
		if(op1 != op2)
			return new IntegerLiteral(1);
		else
			return new IntegerLiteral(0);
	}

	/**
	 * Visits Add operator.
   	 *
	 * @param operator
	 * @return the evaluation of Add.
	 */
	@Override
	public IntegerLiteral visitAdd(Add operator){
		int op1 = 0, op2 = 0;
		try {
			op1 = (int) operator.first().accept(this).getValue();
			op2 = (int) operator.second().accept(this).getValue();
		}
		catch(ClassCastException e){
			String error = "" + operator.accept(_render);
			throw new RuntimeException(error);
		}
		return new IntegerLiteral(op1 + op2);
	}

	/**
	 * Visits Sub operator.
   	 *
	 * @param operator
	 * @return the evaluation of Sub.
	 */
	@Override
	public IntegerLiteral visitSub(Sub operator){
		int op1 = 0, op2 = 0;
		try {
			op1 = (int) operator.first().accept(this).getValue();
			op2 = (int) operator.second().accept(this).getValue();
		}
		catch(ClassCastException e){
			String error = "" + operator.accept(_render);
			throw new RuntimeException(error);
		}
		return new IntegerLiteral(op1 - op2);
	}

	/**
	 * Visits Mul operator.
   	 *
	 * @param operator
	 * @return the evaluation of Mul.	 
	 */
	@Override
	public IntegerLiteral visitMul(Mul operator){
		int op1 = 0, op2 = 0;
		try {
			op1 = (int) operator.first().accept(this).getValue();
			op2 = (int) operator.second().accept(this).getValue();
		}
		catch(ClassCastException e){
			String error = "" + operator.accept(_render);
			throw new RuntimeException(error);
		}
		return new IntegerLiteral(op1 * op2);
	}

	/**
	 * Visits Div operator.
   	 *
	 * @param operator
	 * @return the evaluation of Div.
	 */
	@Override
	public IntegerLiteral visitDiv(Div operator){
		int op1 = 0, op2 = 0;
		try {
			op1 = (int) operator.first().accept(this).getValue();
			op2 = (int) operator.second().accept(this).getValue();
		}
		catch(ClassCastException e){
			String error = "" + operator.accept(_render);
			throw new RuntimeException(error);
		}
		return new IntegerLiteral(op1 / op2);
	}

	/**
	 * Visits Mod operator.
   	 *
	 * @param operator
	 * @return the evaluation of Mod.
	 */
	@Override
	public IntegerLiteral visitMod(Mod operator){
		int op1 = 0, op2 = 0;
		try {
			op1 = (int) operator.first().accept(this).getValue();
			op2 = (int) operator.second().accept(this).getValue();
		}
		catch(ClassCastException e){
			String error = "" + operator.accept(_render);
			throw new RuntimeException(error);
		}
		return new IntegerLiteral(op1 % op2);
	}

	/**
	 * Visits If operator.
   	 *
	 * @param operator
	 * @return the evaluation of If.
	 */
	@Override
	public Value visitIf(If operator){
		int cond = 0;
		try {
			cond = (int) operator.first().accept(this).getValue();
		}
		catch(ClassCastException e){
			String error = "" + operator.accept(_render);
			throw new RuntimeException(error);
		}
		Value v;
		if(cond != 0)
			v = operator.second().accept(this);
		else
			v = operator.third().accept(this);
		return v;
	}

	/**
	 * Visits While operator.
   	 *
	 * @param operator
	 * @return the evaluation of While.
	 */
	@Override
	public Value visitWhile(While operator){
		Value v;
		try {
			while((int)operator.first().accept(this).getValue() != 0)
				v = operator.second().accept(this);
		}
		catch(ClassCastException e){
			String error = "" + operator.accept(_render);
			throw new RuntimeException(error);
		}
		return new IntegerLiteral(0);
	}

	/**
	 * Visits Set operator.
   	 *
	 * @param operator
	 * @return the evaluation of Set.
	 */
	@Override
	public Value visitSet(Set operator){
		Identifier id;
		try {
        	id = (Identifier) operator.first();
    	}
    	catch(ClassCastException e){
    		String description = operator.first().toString();
        	throw new RuntimeException(description + " não é um identificador");    		
    	}
		String name = id.getName();
		Value value = operator.second().accept(this);
        _interpreter.putIdentifier(name, value);
		return value;
	}

	/**
	 * Visits Readi operator.
   	 *
	 * @param operator
	 * @return the evaluation of Readi.
	 */
	@Override
	public IntegerLiteral visitReadi(Readi operator){
		_form.clear();
		_inputInteger = _form.addIntegerInput("");
		_form.parse();
		return new IntegerLiteral(_inputInteger.value());
	}

	/**
	 * Visits Reads operator.
   	 *
	 * @param operator
	 * @return the evaluation of Reads.
	 */
	@Override
	public StringLiteral visitReads(Reads operator){
		_form.clear();
		_inputString = _form.addStringInput("");
		_form.parse();
		return new StringLiteral(_inputString.value());
	}

	/**
	 * Visits Call operator.
   	 *
	 * @param operator
	 * @return the evaluation of Call.
	 */
	@Override
	public Value visitCall(Call operator){
        String description = operator.argument().toString();
        Program program = _interpreter.getProgram(description);
        if (program == null){
        	try {
        		program = _interpreter.parseProgram(description);
        	}
        	catch (ParserException e){
	        	throw new RuntimeException("(call " +
	        		description + "). Programa inexistente.");
	        }
        }
        return program.accept(new EvaluatorVisitor(_interpreter));
	}

	/**
	 * Visits Identifier.
   	 *
	 * @param operator
	 * @return the evaluation of Identifier.
	 */
	@Override
	public Value visitIdentifier(Identifier operator){
		Value value = _interpreter.getIdentifier(operator.getName());
		if(value == null)
			return new IntegerLiteral(0);
        return value;
	}

	/**
	 * Visits IntegerLiteral.
   	 *
	 * @param operator
	 * @return the evaluation of IntegerLiteral. 
	 */
	@Override
	public IntegerLiteral visitIntegerLiteral(IntegerLiteral operator){
		return new IntegerLiteral(operator.getValue());
	}

	/**
	 * Visits StringLiteral.
   	 *
	 * @param operator
	 * @return the evaluation of StringLiteral.
	 */
	@Override
	public StringLiteral visitStringLiteral(StringLiteral operator){
		return new StringLiteral(operator.getValue());
	}

	/**
	 * Visits Sequence operator.
   	 *
	 * @param operator
	 * @return the evaluation of Sequence.
	 */
	@Override
	public Value visitSequence(Sequence operator){
		/* Empty sequence is evaluated with zero */
		Value value = new IntegerLiteral(0);
	    for(Expression e: operator.getAll()){
	      	value = e.accept(this);
	    }        
	    return value;
	}

	/**
	 * Visits Print operator.
   	 *
	 * @param operator
	 * @return the evaluation of Print.
	 */
	@Override
	public Value visitPrint(Print operator){
		/* Empty print is evaluated with zero */
        Value value = new IntegerLiteral(0);
		Display display = new Display();
	    for(Expression e: operator.getAll()){
	     	value = e.accept(this);
	     	display.add(value.toString());
	    }
        display.display();
	    return value;
	}

	/**
	 * Visits Program operator.
   	 *
	 * @param operator
	 * @return the evaluation of Program.
	 */
	@Override
	public Value visitProgram(Program operator){
		/* Empty program is evaluated with zero */
		Value value = new IntegerLiteral(0);
	    for(Expression e: operator.getAll()){
	     	value = e.accept(this);
	    }
	    return value;
	}
	
}
