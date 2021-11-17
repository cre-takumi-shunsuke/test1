package model.entity;
import java.io.Serializable;

public class CustomerBean implements Serializable {
	private int customer_id;
	private String userid;
	private String password;
	private String nendo;
	private String customer_code;
	private int buy_point;
	private int pos_point;



	public CustomerBean() {

	}

	public int getCustomerId() {
		return customer_id;
	}

	public void setCustomerId(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getUserId() {
		return userid;
	}

	public void setUserId(String userid) {
		this.userid = userid;
	}

	public String getPassWord() {
		return password;
	}

	public void setPassWord(String password) {
		this.password = password;
	}
	public String getNendo() {
		return nendo;
	}

	public void setNendo(String nendo) {
		this.nendo = nendo;
	}

	public String getCustomer_code() {
		return customer_code;
	}

	public void setCustomer_code(String customer_code) {
		this.customer_code = customer_code;
	}

	public int getBuy_point() {
		return buy_point;
	}

	public void setBuy_point(int buy_point) {
		this.buy_point = buy_point;
	}

	public int getPos_point() {
		return pos_point;
	}

	public void setPos_point(int pos_point) {
		this.pos_point = pos_point;
	}

}