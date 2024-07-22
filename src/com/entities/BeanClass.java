package com.entities;

public class BeanClass {
	private int sNo;
	private String ac_no;
	private String name;
	private String pan;
	private String adhar;
	private String mobile;
	private String ac_type;
	private String e_mail;

	public BeanClass(int sNo, String ac_no, String name, String pan, String adhar, String mobile, String ac_type,
			String e_mail) {
		this.sNo = sNo;
		this.ac_no = ac_no;
		this.name = name;
		this.pan = pan;
		this.adhar = adhar;
		this.mobile = mobile;
		this.ac_type = ac_type;
		this.e_mail = e_mail;
	}

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public BeanClass(String ac_no, String name, String pan, String adhar, String mobile, String ac_type,
			String e_mail) {
		this.ac_no = ac_no;
		this.name = name;
		this.pan = pan;
		this.adhar = adhar;
		this.mobile = mobile;
		this.ac_type = ac_type;
		this.e_mail = e_mail;
	}

	public BeanClass() {

	}

	public String getAc_no() {
		return ac_no;
	}

	public void setAc_no(String ac_no) {
		this.ac_no = ac_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getAdhar() {
		return adhar;
	}

	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAc_type() {
		return ac_type;
	}

	public void setAc_type(String ac_type) {
		this.ac_type = ac_type;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	@Override
	public String toString() {
		return "EntitesClass [ac_no=" + ac_no + ", name=" + name + ", pan=" + pan + ", adhar=" + adhar + ", mobile="
				+ mobile + ", ac_type=" + ac_type + ", e_mail=" + e_mail + "]";
	}

}
