/* File: ReceiverDataAccessObject.java
 * Author: Zhicheng He
 * Date: 2023/10/10
 * Description: Demonstration of DAO Design Pattern, MVC Design Pattern
 */
package dataaccesslayer;

import java.util.List;

import transferobjects.ReceiverDTO;

public interface ReceiversDao {
	List<ReceiverDTO> getAllReceivers();
	void getMetaData();
	ReceiverDTO getReceiverByReceiverId(Integer awardID);
	void addReceiver(ReceiverDTO receiver);
	void updateReceiver(ReceiverDTO receiver);
	void deleteReceiver(ReceiverDTO receiver);
}
