/* File: SimpleDemo.java
 * Author: Zhicheng He
 * Date: 2023/10/10
 * Description: Demonstration of DAO Design Pattern, MVC Design Pattern
 */
import businesslayer.ReceiversBusinessLogic;
import businesslayer.ValidationException;
import transferobjects.ReceiverDTO;

import java.util.List;
public class SimpleDemo {

	public void demo(){
		try{
			ReceiversBusinessLogic logic = new ReceiversBusinessLogic();
			List<ReceiverDTO> list = null;
			ReceiverDTO receiver = null;
			
                        System.out.println("Printing MetaData");
			logic.getMetaData();
			
			System.out.println("Printing Receivers");
			list = logic.getAllReceivers();
			printReceivers(list);
			
			System.out.println("Printing One Receiver");
			receiver = logic.getReceiver(1);
			printReceiver(receiver);
			System.out.println();
			
			System.out.println("Inserting One Receiver");
			receiver = new ReceiverDTO();
			receiver.setName("FirstTestAdd");
			receiver.setCategory("LastTestAdd");
			logic.addReceiver(receiver);
			list = logic.getAllReceivers();
			printReceivers(list);
			
			System.out.println("Updating last receiver");
			Integer updatePrimaryKey = list.get(list.size() - 1).getAwardID();
			receiver = new ReceiverDTO();
			receiver.setAwardID(updatePrimaryKey);
			receiver.setName("FirstTestUpdate");
			receiver.setCategory("LastTestUpdate");
			logic.updateReceiver(receiver);
			list = logic.getAllReceivers();
			printReceivers(list);
			
			System.out.println("Deleting last receiver");
			receiver = list.get(list.size() - 1);
			logic.deleteReceiver(receiver);
			list = logic.getAllReceivers();
			printReceivers(list);	
		}
		catch(ValidationException e){
			System.err.println(e.getMessage());
		}

	}
	
	private static void printReceiver(ReceiverDTO receiver){
	    	String output = String.format("%s, %s, %s",
	    			receiver.getAwardID().toString(),
	    			receiver.getName(),
	    			receiver.getCategory());
	    	System.out.println(output);
	}
	
	private static void printReceivers(List<ReceiverDTO> receivers){
	    for(ReceiverDTO receiver : receivers){
	    	printReceiver(receiver);
	    }
	    System.out.println();
	}
	

}
