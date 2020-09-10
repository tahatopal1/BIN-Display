package com.project.validator;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

@FacesValidator("com.project.validator.BinValidator")
public class BinValidator implements Validator<Object>{
	
	ErrorMessagesBean errorMessagesBean;

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		if(component.getId().equals("bank")) {
			if(value.toString().equals("Seciniz...")) {
				
				errorMessagesBean = new ErrorMessagesBean();
				
				FacesMessage facesMessage = new FacesMessage(errorMessagesBean.getHATA_MESAJI_1());
				facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(facesMessage);
			}
		}
		
		else if(component.getId().equals("bin")) {
			if(value.toString().length() != 6) {
				
				errorMessagesBean = new ErrorMessagesBean();
				
				FacesMessage facesMessage = new FacesMessage(errorMessagesBean.getHATA_MESAJI_2());
				facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(facesMessage);
			}
			
			Integer bin = Integer.valueOf(value.toString());

			if(!this.controlBIN(bin)) {
				
				errorMessagesBean = new ErrorMessagesBean();
				
				FacesMessage facesMessage = new FacesMessage(errorMessagesBean.getHATA_MESAJI_3());
				facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(facesMessage);
			}
			
		}
		
		else if(component.getId().equals("end") || component.getId().equals("start")) {
			if(value.toString().length() != 16) {
				
				errorMessagesBean = new ErrorMessagesBean();
				
				FacesMessage facesMessage = new FacesMessage(errorMessagesBean.getHATA_MESAJI_4());
				facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(facesMessage);
			}
		}
		
	}
	
	public Boolean controlBIN(Integer bin) {
		  try {
			  
			  Sql2o sql2o = new Sql2o("jdbc:h2:mem:testdb", "admin", "");
			  Connection con = sql2o.open();
			  final String query = "SELECT bin FROM INFORMATION_SCHEMA.BIN"
			  		+ " where bin = :bin";
			    
			  List<String> binList 
			     = con.createQuery(query).addParameter("bin", bin)
			     .executeAndFetch(String.class);
			 
			  return binList.isEmpty();
			  
		  }catch(Exception e) {
			  e.printStackTrace();
			  return null;
		  }
	}

}
