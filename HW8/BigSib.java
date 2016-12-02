// Ryan Siu
// APCS pd5
// HW08 -- On the Origins of a BigSib
// 2016-09-23

public class BigSib {
    
    private String helloMsg;

    // Empty constructor
    public BigSib() {
	helloMsg = "Hi";
    }
    
    // Constructor
    public BigSib( String inputMsg ){
	helloMsg = inputMsg;
    }

    /* No longer needed
    public void setHelloMsg( String inputMsg ){
	helloMsg = inputMsg;
    }
    */

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
