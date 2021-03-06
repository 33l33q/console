package bitcamp.java142.ch5.ldbjf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bitcamp.java142.ch5.ldbjf.common.LdbCheabunClass;
import bitcamp.java142.ch5.ldbjf.common.LdbConnProperty;
import bitcamp.java142.ch5.ldbjf.sql.LdbSqlQueryMap;
import bitcamp.java142.ch5.ldbjf.vo.LdbMemberVO;


public class LdbMemberDAOImpl implements LdbMemberDAO {

	@Override
	public boolean insertLdbMember(LdbMemberVO i_lvo) {
		
		System.out.println("(log) LdbMemberScr.LdbMemberDAO.insertLdbMember(LdbMemberVO i_lvo) 함수 진입  ");
		 
		System.out.println("i_lvo 참조변수 주소값 : " + i_lvo );
		
		System.out.println(" " + i_lvo.getLname() + " " +  i_lvo.getLid()+ " " + i_lvo.getLpw()+ " " + i_lvo.getLhp()
						 + " " +  i_lvo.getLbirth() + " " + i_lvo.getLmail() + " " + i_lvo.getLpostnum() + " " +  i_lvo.getLjuso ());

		   
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int nCnt = 0;
		
		try{
			//connetion 구하기
			System.out.println("(log) LdbMemberScr.LdbConnProperty.getConnection() 함수 실행 "); 
			con = LdbConnProperty.getConnetion();
			System.out.println("DB 주소 연결  >>> " + con);
			
			System.out.println("con.getAutoCommit() >>>  " + con.getAutoCommit());
			con.setAutoCommit(false);
			System.out.println("con.getAutoCommit() >>>  " + con.getAutoCommit());
			
			System.out.println("(log) LdbMemberScr.LdbSqlQueryMap.getInsertQuery() 함수 실행 "); 
			pstmt = con.prepareStatement(LdbSqlQueryMap.getInsertQuery());
			System.out.println("EciSqlQueryMap.getInsertQuery() : \n" 
					+ LdbSqlQueryMap.getInsertQuery());	 
			
			pstmt.setString(1, LdbCheabunClass.commonNo_LDB_MEMBER());
			pstmt.setString(2, i_lvo.getLname());
			pstmt.setString(3, i_lvo.getLid());
			pstmt.setString(4, i_lvo.getLpw());
			pstmt.setString(5, i_lvo.getLhp());
			pstmt.setString(6, i_lvo.getLbirth());
			pstmt.setString(7, i_lvo.getLmail());
			pstmt.setString(8, i_lvo.getLpostnum());
			pstmt.setString(9, i_lvo.getLjuso());
			pstmt.setString(10, "Y");
			
			System.out.println("(log) LdbMemberScr.pstmt.executeUpdate() 함수 실행 "); 
			nCnt = pstmt.executeUpdate();
			
			System.out.println("숫자 확인 >>> " + nCnt);
			
			if(!con.getAutoCommit()) con.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{LdbConnProperty.conClose(con, pstmt);}
			catch(Exception e2){}
		}
		if(nCnt == 0 ) return false;
		System.out.println("(log) LdbMemberScr.LdbMemberDAO.insertLdbMember(LdbMemberVO i_lvo) 함수 종료 ");
		return true;
	}

