package pex.app;

import pex.Visitor;
import pex.Expression;
import pex.atomic.*;
import pex.operators.*;

/**
 * Visitor for rendering.
 *
 * @see pex.Visitor
 */
public class RenderVisitor implements Visitor{

	/**
	 * Visits And operator.
   	 *
	 * @param operator.
	 * @return the string representation of And.
	 */
	@Override
	public StringLiteral visitAnd(And operator){
		return new StringLiteral("(and " + operator.first().accept(this) + " " + operator.second().accept(this) + ")");
	}

	/**
	 * Visits Or operator.
   	 *
	 * @param operator
	 * @return the string representation of Or.
	 */
	@Override
	public StringLiteral visitOr(Or operator){
		return new StringLiteral("(or " + operator.first().accept(this) + " " + operator.second().accept(this) + ")");
	}

	/**
	 * Visits Not operator.
   	 *
	 * @param operator
	 * @return the string representation of Not. 	 
	 */
	@Override	
	public StringLiteral visitNot(Not operator){
		return new StringLiteral("(not " + operator.argument().accept(this) + ")");	
	}

	/**
	 * Visits Lt operator.
   	 *
	 * @param operator
	 * @return the string representation of Lt. 	 
	 */
	@Override	
	public StringLiteral visitLt(Lt operator){
		return new StringLiteral("(lt " + operator.first().accept(this) + " " + operator.second().accept(this) + ")");
	}

	/**
	 * Visits Le operator.
   	 *
	 * @param operator
	 * @return the string representation of Le. 	 
	 */
	@Override	
	public StringLiteral visitLe(Le operator){
		return new StringLiteral("(le " + operator.first().accept(this) + " " + operator.second().accept(this) + ")");
	}

	/**
	 * Visits Eq operator.
   	 *
	 * @param operator
	 * @return the string representation of Eq. 	 
	 */
	@Override	
	public StringLiteral visitEq(Eq operator){
		return new StringLiteral("(eq " + operator.first().accept(this) + " " + operator.second().accept(this) + ")");
	}

	/**
	 * Visits Ge operator.
   	 *
	 * @param operator
	 * @return the string representation of Ge. 	 
	 */
	@Override	
	public StringLiteral visitGe(Ge operator){
		return new StringLiteral("(ge " + operator.first().accept(this) + " " + operator.second().accept(this) + ")");
	}

	/**
	 * Visits Gt operator.
   	 *
	 * @param operator
	 * @return the string representation of Gt. 	 
	 */
	@Override	
	public StringLiteral visitGt(Gt operator){
		return new StringLiteral("(gt " + operator.first().accept(this) + " " + operator.second().accept(this) + ")");
	}

	/**
	 * Visits Ne operator.
   	 *
	 * @param operator
	 * @return the string representation of Ne. 	 
	 */
	@Override	
	public StringLiteral visitNe(Ne operator){
		return new StringLiteral("(ne " + operator.first().accept(this) + " " + operator.second().accept(this) + ")");
	}

	/**
	 * Visits Add operator.
   	 *
	 * @param operator
	 * @return the string representation of Add.
	 */
	@Override	
	public StringLiteral visitAdd(Add operator){
		return new StringLiteral("(add " + operator.first().accept(this) + " " + operator.second().accept(this) + ")");
	}

	/**
	 * Visits Sub operator.
   	 *
	 * @param operator
	 * @return the string representation of Sub.	 
	 */
	@Override	
	public StringLiteral visitSub(Sub operator){
		return new StringLiteral("(sub " + operator.first().accept(this) + " " + operator.second().accept(this) + ")");
	}

	/**
	 * Visits Mul operator.
   	 *
	 * @param operator
	 * @return the string representation of Mul.	 
	 */
	@Override
	public StringLiteral visitMul(Mul operator){
		return new StringLiteral("(mul " + operator.first().accept(this) + " " + operator.second().accept(this) + ")");
	}

	/**
	 * Visits Div operator.
   	 *
	 * @param operator
	 * @return the string representation of Div.	 
	 */
	@Override
	public StringLiteral visitDiv(Div operator){
		return new StringLiteral("(div " + operator.first().accept(this) + " " + operator.second().accept(this) + ")");
	}

