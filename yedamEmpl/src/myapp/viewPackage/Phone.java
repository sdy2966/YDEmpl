package myapp.viewPackage;

import javafx.beans.property.SimpleStringProperty;

public class Phone {
	private SimpleStringProperty smartPhone;
	private SimpleStringProperty image;// Property는 문자열 값을 넣으면 속성값을 지정할 수 있도록 함???
	
	public Phone(String smartPhone, String image) {
		this.smartPhone = new SimpleStringProperty(smartPhone);
		this.image = new SimpleStringProperty(image);
	}

	public String getSmartPhone() {
		return smartPhone.get();
	}

	public void setSmartPhone(String smartPhone) {//스마트폰 속성값을 부여하여 리턴하겠다
		this.smartPhone.set(smartPhone);
	}

	public String getImage() {
		return image.get();
	}

	public void setImage(String image) {
		this.image.set(image);
	}
	
	public SimpleStringProperty smartPhoneProperty() {
		return smartPhone;
		
	}
	public SimpleStringProperty imageProperty() {
		return image;
		
	}
	
	//스마트폰 속성값을 부여하여 리턴하겠다
}
