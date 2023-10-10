/* File: ReceiversBusinessLogic.java
 * Aothor: Zhicheng He
 * Date: 2023/10/10
 * Description: Demonstration of DAO Design Pattern, MVC Design Pattern
 */
package businesslayer;

import java.util.List;
import dataaccesslayer.ReceiversDao;
import dataaccesslayer.ReceiversDaoImpl;
import transferobjects.ReceiverDTO;

public class ReceiversBusinessLogic {
	private static final int FIRST_NAME_MAX_LENGTH = 30;
	private static final int LAST_NAME_MAX_LENGTH = 30;
	
	private ReceiversDao receiversDao = null;
	
	public ReceiversBusinessLogic(){
		receiversDao = new ReceiversDaoImpl();
	}
	
        public void getMetaData(){
            receiversDao.getMetaData();
        }
	public List<ReceiverDTO> getAllReceivers(){
		return receiversDao.getAllReceivers();
	}
	
	public ReceiverDTO getReceiver(Integer awardID){
		return receiversDao.getReceiverByReceiverId(awardID); 
	}
	
	public void addReceiver(ReceiverDTO receivers) throws ValidationException{
		cleanReceivers(receivers);
		validateReceivers(receivers);
		receiversDao.addReceiver(receivers);
	}
	
	public void updateReceiver(ReceiverDTO receivers) throws ValidationException{
		cleanReceivers(receivers);
		validateReceivers(receivers);
		receiversDao.updateReceiver(receivers);
	}
	
	public void deleteReceiver(ReceiverDTO receivers){
		receiversDao.deleteReceiver(receivers);
	}
	
	private void cleanReceivers(ReceiverDTO receivers){
		if(receivers.getName() != null){ 
			receivers.setName(receivers.getName().trim());
		}
		if(receivers.getCategory() != null){ 
			receivers.setCategory(receivers.getCategory().trim());
		}
	}
	
	private void validateReceivers(ReceiverDTO receivers) throws ValidationException{
		validateString(receivers.getName(), "First Name", FIRST_NAME_MAX_LENGTH, true);
		validateString(receivers.getCategory(), "Last Name", LAST_NAME_MAX_LENGTH, true);
	}
	
	private void validateString(String value, String fieldName, int maxLength, boolean isNullAllowed)
	    throws ValidationException{
		if(value == null && isNullAllowed){
			// return; // null permitted, nothing to validate
		}
		else if(value == null && ! isNullAllowed){
		    throw new ValidationException(String.format("%s cannot be null", 
		    		fieldName));
		}
		else if(value.length() == 0){
			throw new ValidationException(String.format("%s cannot be empty or only whitespace", 
					fieldName));
		}
		else if(value.length() > maxLength){
			throw new ValidationException(String.format("%s cannot exceed %d characters", 
					fieldName, maxLength));
		}
	}
	
}
