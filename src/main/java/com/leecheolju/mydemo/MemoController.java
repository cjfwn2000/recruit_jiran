package com.leecheolju.mydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/memo")
public class MemoController {

    // 메모 데이터베이스에 접근을 도와주는 객체
    @Autowired
    private MemoRepository memoRepository;

    // 메모 읽어들이기
    @GetMapping(path="")
    public ModelAndView getAllMemos() {
        Iterable<Memo> memoAll = memoRepository.findAll();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("memo");
        mav.addObject("memoAll", memoAll);
        return mav;
    }

    // 메모 쓰기
    @PostMapping(path="/write")
    public String writeNewMemo (
        @RequestParam String writer, 
        @RequestParam String content) {
        Memo m = new Memo();
        m.setWriter(writer);
        m.setContent(content);
        memoRepository.save(m);
        return "redirect:/memo";
    }

    // 메모 모두 지우기
    @PostMapping(path="/clear")
    public String clearAllMemos() {
        memoRepository.deleteAll();
        return "redirect:/memo";
    }

}
