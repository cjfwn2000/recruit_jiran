package com.leecheolju.mydemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TtsController {
    @GetMapping("/tts")
    public String tts(@RequestParam String text) {
        //String cmdarray[] = {"python", "python-tts/tts.py", "python-tts/output.mp3", text};
        String cmdarray[] = {"python3", "python-tts/tts.py", "python-tts/output.mp3", text};
        try {
            Process ttsprocess = Runtime.getRuntime().exec(cmdarray);
            ttsprocess.waitFor();
        } catch (Exception e) {
            System.out.println("FAIL");
            return "fail";
        }
        //random: 캐싱 방지를 위함
        return "/ttsfile/output.mp3?cb=" + (int)(Math.random() * 1024);
    }
}
