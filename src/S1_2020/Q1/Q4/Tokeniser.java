package S1_2020.Q1.Q4;

import Q4.Token;

/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 *
 * Implement next() method in Tokeniser.java to extract the SQL commands as Tokens as follows:
 *
 * Token 1:
 * originalTokenStr: INSERT INTO table_name (column1, column2, column3, ...)
 * type: INSERT_INTO
 * value: table_name (column1, column2, column3, ...)
 *
 * Token 2:
 * originalTokenStr: VALUES (value1, value2, value3, ...)
 * type: VALUES
 * value: (value1, value2, value3, ...)
 *
 * Some brackets in the SQL commands may be missing. Please return null if some brackets are missing
 *
 * Please see test cases in TokeniserTest.java.
 */
public class Tokeniser {
	private String _buffer;

	public Tokeniser(String buffer) {
		this._buffer = buffer;
		int idx = this._buffer.indexOf(";");
		if (idx > 0) {
			this._buffer = this._buffer.substring(0, idx);
		}
	}

	/**
	 * Return the next token without changing the buffer
	 *
	 * @return the next token OR null when there is no more token or the next token
	 *         is invalid.
	 */
	public Q4.Token next() {
		if (_buffer.isEmpty())
			return null;

		// TODO: Complete this method
		// START YOUR CODE
		char firstChar = _buffer.charAt(0);
		if (firstChar == 'I'){
			if (_buffer.substring(0, 11).equals("INSERT INTO")){
				StringBuilder stringBuilder =  new StringBuilder();
				int pos = 12 ;
				//current char (digit) , pointer
				char current = _buffer.charAt(pos);
				while(current!='V'){
					stringBuilder.append(current);
					pos++;
					// if else to handle the out of range bug
					//make sure the current pointer is not out of bounds
					if(pos<_buffer.length()){
						current = _buffer.charAt(pos);
					} else {
						break;
					}
				}
				System.out.println(stringBuilder.toString());
				stringBuilder.setLength(stringBuilder.length()-1);
				return new Q4.Token(Q4.Token.Type.INSERT_INTO,stringBuilder.toString(),"INSERT INTO "+stringBuilder.toString());
			}
		}

		if (firstChar == 'V'){
			if (_buffer.substring(0, 6 ).equals("VALUES")){

				return new Q4.Token(Q4.Token.Type.VALUES,_buffer.substring(7,_buffer.length()),_buffer);
			}
		}




		// You are allowed to remove the following 'return null' if necessary
		return null;

		// END YOUR CODE
	}

	/**
	 * Return the next token and remove it from the buffer
	 *
	 * @return the next token OR null when there is no more token or the next token
	 *         is invalid.
	 */
	public Q4.Token takeNext() {
		Token nextToken = next();
		if (nextToken == null)
			return null;

		//im so smart lol
		if (nextToken.value.indexOf(')')==-1){
			return null;
		}
		if (nextToken.value.indexOf('(')==-1){
			return null;
		}

		if (nextToken.originalTokenStr.length() < _buffer.length()) {
			_buffer = _buffer.substring(nextToken.originalTokenStr.length()).trim();
		} else {
			_buffer = "";
		}

		return nextToken;
	}

	/**
	 * @return whether there is another token to parse in the buffer
	 */
	public boolean hasNext() {
		return next() != null;
	}
}