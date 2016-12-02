// Ryan Siu
// APCS pd5
// HW07 -- On BigSib Individuality and the Elimination of Radio Fuzz
// 2016-09-22

public class BigSib {
    
    public String helloMsg; // changed to public so the call for this variable in Greet works

    // Changes helloMsg to the inputMsg
    public void setHelloMsg( String inputMsg ){
	helloMsg = inputMsg;
    }

    // Returns the greet message with the input name and the customized message
    // for each instance
    public String greet( String name ){
	String returnMsg;
	returnMsg = helloMsg;
	returnMsg += ", ";
	returnMsg += name;
	return returnMsg;
    }

}
