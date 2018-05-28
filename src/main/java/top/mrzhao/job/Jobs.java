package top.mrzhao.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by ZY on 2018/5/26.
 */
@Component
public class Jobs {
    public final static long TWO_Minute =  2 * 60 * 1000;

    @Scheduled(fixedDelay=TWO_Minute)
    public void fixedDelayJob(){
//        System.out.println(new Date()+" >>fixedDelay执行....");
//        String userName = "2402076197@qq.com"; // 发件人邮箱
//        String password = "acpnnfsqbdwpdhgd"; // 发件人密码
//        String smtpHost = "smtp.qq.com"; // 邮件服务器
//
//        String to = "746234304@qq.com"; // 收件人，多个收件人以半角逗号分隔
//        String cc = ""; // 抄送，多个抄送以半角逗号分隔
//        String subject = "这是test邮件的主题"; // 主题
//        String body = "这是邮件的正文/n换行测试<br>换行测试"; // 正文，可以用html格式的哟
//        List<String> attachments = Arrays.asList(); // 附件的路径，多个附件也不怕
//
//        Email email = Email.entity(smtpHost, userName, password, to, cc, subject, body, attachments);
//
//        try {
//            email.send();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(new Date()+" >>fixedDelay执行完毕....");
    }

    @Scheduled(fixedRate=TWO_Minute)
    public void fixedRateJob(){
        System.out.println(new Date()+" >>fixedRate执行....");
    }

    @Scheduled(cron="0 15 3 * * ?")
    public void cronJob(){
        System.out.println(new Date()+" >>cron执行....");
    }
}

