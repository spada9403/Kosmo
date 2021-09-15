package com.naver.prj1;


import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


    // 서비스 클래스인 BoardServiceImpl 클래스 선언
    //     서비스 클래스에는 @Service 와 @Transactional 를 붙인다
    //     @Service                =>       서비스 클래스 임을 지정하고 bean태그로 자동 등록된다.
    //     @Transactional        =>        서비스 클래스의 메소드 내부에서 일어나는 모든 작업에는 [트랜잭션]이 걸린다.

@Service
@Transactional
public class BoardServiceImpl implements BoardService {

    // 속성변수 boardDAO 선언하고, BoardDAO 인터페이스를 구현한 클래스를 객체화해서 저장한다.
    //     @Autowired 역활         =>      속성변수에 붙은 자료형인 [인터페이스를]를 구현한 [클래스]를 객체화하여 저장한다.

    @Autowired
    private BoardDAO boardDAO;

    // 업로드 파일의 저장 경로 저장하는 속성변수 선언하기.
    // <주의> 경로가 문자열이므로 \ 를 \\ 로 써야함 \\ 대신에 / 쓰지 말것.
    String uploadDir = "C:\\kosmo\\수업자료\\SPRING-JSP\\workspace_sboot_01\\prj1\\src\\main\\resources\\static\\resources\\img";

    // 1개 게시판 글 입력 적용 행의 개수    리턴하는 메소드 선언
    public int insertBoard(BoardDTO boardDTO, MultipartFile multi) throws Exception{



        FileUpload uploadFile = new FileUpload();
        // 업로드한 파일의 새로운 이름 정하기
        // 업로드한 파일의 새 파일명 저장할 변수 선언하기. 파일명에는 확장자가 포함된다.
        boardDTO.setPic(uploadFile.makeNewName(multi));



        if( boardDTO.getB_no()>0){
            this.boardDAO.updatePrintNo(boardDTO);
        }
        // BoardDAOImpl 객체의 insertBoard 메소드 호출하여 게시판 글 입력 후 입력 적용 행의 개수 얻기
        int boardRegCnt = this.boardDAO.insertBoard(boardDTO);



        // 파일 업로드하기
        // 만약 업로드된 파일이 있으면
        uploadFile.uploadFile(uploadDir);



        // 1개 게시판 글 입력 적용 행의 개수 리턴하기
        return boardRegCnt;
    };

    public BoardDTO getBoard(int b_no){
        int updateCnt = this.boardDAO.updateReadCount(b_no);
        if( updateCnt==0 ){ return null; }
        BoardDTO boardDTO = this.boardDAO.getBoard(b_no);
        return boardDTO;
    }
    public int upDelBoard(BoardDTO boardDTO, String upDel, MultipartFile multi) throws Exception {
        int b_no = boardDTO.getB_no();
        FileUpload_teacher uploadFile = new FileUpload_teacher(multi);
        try {
            BoardDTO pwdMatchDTO = boardDAO.pwdMatch(boardDTO);
            if(pwdMatchDTO != null){
                String dbPwd = pwdMatchDTO.getPwd();
                String is_Del = boardDTO.getKillImage();
                String pic = this.boardDAO.getPic(boardDTO);
                if(dbPwd.equals(boardDTO.getPwd())){
                    if(upDel.equals("up")){



                        if(is_Del == null){
                            boardDTO.setPic(uploadFile.getNewFileName());
                        }
                        /*
                        이렇게 하지 말고
                        쿼리쪽에서 검사하기.
                        if(is_Del != null && pic!=null){
                            int imgDelCnt = this.boardDAO.delPic(boardDTO);
                        }
                        */
                        int updateCnt = this.boardDAO.updateBoard(boardDTO);

                        if(is_Del == null){


                            uploadFile.uploadFile(uploadDir);


                        }else {

                            if(pic != null && pic.length()>0){
                                File file = new File( uploadDir + pic);
                                file.delete();
                            }

                        }
                        return updateCnt;
                    } else {
                        int childrenCnt = this.boardDAO.getChildrenCnt(boardDTO);
                        if(childrenCnt > 0){return -4;};
                        this.boardDAO.downPrintNo(boardDTO);
                        int deleteCnt = boardDAO.deleteBoard(b_no);
                        uploadFile.delete(uploadDir+"/"+pic);
                        return deleteCnt;
                    }
                } else {
                    return -2;
                }
            } else {
              return -3;
            }
    } catch (Exception e) {
        return -1;
    }

    }
}
