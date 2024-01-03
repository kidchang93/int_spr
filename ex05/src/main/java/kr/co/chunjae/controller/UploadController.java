package kr.co.chunjae.controller;

import kr.co.chunjae.domain.AttachFileDTO;
import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.checkerframework.checker.units.qual.A;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@Log4j
public class UploadController {

  @GetMapping("/uploadForm")
  public void uploadForm(){
    log.info("uploadForm");
  }

  @PostMapping("uploadFormAction")
  public void uploadPost(MultipartFile[] uploadFile , Model model){

    String uploadFolder = "E:\\upload\\temp";

    for (MultipartFile multipartFile : uploadFile){

      log.info("-------------------------------------");
      log.info("upload file name : " + multipartFile.getOriginalFilename());
      log.info("upload file size : " + multipartFile.getSize());

      File saveFile = new File(uploadFolder , multipartFile.getOriginalFilename());

      try{
        multipartFile.transferTo(saveFile);
      }catch(Exception e){
        log.error(e.getMessage());
      } // end catch
    } // end for
  } // end post

  @GetMapping("/uploadAjax")
  public void uploadAjax(){
    log.info("upload ajax");
  }
  private String getFolder() {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  //날짜의 형식

    Date date = new Date(); // 오늘 날짜를 가져오는 인스턴스 생성

    String str = sdf.format(date);  // 그걸 str 이라는 변수에 포맷을 통해 넣어줌

    return str.replace("_", File.separator);  // _로 구분해주는 함수로 변환
  }

  @PostMapping(value = "uploadAjaxAction" , produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] uploadFile){

    List<AttachFileDTO> list = new ArrayList<>();
    log.info("update ajax post ======================");
    String uploadFolder = "E:\\upload\\temp";
    String uploadFolderPath = getFolder();

    // folder 만들기

    File uploadPath = new File(uploadFolder , getFolder());
    log.info("upload Path : " + uploadPath);

    if (uploadPath.exists() == false){
      uploadPath.mkdirs();
    }

    // 날짜 형식 폴더 만들기 ( yyyy/MM/dd )

    // for 문을 돌면서 saveFile이라는 변수에 uploadFileName을 통해 초기화시킨다.
    for (MultipartFile multipartFile : uploadFile){


      log.info("-------------------------------------");
      log.info("upload file name : " + multipartFile.getOriginalFilename());
      log.info("upload file size : " + multipartFile.getSize());


      AttachFileDTO attachDTO = new AttachFileDTO();
      String uploadFileName = multipartFile.getOriginalFilename();

      uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
      log.info("only file name : "+uploadFileName);
      attachDTO.setFileName(uploadFileName);
      //  난수를 이용해 파일 이름을 저장한다.

      UUID uuid = UUID.randomUUID();

      uploadFileName = uuid.toString() + "_" + uploadFileName;

      //  File saveFile = new File(uploadFolder , uploadFileName);

      try{
        File saveFile = new File(uploadPath , uploadFileName);
        multipartFile.transferTo(saveFile); // 예외가 발생하지않으면 파일 저장한다.

        attachDTO.setUuid(uuid.toString());
        attachDTO.setUploadPath(uploadFolderPath);
        // 이미지 타입 파일 체크
        if (checkImageType(saveFile)){
          attachDTO.setImage(true);

          FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
          Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100 , 100);

          thumbnail.close();
        }
        // add to list
        list.add(attachDTO);
      }catch(Exception e){
        log.error(e.getMessage());
      } // end catch
    } // end for
    return new ResponseEntity<>(list, HttpStatus.OK);
  } // end post

  private boolean checkImageType(File file){
    try{
      String contentType = Files.probeContentType(file.toPath());

      return contentType.startsWith("image");

    } catch (IOException e){
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return false;
  }

  @GetMapping("/display")
  @ResponseBody
  public ResponseEntity<byte[]> getFile(String fileName){

    log.info("fileName : " + fileName);

    File file = new File("E:\\upload\\temp\\" + fileName);

    log.info("file : " + file);
    ResponseEntity<byte[]> result = null;

    try {
      HttpHeaders header = new HttpHeaders();

      header.add("Content-Type",Files.probeContentType(file.toPath()));
      result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),header , HttpStatus.OK);
    } catch (IOException e){
      // Todo Auto-generated catch block
      e.printStackTrace();
    }
    return result;


  }



}