	@Override
	public boolean updateLdbMember(LdbMemberVO i_lvo) {
		
		System.out.println("(log) LdbMemberScr.LdbMemberDAO.updateLdbMember(LdbMemberVO i_lvo) 함수 진입");
		System.out.println(" i_lvo 참조변수 주소값 : " + i_lvo );
		System.out.println(i_lvo.getLpw() + " " +  i_lvo.getLmem());
		
		//지역변수 초기화		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int nCnt = 0;
		
		try
		{	
			System.out.println("(log) LdbMemberScr.LdbConnProperty.getConnection() 함수 실행 "); 
			con = LdbConnProperty.getConnetion();
			System.out.println("DB 주소 연결  >>> " + con);
			
			System.out.println("(log) LdbMemberScr.LdbSqlQueryMap.getUpdateQuery() 함수 실행 "); 
			pstmt = con.prepareStatement(LdbSqlQueryMap.getUpdateQuery());
			System.out.println("EciSqlQueryMap.getInsertQuery() : \n" 
					+ LdbSqlQueryMap.getUpdateQuery());	 
			
			pstmt.setString(1, i_lvo.getLpw());
			pstmt.setString(2, i_lvo.getLmem());
			System.out.println(i_lvo.getLpw() + " " + i_lvo.getLmem());
			
			System.out.println("(log) LdbMemberScr.pstmt.executeUpdate() 함수 실행 "); 
			nCnt = pstmt.executeUpdate();
			System.out.println("nCnt  >>> : " + nCnt);
			
			if(!con.getAutoCommit()) con.commit();
			System.out.println("수정 되었습니다 >>> " + nCnt);
			
		}catch(Exception e){
			System.out.println("에러발생!" + e.getMessage());
		}finally{
			try{LdbConnProperty.conClose(con, pstmt);}catch(Exception e2){
			}
		}
		
		if (nCnt == 0) return false;
		System.out.println("(log) LdbMemberScr.LdbMemberDAO.updateLdbMember(LdbMemberVO i_lvo) 함수 종료");
		return true;
	}

	@Override
	public boolean deleteLdbMember(LdbMemberVO i_lvo) {
		System.out.print("(log) LdbMemberScr.LdbMemberDAO.deleteLdbMember(LdbMemberVO i_lvo) 함수 진입");
		System.out.println(" i_lvo 참조변수 주소값 : " + i_lvo );
		System.out.println(i_lvo.getLmem());
		
		//지역변수 초기화
		Connection	con			= null;
		PreparedStatement pstmt = null;
		
		int nCnt = 0;
		
		try{
			System.out.println("(log) LdbMemberScr.LdbConnProperty.getConnection() 함수 실행 "); 
			con = LdbConnProperty.getConnetion();
			System.out.println("DB 주소 연결  >>> " + con);
			
			System.out.println("con.getAutoCommit() >>>  " + con.getAutoCommit());
			con.setAutoCommit(false);
			System.out.println("con.getAutoCommit() >>>  " + con.getAutoCommit());
			
			System.out.println("(log) LdbMemberScr.LdbSqlQueryMap.getDeleteQuery() 함수 실행 "); 
			pstmt = con.prepareStatement(LdbSqlQueryMap.getDeleteQuery());
			System.out.println("EciSqlQueryMap.getDeleteQuery() : \n" 
					+ LdbSqlQueryMap.getDeleteQuery());	 
						
			pstmt.setString(1, i_lvo.getLmem());
			
			System.out.println("i_lvo.getLmem() >>> : " + i_lvo.getLmem() );
			System.out.println("i_lvo.getLpw() >>> : " + i_lvo.getLpw());

			
			
			System.out.println("(log) LdbMemberScr.pstmt.executeUpdate() 함수 실행 "); 
			nCnt = pstmt.executeUpdate();
			System.out.println("nCnt  >>> : " + nCnt);
			
			if (!con.getAutoCommit()) con.commit(); 
            System.out.println("delete 잘 되었음 >>> : " + nCnt);
            
            LdbConnProperty.conClose(con, pstmt);

		}catch(Exception e){
		}finally{
			LdbConnProperty.conClose(con, pstmt);
			try{
				LdbConnProperty.conClose(con, pstmt);
			}catch(Exception e2){
				System.out.println("문제가 발생했습니다 >>> : " + e2.getMessage());
			}
				}
		if (nCnt == 0) return false;
		System.out.println("(log) LdbMemberScr.LdbMemberDAO.deleteLdbMember(LdbMemberVO i_lvo) 함수 종료");
		return true;
	}
	

