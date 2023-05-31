package com.care.root;

import java.awt.List;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.board.dto.boardDTO;
import com.care.root.board.service.boardService;
import com.care.root.member.common.memberLoginSession;
import com.care.root.member.dto.memberDTO;
import com.care.root.mybatis.board.boardMapper;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController implements memberLoginSession{

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );

		return "home";
	}
	@GetMapping("index")
	public String index(){
		
		System.out.println("컨트롤러 index 실행");
		return "index";
	}
	//	@RequestParam String writer, @RequestParam String content
	//	@GetMapping("index")
	//	public String getbestReview(Model model) {
	//
	//		model.addAttribute("best1",mapper.getBestReview());
	////		model.addAttribute("best2",bs.bestReview2(memberId));
	////		model.addAttribute("best3",bs.bestReview3(memberId));
	//
	//		return "index";
	//	}
	
//	@GetMapping("bestList")
//	public String myReview(HttpSession session, Model model)throws Exception {
//		System.out.println("내가 쓴글 페이지 연결");
//		//세션 객체 안에 있는 ID정보 저장
//		String id = (String) session.getAttribute(LOGIN);
//		System.out.println("getid :  "+id);
//		
//		memberDTO userInfo = ms.getInfo(id);
//		model.addAttribute("myInfo", userInfo);
//		return "member/myReview";
//	}

}