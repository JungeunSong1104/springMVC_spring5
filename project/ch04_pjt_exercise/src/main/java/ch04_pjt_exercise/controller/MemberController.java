package ch04_pjt_exercise.controller;

import ch04_pjt_exercise.dao.MemberDAO;
import ch04_pjt_exercise.dao.MemberDO;
import ch04_pjt_exercise.view.MemberViewer;

public class MemberController {//다오를 사용해야함 뷰도 사용해야함 그래서 임포트해줌
	private MemberDAO memberDao;
	private MemberViewer memberViewer;
	
	public MemberController(MemberDAO memberDao) {
		this.memberDao = memberDao;//MemberDAO를 받아서 초기화해줌
	}
	
	//컨트롤러가하는역할 : 멤버객체를추가, 수정, 삭제 다오가 하던일을 다오한테 컨트롤러가 명령을 내림
	public void insert(MemberDO member) {
		if(verify(member.getId())){
			memberDao.insert(member);
		}else{
			memberViewer.showMessage("This member has already been registered\n");
		}//member.getId를 활용ㅇ해서 중복된애가 있는지 없는지확인
		
	}
	
	public void delete(String memberId) {
		if(verify(memberId)) {
			memberDao.delete(memberId);
		}else {
			memberViewer.showMessage("Delete failed\n");
		}
	}
	
	public void showSelectedMember(String memberId) {
		if(verify(memberId)) {
			memberViewer.showMember(memberDao.select(memberId));//내가보려고하는학생정보가잇으면 실행
		}else {
			memberViewer.showMessage("There is no student who you are looking for\n");//학생정보가없을떄
		}
	}
	
	public void modifySelectedMember(String memberId) {
		if(!verify(memberId)) {
			memberDao.update(memberDao.select(memberId));//괄호안에 멤버가 들어감
		}else {
			memberViewer.showMessage("There is no student who you are looking for\n");
		}
	}
	
	public void showAllMembers() {//모든학생정보를 보여줘야하니까 매개변수 따로필요없음
		memberViewer.showAllMembers(memberDao.getMembers());//맵정보가 넘어가야함 맴정보는 다오가 가지고있으니까 
	}
	
	public boolean verify(String id) {//추가할때 그냥하면안되고 이미존재하고있는 멤버는 추가하면안되니까 추가적인 메서드 하나만들어줌
		MemberDO member = memberDao.select(id);//만얀ㄱ같은아이디가진애가있으면 참조변수에 들어가겠지? 만약 참조변수에들어간경우 null이 아니겠지
		return member == null ? true : false;//null이 아닐경우 false를 돌려줌
		//memberDao얘한테 물어봐서 가져온데이터가있으면 false가반환되고 없으면 true가 반환됨 트루면 증복된게없다는뜻
		
	}

}
