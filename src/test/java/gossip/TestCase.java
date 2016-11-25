package gossip;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestCase {
	static Map<String,String> map  = new HashMap<String, String>();
	
	Logger logger = LoggerFactory.getLogger(TestCase.class);
//	@Test
	public void getLastWeekDateRange(){
//		DateTimeFormatter mDateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
//		String pre = "2015-04-23 23:59:59";
//		String post = "2015-04-24 0:59:59";
//		
//		String tmp="";
//		
//		
//		LocalDate ld_pre = mDateTimeFormatter.parseLocalDate(pre);
//		
//		LocalDate ld_post = mDateTimeFormatter.parseLocalDate(post);
//		
//		while(ld_pre.compareTo(ld_post)<0){
//			logger.debug("pre day  : {}",ld_pre.toString(mDateTimeFormatter));
//			ld_pre = ld_pre.plusDays(1);
//		}
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		List<String> dateList = new LinkedList<String>();
//		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
//		cal.getTime();
//		int sevenDay = 7;
//		cal.add(Calendar.DAY_OF_YEAR,-sevenDay-1);
//		for(int i=0;i<sevenDay;i++){
//			cal.add(Calendar.DAY_OF_YEAR, 1);
//			dateList.add(sdf.format(cal.getTime()));
//		}
//		logger.debug("last week range : {}",dateList.toString());
//		
//		
//		LocalDate recoderDate = new LocalDate(0);
//		
//		logger.debug("recoderDate in millis  : {}",recoderDate);
	}
//	@Test
	public void mapInMultiThread(){
		for( int i = 0 ;i<100;i++){
			Thread thread = new Thread(i+""){
				public void run() {
					int counter = Integer.valueOf(getName())*10000;
					for(int i=0;i<100;i++){
						map.put(String.valueOf(counter), String.valueOf(counter));
						counter++;
					}
				};
			};
			thread.run();
		}
		logger.info("map size  :{}",map.size());
//		logger.info("map :{}",map);
	}
	
//	@Test
	public void sendMail(){
        Properties props = new Properties();
        String host = "smtp.qq.com";
        String from = "lyxx@ly-sky.com";
        String subject = "测试标题";
        String content = "测试内容，，，，鸟";
        
        String to = "lideda@ly-sky.com";
        
        String user = "lyxx@ly-sky.com";
        String password = "ly-sky123456";
        
        
        props.put("mail.smtp.host", host); // 指定SMTP服务器

        props.put("mail.smtp.auth", "true"); // 指定是否需要SMTP验证

       
        
        try {

            Session mailSession = Session.getDefaultInstance(props);

            Message message = new MimeMessage(mailSession);

            message.setFrom(new InternetAddress(from)); // 发件人

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); // 收件人

            message.setSubject(subject); // 邮件主题

            message.setText(content); // 邮件内容

            message.saveChanges();

            Transport transport = mailSession.getTransport("smtp");

            transport.connect(host, user, password);

            transport.sendMessage(message, message.getAllRecipients());

            transport.close();

        } catch(Exception e) {

            System.out.println(e);

        }
	}
	
	@Test
	public void error(){
		logger.error("getLast7Days = "+getLast7Days().toString());
//		logger.error("string plus null = "+null);
//		try{
//			throw new NullPointerException();
//		}catch(Exception e){
//			
//			logger.error( "error msg : {}" ,e.getStackTrace());
//		}
	}
	//获得最近7天的日期
	private List<String> getLast7Days(){
		DateTimeFormatter mDateFormattor = DateTimeFormat.forPattern("yyyy-MM-dd");
		List<String> dateList = new LinkedList<String>();
		LocalDate ld = new LocalDate();
		for(int i=7;i>0;i--){
			LocalDate tmp = ld.plusDays(0-i);
			dateList.add(tmp.toString(mDateFormattor));
		}
		return dateList;
	}
	
}