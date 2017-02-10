package pex;

import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import java.io.IOException; 
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.PrintStream;

import pex.operators.Program;

/**
 * Manager Core Class.
 */
public class Manager {

 	/** Current Interpreter. */
	private Interpreter _interpreter = new Interpreter();

	/** The current interpreter file name. */
	private String _fileName = "";

	/**
	 * Creates a new Interpreter
	 */
	public void newInterpreter(){
		_interpreter = new Interpreter();
		_fileName = "";		
		changed();
	}

	/**
	 * Returns current Interpreter
	 *
     * @return _interpreter
     */
	public Interpreter getInterpreter(){
		return _interpreter;
	}

	/**
	 * Sets current Interpreter
	 *
     * @param interpreter
     */
	public void setInterpreter(Interpreter interpreter){
		_interpreter = interpreter;
	}

	/**
	 * Search and return a program in the current interpreter.
	 *	
	 * @param program
	 * @return program
	 */
	public Program getProgram(String program){
		return _interpreter.getProgram(program);
	}	

	/**	
	 * Adds new program to current interpreter.
	 *
	 * @param program
	 */
	public void addNewProgram(String programId){
		_interpreter.addNewProgram(programId);
		changed();
	}

	/**
	 * Parses program file with interpreter.
	 *
	 * @param programId
     * @throws ParserException
     * @return program 
	 */
	public Program parseProgram(String programId) throws ParserException{
		return _interpreter.parseProgram(programId);
	}

	/**
	 * Reads program file.
	 *
	 * @param programId
     * @throws ParserException
	 */
	public void readProgram(String programId) throws ParserException{
		_interpreter.addProgram(parseProgram(programId));
	}

	/**
	 * Reads Imported program file.
	 *
	 * @param programId
     * @throws ParserException
	 */
	public void readImportProgram(String file) throws ParserException{
		Program program = parseProgram(file);
		program.setProgramId("import");
		_interpreter.addProgram(program);
	}

	/**
	 * Writes program to a file.
	 *
	 * @param program
	 * @param fileName
	 * @throws FileNotFoundException
	 */
	public void writeProgram(String program, String fileName) throws FileNotFoundException{
			PrintStream out = new PrintStream(new FileOutputStream(fileName));
		    out.print(program);
	}

	/**
	 * Loads interpreter from a file.
	 *	
	 * @param file
     * @throws IOException
     * @throws ClassNotFoundException
	 */
	public void loadInterpreter(String file) throws IOException, FileNotFoundException{
      ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
		try {
			Interpreter interpreter = (Interpreter)ois.readObject();
			if(interpreter == null) {
				throw new FileNotFoundException();
			} else {
				setInterpreter(interpreter);
				setFileName(file);
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
      ois.close();
	}

	/**
	 * Saves interpreter to a file.
	 *
     * @throws IOException
	 */
	public void saveInterpreter() throws IOException{
      ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(_fileName)));
      oos.writeObject(_interpreter);
      oos.close();
      saved();
	}

	/**
	 * @return true, if current interpreter was changed; false, otherwise.
	 */
	public boolean hasChanges() {
		return _interpreter.hasChanges();
	}

	/**
	 * Sets the current interpreter status to changed.
	 */
	public void changed() {
		_interpreter.changed();
	}

	/**
	 * Sets the current interpreter status to saved.
	 */
	public void saved() {
		_interpreter.saved();
	}

	/**
	 * @return The current interpreter file name.
	 */
	public String getFileName() {
		return _fileName;
	}

	/**
	 * @param fileName
	 *     The current interpreter new file name.
	 */
	public void setFileName(String fileName) {
		_fileName = fileName;
	}	
}