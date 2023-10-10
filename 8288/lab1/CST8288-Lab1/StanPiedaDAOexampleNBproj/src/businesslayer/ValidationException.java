/* File: ValidationException.java
 * Author: Zhicheng He
 * Date: 2023/10/10
 * Description: Demonstration of DAO Design Pattern, MVC Design Pattern
 */
package businesslayer;

public class ValidationException extends Exception {
	
	public ValidationException(){
		super("Data not in valid format");
	}
	
	public ValidationException(String message){
		super(message);
	}
	
	public ValidationException(String message, Throwable throwable){
		super(message, throwable);
	}
	
	public ValidationException(Throwable throwable){
		super(throwable);
	}
}
