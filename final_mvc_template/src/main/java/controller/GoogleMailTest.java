package controller;

import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.MyAuthentication;
import util.GmailAuthentication;

import java.io.IOException;
import java.util.Properties;

public class GoogleMailTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Google 메일 발송 처리
		MyAuthentication ma = new MyAuthentication();
		// 연결할 메일서버 정보를 저장하는 Properties 객체
		Properties prop = new Properties();
		
		// TLS(Transfer Layer Security) - 587
		prop.put("mail.smtp.host", "smtp.gmail.com"); // (호스트, 메일서버)
		prop.put("mail.smtp.auth", "true"); // (메일 권한, 사용여부)
		prop.put("mail.smtp.starttls.enable", "true"); // (tls, 사용여부)
		prop.put("mail.smtp.port", "587"); // (포트, 번호)
			
		// SSL(Secure Socket Layer) - 465
		/*
		 * prop.put("mail.smtp.host", "smtp.gmail.com"); // (호스트, 메일서버)
		 * prop.put("mail.smtp.auth", "true"); // (메일 권한, 사용여부)
		 * prop.put("mail.smtp.port", "465"); // (포트, 번호)
		 * prop.put("mail.smtp.startssl.enable", "true"); // (ssl, 사용여부)
		 * prop.put("mail.smtp.startssl.trust", "smtp.gmail.com"); // (ssl 발급 대상자, 메일서버)
		 */		
		
		// 메일 발송을 위한 메일 서버와 연결 정보
		GmailAuthentication gm = new GmailAuthentication();
		// (어떤 메일 서버를 이용할 것인지 , 연결될 계정 정보)
		Session session = Session.getDefaultInstance(gm.getProp(), gm);
		
		// 수취인 - 받는 사람
		// 메일 제목
		// 발신자 정보
		// 메일 내용
		try {
			MimeMessage msg = new MimeMessage(session);
			// 받는 사람 - Recipient
			InternetAddress to = new InternetAddress("a63514894@gmail.com");
			msg.setRecipient(Message.RecipientType.TO, to); 
			// TO - 받는사람
			// CC - 참조
			// BCC - 숨은 참조
			InternetAddress from = new InternetAddress("master@bitc.com", "MASTER");
			// 발신자 정보 등록
			msg.setFrom(from);
			
			// 제목
			msg.setSubject("메일 발송 테스트", "UTF-8");
			// 내용 형식 지정
			/* msg.setHeader("Content-Type", "text/plain;charset=utf-8"); */
			msg.setContent("<h1>테스트 내용입니다.</h1>", "text/html;charset=utf-8");
			
			// 메일 발송 요청
			// 메일 발송이 완료되거나 메일 발송 실패 확인 까지 blocking
			Transport.send(msg);
			System.out.println("메일 발송 완료");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("메일 전송 실패");
		}
		
		response.sendRedirect(request.getContextPath()+"/main");
	}
}
