package com.naver.prj1;

import java.io.File;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
    private String newFileName = null;
    private MultipartFile multi = null;

    

    public String makeNewName(MultipartFile multi){
        // 만약 업로드된 파일이 있으면
        if(multi!=null && multi.isEmpty()==false){
            this.multi = multi;
            // 업로드한 파일의 원래 파일명 얻기. 파일명에는 확장자가 포함한다.
            String oriFileName = this.multi.getOriginalFilename();
            // 업로드한 파일의 파일 확장자 얻기.
            String file_extension = oriFileName.substring(oriFileName.lastIndexOf(".")+1);
            // 고유한 새 파일명 얻기. 파일명에는 파일확장자가 포함된다.
            this.newFileName = UUID.randomUUID()+"."+file_extension;
            return this.newFileName;
        }
        return null;
    }
    public void uploadFile(String uploadDir) throws Exception {
        // 파일 업로드하기
        // 만약 업로드된 파일이 있으면
        if(multi!=null && multi.isEmpty()==false){
            // 새 파일을 생성하기
            File file = new File(uploadDir + "\\" + newFileName);
            // 업로드한 파일을 새 파일에 전송하여 덮어쓰기
            multi.transferTo(file);
        }

    }
    public void deleteOldFile( String pic, String uploadDir ){
        File file = new File(uploadDir + "\\" + pic);
        file.delete();
    }
}
