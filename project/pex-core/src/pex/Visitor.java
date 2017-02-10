package pex;

import pex.atomic.*;
import pex.operators.*;
import pex.Value;

/**
 * Visitor interface for visiting the core class elements.
 *
 */
public interface Visitor{
	/**
	 * @param operator.
	 * @return The Value representation of Identifier.
	 */
	public Value visitIdentifier(Identifier operator);

	/**
	 * @param operator.	
	 * @return The Value representation of integerliteral.
	 */
	public Value visitIntegerLiteral(IntegerLiteral operator);

	/**
	 * @param operator.	
	 * @return The Value representation of stringliteral.
	 */
	public Value visitStringLiteral(StringLiteral operator);
	
	/**
	 * @param operator.	
	 * @return The Value representation of And.
	 */
	public Value visitAnd(And operator);

	/**
	 * @param operator.	
	 * @return The Value representation of Or.
	 */
	public Value visitOr(Or operator);

	/**
	 * @param operator.	
	 * @return The Value representation of Not.
	 */
	public Value visitNot(Not operator);

	/**
	 * @param operator.	
	 * @return The Value representation of Lt.
	 */
	public Value visitLt(Lt operator);

	/**
	 * @param operator.	
	 * @return The Value representation of Le.
	 */
	public Value visitLe(Le operator);

	/**
	 * @param operator.	
	 * @return The Value representation of Eq.
	 */
	public Value visitEq(Eq operator);

	/**
	 * @param operator.	
	 * @return The Value representation of Ge.
	 */
	public Value visitGe(Ge operator);

	/**
	 * @param operator.	
	 * @return The Value representation of Gt.
	 */
	public Value visitGt(Gt operator);

	/**
	 * @param operator.	
	 * @return The Value representation of Ne.
	 */
	public Value visitNe(Ne operator);

	/**
	 * @param operator.	
	 * @return The Value representation of Add.
	 */
	public Value visitAdd(Add operator);

	/**
	 * @param operator.	
	 * @return The Value representation of Sub.
	 */
	public Value visitSub(Sub operator);

	/**
	 * @param operator.	
	 * @return The Value representation of Mul.
	 */
	public Value visitMul(Mul operator);

	/**
	 * @param operator.	
	 * @return The Value representation of Div.
	 */
	public Value visitDiv(Div operator);

	/**
	 * @param operator.	
	 * @return The Value representation of Mod.
	 */
	public Value visitMod(Mod operator);

	/**
	 * @param operator.	
	 * @return The Value representation of If.
	 */
	public Value visitIf(If operator);

	/**
	 * @param operator.	
	 * @return The Value representation of While.
	 */
	public Value visitWhile(While operator);

	/**
	 * @param operator.	
	 * @return The Value representation of Set.
	 */
	public Value visitSet(Set operator);

	/**
	 * @param operator.	
	 * @return The Value representation of Neg.
	 */
	public Value visitNeg(Neg operator);

	/**
	 * @param operator.	
	 * @return The Value representation of Readi.
	 */
	public Value visitReadi(Readi operator);

	/**
	 * @param operator.	
	 * @return The Value representation of Reads.
	 */
	public Value visitReads(Reads operator);

	/**
	 * @param operator.	
	 * @return The Value representation of Call.
	 */
	public Value visitCall(Call operator);

	/**
	 * @param operator.	
	 * @return The Value representation of Print.
	 */
	public Value visitPrint(Print operator);

	/**
	 * @param operator.	
	 * @return The Value representation of Sequence.
	 */
	public Value visitSequence(Sequence operator);

	/**
	 * @param operator.	
	 * @return The Value representation of Program.
	 */
	public Value visitProgram(Program operator);	
}