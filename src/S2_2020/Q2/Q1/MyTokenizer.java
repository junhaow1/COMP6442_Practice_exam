package S2_2020.Q2.Q1;

public class MyTokenizer implements Tokenizer {

    private String buffer;		//save text
    private Token currentToken;	//save token extracted from next()

    /**
     *  Tokenizer class constructor
     *  The constructor extracts the first token and save it to currentToken
     *  **** please do not modify this part ****
     */
    public MyTokenizer(String text) {
    	buffer = text;		// save input text (string)
    	next();		// extracts the first token.
    }

    /**
     *  This function will find and extract a next token from {@code buffer} and
     *  save the token to {@code currentToken}.
     */
    public void next() {


        buffer = buffer.trim(); // remove whitespace

         if(buffer.isEmpty()) {
            currentToken = null;	// if there's no string left, set currentToken null and return
            return;
         }

        // ########## YOUR CODE STARTS HERE ##########
        char firstChar = buffer.charAt(0);
        if (Character.isDigit(firstChar)){
            StringBuilder stringBuilder =  new StringBuilder();
            int pos = 0 ;
            //current char (digit) , pointer
            char current = buffer.charAt(pos);
            while(Character.isDigit(current)){
                stringBuilder.append(current);
                pos++;
                // if else to handle the out of range bug
                //make sure the current pointer is not out of bounds
                if(pos<buffer.length()){
                    current = buffer.charAt(pos);
                } else {
                    break;
                }
            }
            currentToken = new Token(stringBuilder.toString(), Token.Type.INTEGER_NUMBER);

        }

        if (Character.isUpperCase(firstChar)){
            StringBuilder stringBuilder =  new StringBuilder();
            int pos = 0 ;
            //current char (digit) , pointer
            char current = buffer.charAt(pos);
            while(Character.isUpperCase(current)){
                stringBuilder.append(current);
                pos++;
                // if else to handle the out of range bug
                //make sure the current pointer is not out of bounds
                if(pos<buffer.length()){
                    current = buffer.charAt(pos);
                } else {
                    break;
                }
            }
            currentToken = new Token(stringBuilder.toString(), Token.Type.UPPER_CASE_WORD);

        }

        if (Character.isLowerCase(firstChar)){
            StringBuilder stringBuilder =  new StringBuilder();
            int pos = 0 ;
            //current char (digit) , pointer
            char current = buffer.charAt(pos);
            while(Character.isLowerCase(current)){
                stringBuilder.append(current);
                pos++;
                // if else to handle the out of range bug
                //make sure the current pointer is not out of bounds
                if(pos<buffer.length()){
                    current = buffer.charAt(pos);
                } else {
                    break;
                }
            }
            currentToken = new Token(stringBuilder.toString(), Token.Type.LOWER_CASE_WORD);

        }

        if (Character.isUpperCase(firstChar)){
            StringBuilder stringBuilder =  new StringBuilder();
            int pos = 0 ;
            //current char (digit) , pointer
            char current = buffer.charAt(pos);
            boolean isCamel = false;

            while(Character.isLetter(current)){
                if (Character.isLowerCase(current)){
                    isCamel = true;
                }
                stringBuilder.append(current);
                pos++;
                // if else to handle the out of range bug
                //make sure the current pointer is not out of bounds
                if(pos<buffer.length()){
                    current = buffer.charAt(pos);
                } else {
                    break;
                }
            }
            if (isCamel){
                if (stringBuilder.toString().length()<=3){
                    currentToken = new Token(stringBuilder.toString(), Token.Type.SHORT_CAMEL_CASE_WORD);

                } else {
                    currentToken = new Token(stringBuilder.toString(), Token.Type.LONG_CAMEL_CASE_WORD);

                }
            } else {
                currentToken = new Token(stringBuilder.toString(), Token.Type.UPPER_CASE_WORD);

            }

        }

        if (Character.isLowerCase(firstChar)){
            StringBuilder stringBuilder =  new StringBuilder();
            int pos = 0 ;
            //current char (digit) , pointer
            char current = buffer.charAt(pos);
            boolean isCamel = false;

            while(Character.isLetter(current)){
                if (Character.isUpperCase(current)){
                    isCamel = true;
                }
                stringBuilder.append(current);
                pos++;
                // if else to handle the out of range bug
                //make sure the current pointer is not out of bounds
                if(pos<buffer.length()){
                    current = buffer.charAt(pos);
                } else {
                    break;
                }
            }
            if (isCamel){
                if (stringBuilder.toString().length()<=3){
                    currentToken = new Token(stringBuilder.toString(), Token.Type.SHORT_CAMEL_CASE_WORD);

                } else {
                    currentToken = new Token(stringBuilder.toString(), Token.Type.LONG_CAMEL_CASE_WORD);

                }
            } else {
                currentToken = new Token(stringBuilder.toString(), Token.Type.LOWER_CASE_WORD);

            }

        }

        if (!Character.isLetter(firstChar) && !Character.isDigit(firstChar)){
            currentToken = new Token(Character.toString(firstChar), Token.Type.NON_ALPHANUMERIC);
        }



       
        // ########## YOUR CODE ENDS HERE ##########
        
        // Remove the extracted token from buffer
        int tokenLen = currentToken.getValue().length();
        buffer = buffer.substring(tokenLen);
    }

    /**
     *  returned the current token extracted by {@code next()}
     *  **** please do not modify this part ****
     *  
     * @return type: Token
     */
    public Token current() {
    	return currentToken;
    }

    /**
     *  check whether there still exists another tokens in the buffer or not
     *  **** please do not modify this part ****
     *  
     * @return type: boolean
     */
    public boolean hasNext() {
    	return currentToken != null;
    }


}