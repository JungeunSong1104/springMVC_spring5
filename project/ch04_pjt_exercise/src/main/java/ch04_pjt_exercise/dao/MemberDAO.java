package ch04_pjt_exercise.dao;

import java.util.HashMap;
import java.util.Map;

public class MemberDAO {
	private Map<String, MemberDO> memberDB = new HashMap<String, MemberDO>();
	//맵객체로 저장하는 방법: id값에 객체를 매칭시킬거임
	
	//조회를 하기위해서 셀렉트가  필요함
	//조회한 결과는 멤버를 돌려줌
	public MemberDO select(String id){
		return memberDB.get(id);//memberDB에서 회원을 하나 빼와야지 
	}//아이디로 멤버를 구분지어주자 
	public void insert(MemberDO member) {
		memberDB.put(member.getId(), member);//매개변수로 받아온 MemberDO를 추가해줌?
	}
	public void delete(String id) {
		memberDB.remove(id);//해쉬맵에서 특정 데이터 삭제할때는 remove사용
	}
	public void update(MemberDO member) {//update가은경우는 원래 sql구문으로 수정ㅇ해야하지만 여기서는 해쉬맵으로 하니까 객체자체를 바꿔주면 됨
		memberDB.put(member.getId(), member);//중복된 데이터를 넣으면 덮어씌워지니까 기존에 있던 멤버가 교체되겠지
	}
	public Map<String, MemberDO> getMembers(){
		return memberDB;
	}
}
