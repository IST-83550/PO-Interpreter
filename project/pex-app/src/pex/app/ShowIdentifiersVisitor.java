package pex.app;

import java.util.Map;
import java.util.TreeMap;

import pex.Visitor;
import pex.Expression;
import pex.Value;
import pex.atomic.*;
import pex.operators.*;

/**
 * Visitor for Identifiers.
 * (used by DoShowUnitializedIdentifiers and DoShowAllIdentifiers)
 *
 * @see pex.Visitor
 */
public class ShowIdentifiersVisitor implements Visitor {

	/** Program Identifiers
	 *
	 * Unititalized identifiers are stored with 0.	 
	 * Initialized identifiers are stored with 1.
	 *
	 */
	private Map<String, Integer> _identifiers = new TreeMap<String, Integer>();

	/**
	 *
	 * Returns a string of all identifiers sorted by name.
   	 *
   	 * @return render
   	 *		rendered string of all identifiers.
	 */
	public String printAllIdentifiers(){
		String render = "";
		for (Map.Entry<String, Integer> entry : _identifiers.entrySet()){
			render += entry.getKey() + "\n";
    	}
    	return render;
	}

	/**
	 *
	 * Returns a string of all unitialized identifiers sorted by name.
   	 *
   	 * @return render
   	 *		rendered string of all unitialized identifiers.
	 */
	public String printUnitializedIdentifiers(){
		String render = "";
		for (Map.Entry<String, Integer> entry : _identifiers.entrySet()){
			if(entry.getValue() == 0){
				render += entry.getKey() + "\n";
			}
		}
		return render;
	}

	/**
	 * Visits Set operator.
   	 *
	 * @param operator
	 * @return null.
	 */
	@Override
	public Value visitSet(Set operator){
        Identifier id = (Identifier) operator.first();
		_identifiers.put(id.getName(), 1);
		operator.second().accept(this);
		return null;
	}

	/**
	 * Visits Identifier.
   	 *
	 * @param operator
	 * @return null.
	 */
	@Override
	public Value visitIdentifier(Identifier operator){
		String name = operator.getName();
		if(_identifiers.get(name) == null)
			_identifiers.put(name, 0);
        return null;
	}	

	/**
	 * Visits And operator.
   	 *
	 * @param operator
	 * @return null.
	 */
	@Override
	public IntegerLiteral visitAnd(And operator){
		operator.first().accept(this);
		operator.second().accept(this);
		return null;
	}

	/**
	 * Visits Or operator.
   	 *
	 * @param operator
	 * @return null.	 
	 */
	@Override
	public IntegerLiteral visitOr(Or operator){
		operator.first().accept(this);
		operator.second().accept(this);
		return null;
	}

	/**
	 * Visits Not operator.
   	 *
	 * @param operator
	 * @return null.
	 */
	@Override
	public IntegerLiteral visitNot(Not operator){
		operator.argument().accept(this);
		return null;
	}

	/**
	 * Visits Neg operator.
   	 *
	 * @param operator
	 * @return null.
	 */
	@Override
	public IntegerLiteral visitNeg(Neg operator){
		operator.argument().accept(this);
		return null;
	}	

	/**
	 * Visits Lt operator.
   	 *
	 * @param operator
	 * @return null.
	 */
	@Override
	public IntegerLiteral visitLt(Lt operator){
		operator.first().accept(this);
		operator.second().accept(this);
		return null;
	}

	/**
	 * Visits Le operator.
   	 *
	 * @param operator
	 * @return null.
	 */
	@Override
	public IntegerLiteral visitLe(Le operator){
		operator.first().accept(this);
		operator.second().accept(this);
		return null;
	}

	/**
	 * Visits Ge operator.
   	 *
	 * @param operator
	 * @return null.
	 */
	@Override	
	public IntegerLiteral visitGe(Ge operator){
		operator.first().accept(this);
		operator.second().accept(this);
		return null;
	}

	/**
	 * Visits Gt operator.
   	 *
	 * @param operator
	 * @return null.
	 */
	@Override
	public IntegerLiteral visitGt(Gt operator){
		operator.first().accept(this);
		operator.second().accept(this);
		return null;
	}

