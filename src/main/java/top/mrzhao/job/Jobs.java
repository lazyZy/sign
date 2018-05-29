package top.mrzhao.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.mrzhao.entity.Meeting;
import top.mrzhao.entity.User;
import top.mrzhao.entity.UserMeeting;
import top.mrzhao.mail.Email;
import top.mrzhao.service.MeetingService;
import top.mrzhao.service.UserMeetingService;
import top.mrzhao.service.UserService;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by ZY on 2018/5/26.
 */
@Component
public class Jobs {
    Logger logger = LoggerFactory.getLogger(Jobs.class);
    public final static long TWO_Minute =  2 * 60 * 1000;

    @Autowired
    MeetingService meetingService;

    @Autowired
    UserMeetingService userMeetingService;

    @Autowired
    UserService userService;

    @Scheduled(fixedDelay=TWO_Minute)
    public void fixedDelayJob(){
        logger.info("{} >>会议通知执行....",new Date());
        String userName = "2402076197@qq.com"; // 发件人邮箱
        String password = "acpnnfsqbdwpdhgd"; // 发件人密码
        String smtpHost = "smtp.qq.com"; // 邮件服务器

        List<Meeting> meetings = meetingService.SelectMeetingByStatusAndTime();
        for(Meeting meeting : meetings){
            String to = "";
            List<UserMeeting> userMeetings = userMeetingService.SelectNotCheckByMeetingId(meeting.getMeetingId());
            for(UserMeeting userMeeting : userMeetings){
                userMeetingService.ChangeCheckStatus(userMeeting.getUserId(),userMeeting.getMeetingId());
                User user = (User)userService.UserInfoById(userMeeting.getUserId()).getData();
                to = to+user.getUserEmail()+",";
            }
            to = to.substring(0,to.length()-1);
            String cc = ""; // 抄送，多个抄送以半角逗号分隔
            String subject = meeting.getMeetingName(); // 主题
            String body = meeting.getMeetingContent()+"<br>会议时间："+meeting.getMeetingTime(); // 正文，可以用html格式的哟
            List<String> attachments = Arrays.asList(); // 附件的路径，多个附件也不怕

            Email email = Email.entity(smtpHost, userName, password, to, cc, subject, body, attachments);

            try {
                email.send();
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
        logger.info("{} >>会议通知执行完毕....",new Date());
    }

//    @Scheduled(fixedRate=TWO_Minute)
//    public void fixedRateJob(){
//        System.out.println(new Date()+" >>fixedRate执行....");
//    }
//
//    @Scheduled(cron="0 15 3 * * ?")
//    public void cronJob(){
//        System.out.println(new Date()+" >>cron执行....");
//    }
}

