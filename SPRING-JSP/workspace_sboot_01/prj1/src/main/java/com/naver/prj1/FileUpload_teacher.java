package com.naver.prj1;

import java.io.File;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload_teacher {

    private MultipartFile multi;
    private String newFileName;

    public FileUpload_teacher(MultipartFile multi){
        this.multi = multi;
        if(this.multi!=null && this.multi.isEmpty()==false){
            // 업로드한 파일의 원래 파일명 얻기. 파일명에는 확장자가 포함한다.
            String oriFileName = this.multi.getOriginalFilename();
            // 업로드한 파일의 파일 확장자 얻기.
            String file_extension = oriFileName.substring(oriFileName.lastIndexOf(".")+1);
            // 고유한 새 파일명 얻기. 파일명에는 파일확장자가 포함된다.
            this.newFileName = UUID.randomUUID()+"."+file_extension;
        }
    }

    public String getNewFileName(){
        return this.newFileName;
    }

    public void uploadFile( String upLoadDir ) throws Exception {
        if(this.multi!=null && this.multi.isEmpty()==false && this.newFileName != null && this.newFileName.length()>0){
            // 새 파일을 생성하기
            File file = new File(upLoadDir + "\\" + this.newFileName);
            // 업로드한 파일을 새 파일에 전송하여 덮어쓰기
            multi.transferTo(file);
        }
    }

    public void delete( String filePath ){
        File file = new File( filePath );
        file.delete();
    }
    
}
