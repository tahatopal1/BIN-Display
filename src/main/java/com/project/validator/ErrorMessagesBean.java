package com.project.validator;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.stereotype.Component;

@Component
public class ErrorMessagesBean {

	private final String HATA_MESAJI_1 = "Zorunlu alan boş bırakılamaz.";
	private final String HATA_MESAJI_2 = "6 karakter giriniz.";
	private final String HATA_MESAJI_3 = "Girdiğiniz değer sistemde önceden tanımlanmıştır.";
	private final String HATA_MESAJI_4 = "16 karakter giriniz.";
	private final String BASARI_MESAJI = "Yaptığınız işlem başarıyla gerçekleşmiştir!";
	
	public String getHATA_MESAJI_1() {
		return HATA_MESAJI_1;
	}
	public String getHATA_MESAJI_2() {
		return HATA_MESAJI_2;
	}
	public String getHATA_MESAJI_3() {
		return HATA_MESAJI_3;
	}
	public String getHATA_MESAJI_4() {
		return HATA_MESAJI_4;
	}
	public String getBASARI_MESAJI_4() {
		return BASARI_MESAJI;
	}
	public String getBASARI_MESAJI() {
		return BASARI_MESAJI;
	}
	public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bilgi",
        											this.getBASARI_MESAJI_4()));
    }
	
}
