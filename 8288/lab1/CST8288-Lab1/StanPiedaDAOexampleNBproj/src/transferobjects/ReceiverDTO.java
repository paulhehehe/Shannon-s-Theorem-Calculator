/* File: ReceiverDTO.java
 * Author: Zhicheng He
 * Date: 2023/10/10
 * Description: Demonstration of DAO Design Pattern, MVC Design Pattern
 */
package transferobjects;

public class ReceiverDTO {
    private Integer awardID;
    private String firstName;
    private String lastName;
    
    public Integer getAwardID(){
    	return awardID;
    }
    public void setAwardID(Integer awardID){
    	this.awardID = awardID;
    }
    
    public String getName(){
    	return firstName;
    }
    public void setName(String firstName){
    	this.firstName = firstName;
    }
    
    public String getCategory(){
    	return lastName;
    }
    public void setCategory(String lastName){
    	this.lastName = lastName;
    }
    
}
