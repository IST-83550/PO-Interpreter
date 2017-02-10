package pex;

import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;

import pex.operators.Program;
import pex.Value;

public class Interpreter implements Serializable{

  	/** Serial number for serialization. */
	private static final long serialVersionUID = 201611202112L;

	/** The modification status of the interpreter. */
	/** New interpreter starts as not saved */
	private boolean _changed = true;

 	/** Parser. */
	private Parser _parser = new Parser();

  	/** Programs stored in a Map. */
	private Map<String,Program> _programs = new HashMap<String, Program>();

	/** Initialized identifiers (across all programs) */
	private Map<String, Value> _identifiers = new HashMap<String, Value>();

	/**
	 * Parses program file.
	 *
	 * @param programId
     * @throws ParserException
     * @return program 
	 */
	public Program parseProgram(String programId) throws ParserException{
		return _parser.parseProgramFile(programId);
	}

	/**
	 * Parses String (description).
	 *
	 * @param description
     * @throws ParserException
     * @return Expression
	 */
	public Expression parseString(String description) throws ParserException{
		return _parser.parse(description);
	}	

	/**
	 * @param programId
	 */
	public void addNewProgram(String programId){
		_programs.put(programId, new Program(programId));
	}

	/**
	 * @param program
	 */
	public void addProgram(Program program){
		_programs.put(program.getProgramId(), program);
	}

	/**
	 * @param program 
	 * @return program
	 */
	public Program getProgram(String program){
		return _programs.get(program);
	}

	/**
	 * @param identifier
	 * @param value
	 */
	public void putIdentifier(String identifier, Value value){
		_identifiers.put(identifier, value);
	}

	/**
	 * @param identifier
	 * @return value
	 */
	public Value getIdentifier(String identifier){
		return _identifiers.get(identifier);
	}

	/**
	 * @return true, if interpreter was changed; false, otherwise.
	 */
	public boolean hasChanges() {
		return _changed;
	}
	
	/**
	 * Sets the current interpreter status to changed.
	 */
	public void changed() {
		_changed = true;
	}

	/**
	 * Sets the current interpreter status to saved.
	 */
	public void saved() {
		_changed = false;
	}	
}