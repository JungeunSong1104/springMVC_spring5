package ch06_pjt_01.ems.utils;

public class InitSampleData {
//	private String[] sNums = {"hbs001", "hbs002", "hbs003", "hbs004", "hbs005"};
//	private String[] sIds = {"rabbit", "hippo", "raccoon", "elephant", "lion"};
//	private String[] sPws = {"96539", "64875", "15284", "48765", "28661"};
//	private String[] sNames = {"agatha", "barbara", "chris", "doris", "elva"};
//	private int[] sAges = {19, 22, 20, 27, 19};
//	private char[] sGenders = {'m', 'w', 'w', 'm', 'm'};
//	private String[] sMajors = {"English", "Korean", "French","philosophy", "history"};
	
	private String[] sNums;
	private String[] sIds;
	private String[] sPws;
	private String[] sNames;
	private int[] sAges;
	private char[] sGenders;
	private String[] sMajors;
	
	/* 매개변수가 있는 생성자를 만들어보자 */
//	public InitSampleData(String[] sNums) {
//		this.sNums = sNums;
//		//xml에 매개변수 하나짜리가가 있는 생성자에대한 설정을 안해줬기 때문에 빈 생성이 될때 디폴트 생성자를 호출하려고함
//		//그런데 컴파일러는 기본생성자를 안만들어줬음 우리가 명시적으로 매개변수한개짜리 생성자를 만들어줬기 때문에
//	}
	
	public String[] getsNums() {
		return sNums;
	}
	public void setsNums(String[] sNums) {
		this.sNums = sNums;
	}
	public String[] getsIds() {
		return sIds;
	}
	public void setsIds(String[] sIds) {
		this.sIds = sIds;
	}
	public String[] getsPws() {
		return sPws;
	}
	public void setsPws(String[] sPws) {
		this.sPws = sPws;
	}
	public String[] getsNames() {
		return sNames;
	}
	public void setsNames(String[] sNames) {
		this.sNames = sNames;
	}
	public int[] getsAges() {
		return sAges;
	}
	public void setsAges(int[] sAges) {
		this.sAges = sAges;
	}
	public char[] getsGenders() {
		return sGenders;
	}
	public void setsGenders(char[] sGenders) {
		this.sGenders = sGenders;
	}
	public String[] getsMajors() {
		return sMajors;
	}
	public void setsMajors(String[] sMajors) {
		this.sMajors = sMajors;
	}
	
}