	@Override
	public ArrayList<LdbMemberVO> selectLdbMember() {
		
		System.out.println("(log) LdbMemberScr.LdbMemberDAO.selectLdbMember() 함수 진입");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<LdbMemberVO> aList = null;
		LdbMemberVO lvo = null;
		
		
		try {
			
			System.out.println("(log) LdbMemberScr.LdbConnProperty.getConnection() 함수 실행 ");
			con = LdbConnProperty.getConnetion();
			System.out.println(" con >>> : " + LdbConnProperty.getConnetion());
			
			System.out.println("(log) LdbMemberScr.LdbConnProperty.getSelectQuery() 함수 실행 ");
			pstmt = con.prepareStatement(LdbSqlQueryMap.getSelectQuery());
	        System.out.println(" LdbSqlQueryMap.getSelectQuery() :: \n" 
						+ LdbSqlQueryMap.getSelectQuery());	
	         
	       
	        System.out.println("(log) LdbMemberScr.pstmt.executeQuery() 함수 실행 "); 
			rsRs = pstmt.executeQuery();
			System.out.println(" rsRs >>> : " +  rsRs);
			
			if(rsRs != null){
				aList = new ArrayList<LdbMemberVO>();
				while(rsRs.next()){
					lvo = new LdbMemberVO();
					lvo.setLmem(rsRs.getString("LMEM"));
					lvo.setLname(rsRs.getString("LNAME"));
					lvo.setLid(rsRs.getString("LID"));
					lvo.setLpw(rsRs.getString("LPW"));
					lvo.setLhp(rsRs.getString("LHP"));
					lvo.setLbirth(rsRs.getString("LBIRTH"));
					lvo.setLmail(rsRs.getString("LEMAIL"));
					lvo.setLpostnum(rsRs.getString("LPOSTNO"));
					lvo.setLjuso(rsRs.getString("LADDR"));
					lvo.setLdeleteYN(rsRs.getString("LDELETEYN"));
					lvo.setLinsertdate(rsRs.getString("LINSERTDATE"));
					lvo.setLupdatedate(rsRs.getString("LINSERTDATE"));
					aList.add(lvo);
				}
				System.out.println("aList.size() >>> : " + aList.size());
			}else{
				System.out.println("데이터가 없습니다");
			}
			
			LdbConnProperty.conClose(con, pstmt, rsRs);
			
		}catch(Exception e){
			System.out.println("에러가 >>> : " + e.getMessage());
		}finally{
			LdbConnProperty.conClose(con, pstmt, rsRs);
			try{LdbConnProperty.conClose(con, pstmt, rsRs);
			}catch(Exception e2){
				System.out.println("문제가 발생했습니다 >>> : " + e2.getMessage());
			}
		}
		System.out.println("(log) LdbMemberScr.LdbMemberDAO.selectLdbMember() 함수 종료");
		return aList;
	}

	@Override
	public ArrayList<LdbMemberVO> searchLdbMember(LdbMemberVO i_lvo) {
		System.out.print("(log) LdbMemberScr.searchLdbMember() 함수 진입");
		System.out.println("i_lvo 참조변수 주소값 : " + i_lvo );
		System.out.println("매개변수 확인 : " + i_lvo.getLmem() );
		 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<LdbMemberVO> aList = null;
		LdbMemberVO lvo = null;
		
		try{
			System.out.println("(log) LdbMemberScr.LdbConnProperty.getConnection() 함수 실행");
			con = LdbConnProperty.getConnetion();
			System.out.println("con >>> : " + con);
			
			System.out.println("(log) LdbMemberScr.LdbConnProperty.prepareStatement.getSearchQuery() 함수 실행");
			pstmt = con.prepareStatement(LdbSqlQueryMap.getSearchQuery());
	        System.out.println("LdbSqlQueryMap.getSearchQuery() :: \n" 
						+ LdbSqlQueryMap.getSearchQuery());
	        
	        
	        pstmt.setString(1, i_lvo.getLmem());
	        System.out.println(i_lvo.getLmem());
	       
	        System.out.println("(log) LdbMemberScr.pstmt.executeQuery() 함수 실행 "); 
			rsRs = pstmt.executeQuery();
			System.out.println(" rsRs >>> : " +  rsRs);
			
				if(rsRs != null){
					
					aList = new ArrayList<LdbMemberVO>();
					
					while(rsRs.next()){
						lvo = new LdbMemberVO();
						lvo.setLmem(rsRs.getString("LMEM"));
						lvo.setLname(rsRs.getString("LNAME"));
						lvo.setLid(rsRs.getString("LID"));
						lvo.setLpw(rsRs.getString("LPW"));
						lvo.setLhp(rsRs.getString("LHP"));
						lvo.setLbirth(rsRs.getString("LBIRTH"));
						lvo.setLmail(rsRs.getString("LEMAIL"));
						lvo.setLpostnum(rsRs.getString("LPOSTNO"));
						lvo.setLjuso(rsRs.getString("LADDR"));
						lvo.setLdeleteYN(rsRs.getString("LDELETEYN"));
						lvo.setLinsertdate(rsRs.getString("LINSERTDATE"));
						lvo.setLupdatedate(rsRs.getString("LINSERTDATE"));
						aList.add(lvo);
					}
					System.out.println("aList.size() >>> : " + aList.size());
				}else{
					System.out.println("데이터가 없습니다");
				}
				LdbConnProperty.conClose(con, pstmt, rsRs);
				
				
		}catch(Exception e){
			System.out.println("오류가 발생했습니다 " +  e.getMessage());
		}finally{
			LdbConnProperty.conClose(con, pstmt, rsRs);
		}
		System.out.println("(log) LdbMemberScr.LdbMemberDAO.searchLdbMember() 함수 종료");
		
		return aList;
	}//end of search

