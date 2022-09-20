package com.care.board.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.care.board.board.dto.boardReplyDTO;
import com.care.board.board.service.boardService;
import com.care.board.commonSession.loginSessionName;

@RestController //jsp가 아니라 데이터를 리턴으로 돌려준다
@RequestMapping("board")
public class boardReplyController implements loginSessionName {
	@Autowired boardService bs;

	@PostMapping(value="addReply", produces = "application/json; charset=utf-8")
	public String addReply(@RequestBody Map<String, Object> map, HttpSession session){ //requestbody로 json받아주었다.map에 키와값 들어오게,세션만들고

		boardReplyDTO dto = new boardReplyDTO();
		dto.setReplyer( (String)session.getAttribute(LOGIN) );
		dto.setReplyGroup( Integer.parseInt((String)map.get("write_num")) ); //원글에 대한 그룹번호를 원글번호와 맞추자
		dto.setTitle((String)map.get("title"));
		dto.setReplyContent((String)map.get("replyContent"));

		return bs.addReply(dto);

	}
	//댓글 가져오기
	@GetMapping(value="replyData/{replyGroup}", produces="application/json;charset=utf-8")
	public List<boardReplyDTO> replyData(@PathVariable int replyGroup) {
		return bs.getReplyList(replyGroup);
	}

}