	/**
	 * Visits Eq operator.
   	 *
	 * @param operator
	 * @return null.	 
	 */
	@Override	
	public IntegerLiteral visitEq(Eq operator){
		operator.first().accept(this);
		operator.second().accept(this);
		return null;
	}	

	/**
	 * Visits Ne operator.
   	 *
	 * @param operator
	 * @return null.	 
	 */
	@Override	
	public IntegerLiteral visitNe(Ne operator){
		operator.first().accept(this);
		operator.second().accept(this);
		return null;
	}

	/**
	 * Visits Add operator.
   	 *
	 * @param operator
	 * @return null.
	 */
	@Override
	public IntegerLiteral visitAdd(Add operator){
		operator.first().accept(this);
		operator.second().accept(this);
		return null;
	}

	/**
	 * Visits Sub operator.
   	 *
	 * @param operator
	 * @return null.
	 */
	@Override
	public IntegerLiteral visitSub(Sub operator){
		operator.first().accept(this);
		operator.second().accept(this);
		return null;
	}

	/**
	 * Visits Mul operator.
   	 *
	 * @param operator
	 * @return null.	 
	 */
	@Override
	public IntegerLiteral visitMul(Mul operator){
		operator.first().accept(this);
		operator.second().accept(this);
		return null;
	}

	/**
	 * Visits Div operator.
   	 *
	 * @param operator
	 * @return null.
	 */
	@Override
	public IntegerLiteral visitDiv(Div operator){
		operator.first().accept(this);
		operator.second().accept(this);
		return null;
	}

	/**
	 * Visits Mod operator.
   	 *
	 * @param operator
	 * @return null.
	 */
	@Override	
	public IntegerLiteral visitMod(Mod operator){
		operator.first().accept(this);
		operator.second().accept(this);
		return null;
	}

	/**
	 * Visits If operator.
   	 *
	 * @param operator
	 * @return null.
	 */
	@Override
	public Value visitIf(If operator){
		operator.first().accept(this);
		operator.second().accept(this);
		operator.third().accept(this);		
		return null;
	}

	/**
	 * Visits While operator.
   	 *
	 * @param operator
	 * @return null.	 
	 */
	@Override
	public Value visitWhile(While operator){
		operator.first().accept(this);
		operator.second().accept(this);
		return null;	
	}

	/**
	 * Visits Readi operator.
   	 *
	 * @param operator
	 * @return null.
	 */
	@Override
	public IntegerLiteral visitReadi(Readi operator){
		return null;	
	}

	/**
	 * Visits Reads operator.
   	 *
	 * @param operator
	 * @return null.
	 */
	@Override
	public StringLiteral visitReads(Reads operator){
		return null;
	}

	/**
	 * Visits Call operator.
   	 *
	 * @param operator
	 * @return null.
	 */
	@Override
	public Value visitCall(Call operator){
        return null;
	}

	/**
	 * Visits IntegerLiteral.
   	 *
	 * @param operator
	 * @return null. 
	 */
	@Override
	public IntegerLiteral visitIntegerLiteral(IntegerLiteral operator){
		return null;
	}

	/**
	 * Visits StringLiteral.
   	 *
	 * @param operator
	 * @return null.
	 */
	@Override
	public StringLiteral visitStringLiteral(StringLiteral operator){
		return null;
	}

	/**
	 * Visits Sequence operator.
   	 *
	 * @param operator
	 * @return null.
	 */
	@Override
	public Value visitSequence(Sequence operator){
	    for(Expression e: operator.getAll()){
	      	e.accept(this);
	    }        
	    return null;
	}

	/**
	 * Visits Print operator.
   	 *
	 * @param operator
	 * @return null.
	 */
	@Override
	public Value visitPrint(Print operator){
	    for(Expression e: operator.getAll()){
	     	e.accept(this);
	    }
	    return null;
	}

	/**
	 * Visits Program operator.
   	 *
	 * @param operator
	 * @return null.
	 */
	@Override
	public Value visitProgram(Program operator){
	    for(Expression e: operator.getAll()){
	     	e.accept(this);
	    }
	    return null;
	}
	
}