	/**
	 * Visits Mod operator.
   	 *
	 * @param operator
	 * @return the string representation of Mod.	 
	 */
	@Override
	public StringLiteral visitMod(Mod operator){
		return new StringLiteral("(mod " + operator.first().accept(this) + " " + operator.second().accept(this) + ")");
	}

	/**
	 * Visits If operator.
   	 *
	 * @param operator
	 * @return the string representation of If.	 
	 */
	@Override
	public StringLiteral visitIf(If operator){
		return new StringLiteral("(if " + operator.first().accept(this) + " " + operator.second().accept(this) + " " + operator.third().accept(this) + ")");
	}

	/**
	 * Visits While operator.
   	 *
	 * @param operator
	 * @return the string representation of While.	 
	 */
	@Override
	public StringLiteral visitWhile(While operator){
		return new StringLiteral("(while " + operator.first().accept(this) + " " + operator.second().accept(this) + ")");
	}

	/**
	 * Visits Set operator.
   	 *
	 * @param operator
	 * @return the string representation of Set.	 
	 */
	@Override	
	public StringLiteral visitSet(Set operator){
		return new StringLiteral("(set " + operator.first().accept(this) + " " + operator.second().accept(this) + ")");
	}

	/**
	 * Visits Neg operator.
   	 *
	 * @param operator
	 * @return the string representation of Neg.	 
	 */
	@Override	
	public StringLiteral visitNeg(Neg operator){
		return new StringLiteral("(neg " + operator.argument().accept(this) + ")");	
	}

	/**
	 * Visits Readi operator.
   	 *
	 * @param operator
	 * @return the string representation of Readi.	 
	 */
	@Override	
	public StringLiteral visitReadi(Readi operator){
		return new StringLiteral("(readi)");
	}

	/**
	 * Visits Reads operator.
   	 *
	 * @param operator
	 * @return the string representation of Reads.	 
	 */
	@Override	
	public StringLiteral visitReads(Reads operator){
		return new StringLiteral("(reads)");
	}

	/**
	 * Visits Call operator.
   	 *
	 * @param operator
	 * @return the string representation of Call.	 
	 */
	@Override	
	public StringLiteral visitCall(Call operator){
		return new StringLiteral("(call " + operator.argument().accept(this) + ")");
	}

	/**
	 * Visits Identifier.
   	 *
	 * @param operator
	 * @return the string representation of Identifier.	 
	 */
	@Override
	public StringLiteral visitIdentifier(Identifier operator){
		return new StringLiteral(operator.getName());
	}

	/**
	 * Visits IntegerLiteral.
   	 *
	 * @param operator
	 * @return the string representation of IntegerLiteral.	 
	 */
	@Override	
	public StringLiteral visitIntegerLiteral(IntegerLiteral operator){
		return new StringLiteral(operator.toString());
	}

	/**
	 * Visits StringLiteral.
   	 *
	 * @param operator
	 * @return the string representation of StringLiteral.	 
	 */
	@Override
	public StringLiteral visitStringLiteral(StringLiteral operator){
		return new StringLiteral("\"" + operator.toString() + "\"");
	}

	/**
	 * Visits Print operator.
   	 *
	 * @param operator
	 * @return the string representation of Print.	 
	 */
	@Override
	public StringLiteral visitPrint(Print operator){
	    String rendered = "(print";
	    for(Expression e: operator.getAll()){
	      rendered += " " + e.accept(this);
	    }
	    return new StringLiteral(rendered + ")");
	}

	/**
	 * Visits Sequence operator.
   	 *
	 * @param operator
	 * @return the string representation of Sequence.	 
	 */
	@Override
	public StringLiteral visitSequence(Sequence operator){
	    String rendered = "(seq";
	    for(Expression e: operator.getAll()){
	      rendered += " " + e.accept(this);
	    }
	    return new StringLiteral(rendered + ")");
	}	

	/**
	 * Visits Sequence operator.
   	 *
	 * @param operator
	 * @return the string representation of Program.	 
	 */
	@Override
	public StringLiteral visitProgram(Program operator){
	    String rendered = "";
	    for(Expression e: operator.getAll()){
	      rendered += "" + e.accept(this) + "\n";
	    }
	    return new StringLiteral(rendered);
	}
}