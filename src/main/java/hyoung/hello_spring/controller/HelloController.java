package hyoung.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    /*
        1. 정적 컨텐츠 : cotroller 찾아보고 없으면 html 바로 client에게
        2. MVC(Model View Controller)와 템플릿 엔진
        3. API
     */

    @GetMapping("hello") //Get
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc") //template 방식
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";

        // 그냥 실행하면 에러 뜸.
        // hello-mvc?name=전달값 으로 name 값을 넘겨줘야함.
    }

    @GetMapping("hello-string")
    @ResponseBody //http body에 return 내용을 직접 넣어주겠다는 의미.
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api") // 객체 반환
    @ResponseBody //http body에 return 내용을 직접 넣어주겠다는 의미.
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
        // name = spring일 때 result : {"name":"spring"}
    }

    static class Hello {
        private String name;

        //command + n
        //프로퍼티 접근방식
        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }

    }
}
