/* $Id: Program.java,v 1.1 2016/10/14 18:12:45 david Exp $ */
package pex.operators;

import java.util.List;
import java.util.ArrayList;
import pex.Expression;
import java.io.Serializable;
import pex.Visitor;
import pex.Value;

/**
 * Class for describing programs.
 */
public class Program extends Sequence implements Serializable{

 	/** Serial number for serialization. */
	private static final long serialVersionUID = 201611171744L;

  /** Program ID. */
	private String _programId;

  /**
   * Constructor.
   *
   * @param String
   *     Program ID.
   */
  public Program(String programId){
  	_programId = programId;
  }

  /**
   * @return _programId
   *     Program ID.
   */
	public String getProgramId(){
		return _programId;
	}

  /**
   * @param String
   *     New Program ID.
   */
  public void setProgramId(String newProgramId){
    _programId = newProgramId;
  }

  /**
   * @param visitor
   *     The visitor.
   * @return The visitor's type representation of the Program.
   */
  @Override
  public Value accept(Visitor visitor){
    return visitor.visitProgram(this);
  }
}
