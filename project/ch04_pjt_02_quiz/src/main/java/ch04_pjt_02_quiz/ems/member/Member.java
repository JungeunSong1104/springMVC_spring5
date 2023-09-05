package ch04_pjt_02_quiz.ems.member;

import java.util.Date;

public class Member {
	private String mNum;
	private String mId;
	private String mPw;
	private String mTel;
	private String mEmail;
	private String rDate;
	private String uDate;
	
	public Member(String mNum, String mId, String mPw, String mTel, String mEmail, String rDate, String uDate) {
		super();
		this.mNum = mNum;
		this.mId = mId;
		this.mPw = mPw;
		this.mTel = mTel;
		this.mEmail = mEmail;
		this.rDate = rDate;
		this.uDate = uDate;
	}
	
	public String getmNum() {
		return mNum;
	}
	public void setmNum(String mNum) {
		this.mNum = mNum;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmPw() {
		return mPw;
	}
	public void setmPw(String mPw) {
		this.mPw = mPw;
	}
	public String getmTel() {
		return mTel;
	}
	public void setmTel(String mTel) {
		this.mTel = mTel;
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	public String getrDate() {
		return rDate;
	}

	public void setrDate(String rDate) {
		this.rDate = rDate;
	}

	public String getuDate() {
		return uDate;
	}

	public void setuDate(String uDate) {
		this.uDate = uDate;
	}
	
}
