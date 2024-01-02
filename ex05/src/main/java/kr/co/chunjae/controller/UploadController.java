package kr.co.chunjae.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Log4j
public class UploadController {

  @GetMapping("/uploadForm")
  public void uploadForm(){
    log.info("uploadForm");
  }

  @PostMapping("uploadFormAction")
  public void uploadPost(MultipartFile[] uploadFile , Model model){

    for (MultipartFile multipartFile : uploadFile){

      log.info("-------------------------------------");
      log.info("upload file name : " + multipartFile.getOriginalFilename());
      log.info("upload file size : " + multipartFile.getSize());
    }

  }
}

