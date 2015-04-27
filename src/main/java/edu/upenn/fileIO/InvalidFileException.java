package edu.upenn.fileIO;

@SuppressWarnings("serial")
public class InvalidFileException extends Exception {
	@Override
	public String getMessage() {
		return "Something went wrong, with the input file data";
	}

}
