package Q2;

/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 * @author huy.pham
 */
public class Tokenizer {
    private String _buffer;
    private final char COMMAND_SEPARATOR = ';';


    public Tokenizer(String buffer) {
        this._buffer = buffer;
        int idx = this._buffer.indexOf(";");
        if (idx > 0) {
            this._buffer = this._buffer.substring(0, idx);
        }
    }
    
    /**
     * @return the next token
     */
    private Token next() {
        _buffer = _buffer.trim();
        if (_buffer.isEmpty())
            return null;
        
        if (_buffer.startsWith(Token.Type.LEFT.toString())) 
            return new Token(Token.Type.LEFT);
        
        if (_buffer.startsWith(Token.Type.RIGHT.toString())) 
            return new Token(Token.Type.RIGHT);
        
        // TODO: Implement "FORWARD" and "BACK" tokenization.
        // hints:
        // - Character.isDigit() may be useful in extracting the forward or back value from the buffer.
        // - Use new Token(<type>, <original token str>, <value>) to return these tokens
        if (_buffer.startsWith(Token.Type.FORWARD.toString())){
            StringBuilder stringBuilder =  new StringBuilder();
            int pos = 8 ;
            //current char (digit) , pointer
            char current = _buffer.charAt(pos);
            while(current!=')'){
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
            int value =Integer.parseInt(stringBuilder.toString()) ;

            return new Token(Token.Type.FORWARD,"11",value);

        }

        if (_buffer.startsWith(Token.Type.BACK.toString())){
            StringBuilder stringBuilder =  new StringBuilder();
            int pos = 5 ;
            //current char (digit) , pointer
            char current = _buffer.charAt(pos);
            while(current!=')'){
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
            int value =Integer.parseInt(stringBuilder.toString()) ;

            return new Token(Token.Type.BACK,"11",value);

        }

        // TODO: Implement "PENUP" and "PENDOWN" tokenization.
        if (_buffer.startsWith(Token.Type.PENDOWN.toString()))
            return new Token(Token.Type.PENDOWN);
        if (_buffer.startsWith(Token.Type.PENUP.toString()))
            return new Token(Token.Type.PENUP);

        return null;
    }

    /**
     * Return the next token and remove it from the buffer
     * @return the next token
     */
    public Token takeNext() {
        // TODO: Add your implementation here.
        Token nextToken = next();
        if (nextToken == null)
            return null;

        _buffer = _buffer.substring(nextToken.originalTokenStr.length()).trim();


//        if (nextToken.originalTokenStr.length() < _buffer.length()) {
//            _buffer = _buffer.substring(nextToken.originalTokenStr.length()).trim();
//        } else {
//            _buffer = "";
//        }

        return nextToken;
    }

    /**
     * @return whether there is another token to parse in the buffer
     */
    public boolean hasNext() {
        // TODO: Add your implementation here.
        return next() != null;
    }
   
}