	@Override
	public ArrayList<LdbMemberVO> likeSearchLdbMember(LdbMemberVO i_lvo) {
		System.out.println("(log) LdbMemberScr.LdbMemberDAO.likeSearchLdbMember() 함수 진입");
		System.out.println("i_lvo 참조변수 주소값 : " + i_lvo );
		System.out.println("매개변수 확인 : " + i_lvo.getLmem() );
		 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<LdbMemberVO> aList = null;
		LdbMemberVO lvo = null;
		
		try{
			System.out.println("(log) LdbMemberScr.LdbConnProperty.getConnection() 함수 실행");
			con = LdbConnProperty.getConnetion();
			System.out.println("con >>> : " + con);
			
			System.out.println("(log) LdbMemberScr.LdbConnProperty.prepareStatement.getLikeSearchQuery() 함수 실행");
			pstmt = con.prepareStatement(LdbSqlQueryMap.getLikeSearchQuery());
	        System.out.println("LdbSqlQueryMap.getLikeSearchQuery() :: \n" 
						+ LdbSqlQueryMap.getLikeSearchQuery());
	        
	        
	        pstmt.setString(1, i_lvo.getLmem());
	        System.out.println(i_lvo.getLmem());
	       
	        System.out.println("(log) LdbMemberScr.pstmt.executeQuery() 함수 실행 "); 
			rsRs = pstmt.executeQuery();
			
				if(rsRs != null){
					
					aList = new ArrayList<LdbMemberVO>();
					
					while(rsRs.next()){
						lvo = new LdbMemberVO();
						lvo.setLmem(rsRs.getString("LMEM"));
						lvo.setLname(rsRs.getString("LNAME"));
						lvo.setLid(rsRs.getString("LID"));
						lvo.setLpw(rsRs.getString("LPW"));
						lvo.setLhp(rsRs.getString("LHP"));
						lvo.setLbirth(rsRs.getString("LBIRTH"));
						lvo.setLmail(rsRs.getString("LEMAIL"));
						lvo.setLpostnum(rsRs.getString("LPOSTNO"));
						lvo.setLjuso(rsRs.getString("LADDR"));
						lvo.setLdeleteYN(rsRs.getString("LDELETEYN"));
						lvo.setLinsertdate(rsRs.getString("LINSERTDATE"));
						lvo.setLupdatedate(rsRs.getString("LINSERTDATE"));
						aList.add(lvo);
					}
					System.out.println("aList >>> : " + aList);
					System.out.println("aList.size() >>> : " + aList.size());
				}else{
					System.out.println("데이터가 없습니다");
				}
				
				LdbConnProperty.conClose(con, pstmt, rsRs);
			
		}catch(Exception e){
			System.out.println("오류가 발생했습니다 " +  e.getMessage());
		}finally{
			LdbConnProperty.conClose(con, pstmt, rsRs);
		}

		System.out.println("(log) LdbMemberScr.LdbMemberDAO.likeSearchLdbMember() 함수 종료");
		
		return aList;
	}

}


